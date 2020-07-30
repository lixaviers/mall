package com.suyan.exception;


import com.suyan.result.ResultCode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.Enumeration;
import java.util.Map;
import java.util.Properties;
import java.util.concurrent.ConcurrentHashMap;

public class CommonException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    private static final Logger LOGGER = LoggerFactory.getLogger(CommonException.class);

    private static Map<Integer, String> SERVICE_EXCEPTION_MAP = null;

    private static final String SERVICE_EXCEPTION_FILE = "META-INF/exception_def.properties";

    /**
     * 异常错误代码
     */
    private Integer code;
    /**
     * 异常错误信息
     */
    private String message;

    public CommonException(Integer code) {
        this.code = code;
        this.message = matchMessage(code);
    }

    public CommonException(Integer code, String message) {
        this.code = code;
        this.message = message;

        if (this.message == null || "".equals(this.message)) {
            this.message = matchMessage(code);
        }
    }


    public CommonException(Integer code, String message, Object... args) {
        super(message);

        this.code = code;
        if (args == null || args.length == 0) {
            this.message = message;
        } else {
            this.message = String.format(message, args);
        }
    }

    public CommonException(ResultCode resultCode) {
        this(resultCode.getCode(), resultCode.getDesc());
    }

    public CommonException(ResultCode resultCode, Object... args) {
        this(resultCode.getCode(), resultCode.getDesc(), args);
    }

    private synchronized void loadExceptionDef() {
        LOGGER.info("load exception definition");
        SERVICE_EXCEPTION_MAP = new ConcurrentHashMap<>();
        try {
            Enumeration<URL> exceptionDefs = ClassLoader.getSystemResources(SERVICE_EXCEPTION_FILE);
            while (exceptionDefs.hasMoreElements()) {
                URL exceptionDef = exceptionDefs.nextElement();

                LOGGER.info("load exception definition from {}", exceptionDef);

                InputStream in = new BufferedInputStream(exceptionDef.openStream());
                Properties properties = new Properties();
                properties.load(new InputStreamReader(in, StandardCharsets.UTF_8));
                for (String name : properties.stringPropertyNames()) {
                    Integer eCode = null;
                    try {
                        eCode = Integer.valueOf(name);
                    } catch (Exception e) {
                        LOGGER.warn("{} not a int code!", name);
                    }
                    if (eCode != null) {
                        SERVICE_EXCEPTION_MAP.put(eCode, properties.getProperty(name));
                    }
                }
            }
        } catch (IOException e) {
            LOGGER.error("load exception definition error", e);
        }

        LOGGER.info("all service exception {}", SERVICE_EXCEPTION_MAP);
    }

    protected String matchMessage(Integer code) {
        if (SERVICE_EXCEPTION_MAP == null) {
            this.loadExceptionDef();
        }

        String msg = (String) SERVICE_EXCEPTION_MAP.get(code);
        if (msg == null || "".equals(msg)) {
            LOGGER.warn("undefined exception message! code = {}", code);
            msg = "undefined exception message!";
        }

        return msg;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    @Override
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public CommonException() {
        super();
    }

    public CommonException(String message) {
        super(message);
    }

    public CommonException(String message, Throwable cause) {
        super(message, cause);
    }

    public CommonException(Throwable cause) {
        super(cause);
    }

}