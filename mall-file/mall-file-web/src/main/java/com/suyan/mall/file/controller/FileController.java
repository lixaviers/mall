package com.suyan.mall.file.controller;

import com.suyan.controller.BaseController;
import com.suyan.mall.file.config.StorageConfig;
import com.suyan.mall.file.service.QiniuCloudStorageService;
import com.suyan.result.Result;
import com.suyan.result.ResultCode;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import java.util.HashMap;
import java.util.Map;


@Controller
@RequestMapping("upload")
@Slf4j
public class FileController extends BaseController {

    @Autowired
    private StorageConfig storageConfig;

    @Autowired
    private QiniuCloudStorageService qiniuCloudStorageService;


    @ApiOperation(value = "上传文件", notes = "上传文件(不能超过10M)")
    @ResponseBody
    @PostMapping("")
    private Result<String> uploadFile(@RequestParam("file") MultipartFile multiFile) {
        Result<String> result = Result.newSuccess();
        if (null == multiFile) {
            result.setErrorCode(ResultCode.FIELD_NOT_ALLOWED_EMPTY, "文件");
            return result;
        }

        if (multiFile.getSize() <= 0) {
            result.setErrorCode(ResultCode.UPLOAD_FILE_ERROR, "文件过小");
            return result;
        }
        if (multiFile.getSize() > storageConfig.getMaxUploadFileSize()) {
            result.setErrorCode(ResultCode.UPLOAD_FILE_ERROR, "文件大小不能超过10M");
            return result;
        }

        try {
            if (null == multiFile.getInputStream()) {
                result.setErrorCode(ResultCode.UPLOAD_FILE_ERROR, "请上传正确的文件");
                return result;
            }

            Map<String, String> metaDataMap = new HashMap<>(1, 1);
            metaDataMap.put("size", String.valueOf(multiFile.getBytes().length));

            String url = qiniuCloudStorageService.upload(multiFile.getInputStream(), multiFile.getOriginalFilename());
            result.setData(url);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            result.setErrorCode(ResultCode.SYS_ERROR);
        }

        return result;
    }


}
