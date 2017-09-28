package com.smart.mvc.exception;

import com.smart.mvc.enums.ErrorType;

/**
 * 业务逻辑异常
 * @author kangtiancheng
 * @date 2017年8月19日
 */
public class BusinessException extends AbstractCustomException {   

	/**
     * 序列号
     */
	private static final long serialVersionUID = -1241924527611472854L;

    public BusinessException() {
    }

    public BusinessException(ErrorType errorType) {
        super(errorType);
    }

    public BusinessException(String msg) {
        super(msg);
    }

    public BusinessException(String msg, ErrorType errorType) {
        super(msg, errorType);
    }

    public BusinessException(String msg, Throwable cause) {
        super(msg, cause);
    }

    public BusinessException(String msg, ErrorType errorType, Throwable cause) {
        super(msg, errorType, cause);
    }

    public BusinessException(Throwable cause) {
        super(cause);
    }

    public BusinessException(ErrorType errorType, Throwable cause) {
        super(errorType, cause);
    }
}
