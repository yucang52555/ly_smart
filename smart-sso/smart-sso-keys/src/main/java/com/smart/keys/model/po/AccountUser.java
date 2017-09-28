package com.smart.keys.model.po;

import java.util.Date;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import com.smart.keys.model.bo.wechat.WechatUserInfoBo;
import com.smart.mvc.model.PersistentObject;

/**
 * 微信用户
 * @author kangtiancheng
 * @date 2017年8月19日
 */
public class AccountUser extends PersistentObject {
	
    private static final long serialVersionUID = -3521900744956817286L;

    private String wechatOpenId;

    private String wechatUnionId;

    private String wechatNickname;//微信昵称

    private String wechatSex;//微信性别

    private String wechatCountry;//微信国籍

    private String wechatProvince;//微信省份

    private String wechatCity;//微信城市

    private String wechatImageurl;//微信用户头像

    private Integer userStatus;//用户状态

    private Integer userType;//用户类型

    private String userName;//用户名

    private String userMobile;//用户手机号
    
    private String gesturePassword;//手势密码

    private Date createTime;

    private Date updateTime;

    public AccountUser() {}
    
    public AccountUser(WechatUserInfoBo userInfoBo) {
    	this.wechatCity = StringUtils.isNotBlank(userInfoBo.getWechatCity()) ? userInfoBo.getWechatCity() : null;
    	this.wechatCountry = StringUtils.isNotBlank(userInfoBo.getWechatCountry()) ? userInfoBo.getWechatCountry() : null;
    	this.wechatImageurl = StringUtils.isNotBlank(userInfoBo.getWechatHeadImgUrl()) ? userInfoBo.getWechatHeadImgUrl() : null;
    	this.wechatNickname = StringUtils.isNotBlank(userInfoBo.getWechatNickName()) ? userInfoBo.getWechatNickName() : null;;
    	this.wechatOpenId = StringUtils.isNotBlank(userInfoBo.getWechatOpenId()) ? userInfoBo.getWechatOpenId() : null;;
    	this.wechatProvince = StringUtils.isNotBlank(userInfoBo.getWechatProvince()) ? userInfoBo.getWechatProvince() : null;;
    	this.wechatSex = StringUtils.isNotBlank(userInfoBo.getWechatSex()) ? userInfoBo.getWechatSex() : null;
    	this.wechatUnionId = StringUtils.isNotBlank(userInfoBo.getWechatUnionId()) ? userInfoBo.getWechatUnionId() : null;
    	this.gesturePassword = StringUtils.isNotBlank(userInfoBo.getGesturePassword()) ? userInfoBo.getGesturePassword() : null;
    }
    
    public AccountUser initAccountUser(WechatUserInfoBo userInfoBo) {
    	this.wechatCity = StringUtils.isNotBlank(userInfoBo.getWechatCity()) ? userInfoBo.getWechatCity() : null;
    	this.wechatCountry = StringUtils.isNotBlank(userInfoBo.getWechatCountry()) ? userInfoBo.getWechatCountry() : null;
    	this.wechatImageurl = StringUtils.isNotBlank(userInfoBo.getWechatHeadImgUrl()) ? userInfoBo.getWechatHeadImgUrl() : null;
    	this.wechatNickname = StringUtils.isNotBlank(userInfoBo.getWechatNickName()) ? userInfoBo.getWechatNickName() : null;;
    	this.wechatOpenId = StringUtils.isNotBlank(userInfoBo.getWechatOpenId()) ? userInfoBo.getWechatOpenId() : null;;
    	this.wechatProvince = StringUtils.isNotBlank(userInfoBo.getWechatProvince()) ? userInfoBo.getWechatProvince() : null;;
    	this.wechatSex = StringUtils.isNotBlank(userInfoBo.getWechatSex()) ? userInfoBo.getWechatSex() : null;
    	this.wechatUnionId = StringUtils.isNotBlank(userInfoBo.getWechatUnionId()) ? userInfoBo.getWechatUnionId() : null;
    	this.gesturePassword = StringUtils.isNotBlank(userInfoBo.getGesturePassword()) ? userInfoBo.getGesturePassword() : this.gesturePassword;
    	return this;
    }
    
    public String getWechatOpenId() {
        return wechatOpenId;
    }

    public void setWechatOpenId(String wechatOpenId) {
        this.wechatOpenId = wechatOpenId == null ? null : wechatOpenId.trim();
    }

    public String getWechatUnionId() {
        return wechatUnionId;
    }

    public void setWechatUnionId(String wechatUnionId) {
        this.wechatUnionId = wechatUnionId == null ? null : wechatUnionId.trim();
    }

    public String getWechatNickname() {
        return wechatNickname;
    }

    public void setWechatNickname(String wechatNickname) {
        this.wechatNickname = wechatNickname == null ? null : wechatNickname.trim();
    }

    public String getWechatSex() {
        return wechatSex;
    }

    public void setWechatSex(String wechatSex) {
        this.wechatSex = wechatSex == null ? null : wechatSex.trim();
    }

    public String getWechatCountry() {
        return wechatCountry;
    }

    public void setWechatCountry(String wechatCountry) {
        this.wechatCountry = wechatCountry == null ? null : wechatCountry.trim();
    }

    public String getWechatProvince() {
        return wechatProvince;
    }

    public void setWechatProvince(String wechatProvince) {
        this.wechatProvince = wechatProvince == null ? null : wechatProvince.trim();
    }

    public String getWechatCity() {
        return wechatCity;
    }

    public void setWechatCity(String wechatCity) {
        this.wechatCity = wechatCity == null ? null : wechatCity.trim();
    }

    public String getWechatImageurl() {
        return wechatImageurl;
    }

    public void setWechatImageurl(String wechatImageurl) {
        this.wechatImageurl = wechatImageurl == null ? null : wechatImageurl.trim();
    }

    public Integer getUserStatus() {
        return userStatus;
    }

    public void setUserStatus(Integer userStatus) {
        this.userStatus = userStatus;
    }

    public Integer getUserType() {
        return userType;
    }

    public void setUserType(Integer userType) {
        this.userType = userType;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName == null ? null : userName.trim();
    }

    public String getUserMobile() {
        return userMobile;
    }

    public void setUserMobile(String userMobile) {
        this.userMobile = userMobile == null ? null : userMobile.trim();
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

	public String getGesturePassword() {
		return gesturePassword;
	}

	public void setGesturePassword(String gesturePassword) {
		this.gesturePassword = gesturePassword;
	}

	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this, ToStringStyle.SHORT_PREFIX_STYLE);
	}
	
    
}