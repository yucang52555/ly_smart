package com.smart.mvc.exception;

import com.smart.mvc.enums.ErrorType;

/**
 * 自定义异常
 * @author kangtiancheng
 * @date 2017年8月19日
 */
public abstract class AbstractCustomException extends Exception {

    /**
     * 序列化ID
     */
    private static final long serialVersionUID = 1L;

    private ErrorType errorType;

    public AbstractCustomException() {
        this.setErrorType(ErrorType.UNKNOW_ERROR);
    }

    public AbstractCustomException(ErrorType errorType) {
        super();
        this.setErrorType(errorType);
    }

    public AbstractCustomException(String msg) {
        super(msg);
        this.setErrorType(ErrorType.UNKNOW_ERROR);
    }

    public AbstractCustomException(String msg, ErrorType errorType) {
        super(msg);
        this.setErrorType(errorType);
    }

    public AbstractCustomException(String msg, Throwable cause) {
        super(msg, cause);
        this.setErrorType(ErrorType.UNKNOW_ERROR);
    }

    public AbstractCustomException(String msg, ErrorType errorType, Throwable cause) {
        super(msg, cause);
        this.setErrorType(errorType);
    }

    public AbstractCustomException(Throwable cause) {
        super(cause);
        this.setErrorType(ErrorType.UNKNOW_ERROR);
    }

    public AbstractCustomException(ErrorType errorType, Throwable cause) {
        super(cause);
        this.setErrorType(errorType);
    }

    public ErrorType getErrorType() {
        return errorType;
    }

    public void setErrorType(ErrorType errorType) {
        this.errorType = errorType;
    }
}
