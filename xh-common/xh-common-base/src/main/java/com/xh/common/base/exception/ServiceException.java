package com.xh.common.base.exception;

/**
 * 2021-09-26 sunxh
 * 业务异常，用于service抛出业务错误信息
 */
public class ServiceException extends RuntimeException {

    public ServiceException(String message) {
        super(message);
    }

    public ServiceException(Throwable e) {
        super(e);
    }
}
