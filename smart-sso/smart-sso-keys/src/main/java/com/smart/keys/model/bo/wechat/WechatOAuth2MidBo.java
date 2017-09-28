package com.smart.keys.model.bo.wechat;

/**
 * 小程序登录令牌
 * @author kangtiancheng
 * @date 2017年8月19日
 */
public class WechatOAuth2MidBo {
    private String openid;
    private String session_key;
    private String unionid;
    private String wechatErrorCode;
    private String wechatErrorMsg;

	public String getOpenid() {
		return openid;
	}
	
	public void setOpenid(String openid) {
		this.openid = openid;
	}
	
	public String getSession_key() {
		return session_key;
	}
	
	public void setSession_key(String session_key) {
		this.session_key = session_key;
	}

	
	public String getUnionid() {
		return unionid;
	}

	
	public void setUnionid(String unionid) {
		this.unionid = unionid;
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
}
