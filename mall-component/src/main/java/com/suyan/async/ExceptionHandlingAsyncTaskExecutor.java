/*
 * Copyright (c) 2020.
 * 项目名称：素焉商城
 * 创建人：素焉
 * 开源地址: https://github.com/lixaviers/mall
 */
package com.suyan.async;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.core.task.AsyncTaskExecutor;

import java.util.concurrent.Callable;
import java.util.concurrent.Future;

public class ExceptionHandlingAsyncTaskExecutor implements AsyncTaskExecutor, InitializingBean, DisposableBean {
    static final String EXCEPTION_MESSAGE = "Caught async exception";
    private final Logger LOGGER = LoggerFactory.getLogger(ExceptionHandlingAsyncTaskExecutor.class);
    private final AsyncTaskExecutor executor;

    public ExceptionHandlingAsyncTaskExecutor(AsyncTaskExecutor executor) {
        this.executor = executor;
    }

    @Override
    public void execute(Runnable task) {
        executor.execute(createWrappedRunnable(task));
    }

    @Override
    public void execute(Runnable task, long startTimeout) {
        executor.execute(createWrappedRunnable(task), startTimeout);
    }

    private <T> Callable<T> createCallable(final Callable<T> task) {
        return () -> {
            try {
                return task.call();
            } catch (Exception e) {
                handle(e);
                throw e;
            }
        };
    }

    private Runnable createWrappedRunnable(final Runnable task) {
        return () -> {
            try {
                task.run();
            } catch (Exception e) {
                handle(e);
            }
        };
    }

    protected void handle(Exception e) {
        LOGGER.error(EXCEPTION_MESSAGE, e);
    }

    @Override
    public Future<?> submit(Runnable task) {
        return executor.submit(createWrappedRunnable(task));
    }

    @Override
    public <T> Future<T> submit(Callable<T> task) {
        return executor.submit(createCallable(task));
    }

    @Override
    public void destroy() throws Exception {
        if (executor instanceof DisposableBean) {
            DisposableBean bean = (DisposableBean) executor;
            bean.destroy();
        }
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        if (executor instanceof InitializingBean) {
            InitializingBean bean = (InitializingBean) executor;
            bean.afterPropertiesSet();
        }
    }
}