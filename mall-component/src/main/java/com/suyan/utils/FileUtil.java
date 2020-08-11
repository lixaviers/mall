package com.suyan.utils;

import org.springframework.core.io.ClassPathResource;

import java.io.IOException;
import java.io.InputStream;

public class FileUtil {
    /**
     * 根据class path读取资源内容
     *
     * @param classPath
     * @return
     * @throws IOException
     */
    public static String getResourceContent(String classPath) throws IOException {
        byte[] data = getClassPathResourceData(classPath);
        if (data != null) {
            return new String(data);
        }
        return null;
    }

    /**
     * 根据class path读取资源内容
     *
     * @param classPath
     * @return
     * @throws IOException
     */
    private static byte[] getClassPathResourceData(String classPath) throws IOException {
        InputStream inputStream = null;
        try {
            ClassPathResource classPathResource = new ClassPathResource(classPath);
            inputStream = classPathResource.getInputStream();
            int length = inputStream.available();
            byte[] data = new byte[length];
            inputStream.read(data, 0, length);
            return data;
        } finally {

        }
    }
}
