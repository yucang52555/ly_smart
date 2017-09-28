package com.smart.keys.model.bo.wechat;

import com.smart.keys.model.param.WechatUserInfoParam;

/**
 * 微信用户信息
 * @author kangtiancheng
 * @date 2017年8月19日
 */
public class WechatUserInfoBo {
    private String wechatOpenId;
    private String wechatNickName;
    private String wechatSex;
    private String wechatProvince;
    private String wechatCity;
    private String wechatCountry;
    private String wechatHeadImgUrl;
    private String wechatUnionId;
    private String gesturePassword;
    private String ssid;
    
    public WechatUserInfoBo(){
    	
    }

    public WechatUserInfoBo(WechatOAuth2MidBo wechatOAuth2MidBo) {
		this.wechatOpenId = wechatOAuth2MidBo.getOpenid();
	}
    
    public WechatUserInfoBo(WechatUserInfoParam userInfoParam) {
		this.wechatOpenId = userInfoParam.getWechatOpenId();
		this.wechatNickName = userInfoParam.getWechatNickName();
		this.wechatSex = userInfoParam.getWechatSex();
		this.wechatProvince = userInfoParam.getWechatProvince();
		this.wechatCity = userInfoParam.getWechatCity();
		this.wechatCountry = userInfoParam.getWechatCountry();
		this.wechatHeadImgUrl = userInfoParam.getWechatHeadImgUrl();
		this.gesturePassword = userInfoParam.getGesturePassword();
	}

	public String getSsid() {
		return ssid;
	}

	public void setSsid(String ssid) {
		this.ssid = ssid;
	}

	public String getWechatOpenId() {
        return wechatOpenId;
    }

    public void setWechatOpenId(String wechatOpenId) {
        this.wechatOpenId = wechatOpenId;
    }

    public String getWechatNickName() {
        return wechatNickName;
    }

    public void setWechatNickName(String wechatNickName) {
        this.wechatNickName = wechatNickName;
    }

    public String getWechatSex() {
        return wechatSex;
    }

    public void setWechatSex(String wechatSex) {
        this.wechatSex = wechatSex;
    }

    public String getWechatProvince() {
        return wechatProvince;
    }

    public void setWechatProvince(String wechatProvince) {
        this.wechatProvince = wechatProvince;
    }

    public String getWechatCity() {
        return wechatCity;
    }

    public void setWechatCity(String wechatCity) {
        this.wechatCity = wechatCity;
    }

    public String getWechatCountry() {
        return wechatCountry;
    }

    public void setWechatCountry(String wechatCountry) {
        this.wechatCountry = wechatCountry;
    }

    public String getWechatHeadImgUrl() {
        return wechatHeadImgUrl;
    }

    public void setWechatHeadImgUrl(String wechatHeadImgUrl) {
        this.wechatHeadImgUrl = wechatHeadImgUrl;
    }

    public String getWechatUnionId() {
        return wechatUnionId;
    }

    public void setWechatUnionId(String wechatUnionId) {
        this.wechatUnionId = wechatUnionId;
    }

	public String getGesturePassword() {
		return gesturePassword;
	}

	public void setGesturePassword(String gesturePassword) {
		this.gesturePassword = gesturePassword;
	}
    
}
