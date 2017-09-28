package com.smart.keys.model.bo.wechat;

import com.alibaba.fastjson.annotation.JSONField;

/**
 * 小程序access_token
 * @author kangtiancheng
 * @date 2017年8月5日
 */
public class WechatAppAssessTokenBo {
    @JSONField(name="access_token")
    private String wechatAccessToken;
    @JSONField(name="errcode")
    private String wechatErrorCode;
    @JSONField(name="errmsg")
    private String wechatErrorMsg;
    @JSONField(name="expires_in")
    private Long expiresIn;

    public String getWechatAccessToken() {
        return wechatAccessToken;
    }

    public void setWechatAccessToken(String wechatAccessToken) {
        this.wechatAccessToken = wechatAccessToken;
    }

    public String getWechatErrorCode() {
        return wechatErrorCode;
    }

    public void setWechatErrorCode(String wechatErrorCode) {
        this.wechatErrorCode = wechatErrorCode;
    }

    public String getWechatErrorMsg() {
        return wechatErrorMsg;
    }

    public void setWechatErrorMsg(String wechatErrorMsg) {
        this.wechatErrorMsg = wechatErrorMsg;
    }

    public Long getExpiresIn() {
        return expiresIn;
    }

    public void setExpiresIn(Long expiresIn) {
        this.expiresIn = expiresIn;
    }
}
