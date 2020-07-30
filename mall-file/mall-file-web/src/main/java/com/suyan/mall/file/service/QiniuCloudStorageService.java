package com.suyan.mall.file.service;

import com.qiniu.common.Zone;
import com.qiniu.http.Response;
import com.qiniu.storage.Configuration;
import com.qiniu.storage.UploadManager;
import com.qiniu.util.Auth;
import com.qiniu.util.IOUtils;
import com.suyan.mall.file.config.StorageConfig;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.InputStream;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.UUID;

/**
 * 七牛云存储
 */
@Service
public class QiniuCloudStorageService implements InitializingBean {

    @Autowired
    private StorageConfig storageConfig;

    private UploadManager uploadManager;
    private String token;

    public QiniuCloudStorageService() {

    }

    private void init() {
        uploadManager = new UploadManager(new Configuration(Zone.autoZone()));
        token = Auth.create(storageConfig.getAccessKey(), storageConfig.getSecretKey()).uploadToken(storageConfig.getBucketName());
    }

    public String upload(InputStream inputStream, String keyName) {
        try {
            // 生成文件名
            String fileExtName = keyName.substring(keyName.lastIndexOf("."));
            String randomName = UUID.randomUUID().toString().replace("-", "");
            String fileName = DateTimeFormatter.ofPattern("yyyyMMdd").format(LocalDateTime.now()) + "/" + randomName + fileExtName;

            byte[] data = IOUtils.toByteArray(inputStream);
            Response res = uploadManager.put(data, fileName, token);
            if (!res.isOK()) {
                throw new RuntimeException("上传七牛出错：" + res.toString());
            }
            res.close();
            return storageConfig.getDomain() + "/" + fileName;
        } catch (Exception e) {
            throw new RuntimeException("上传文件失败，请核对七牛配置信息", e);
        }


    }


    @Override
    public void afterPropertiesSet() throws Exception {
        init();
    }
}
