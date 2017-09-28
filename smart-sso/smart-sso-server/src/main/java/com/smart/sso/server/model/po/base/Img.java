package com.smart.sso.server.model.po.base;

import java.util.Date;

import com.alibaba.fastjson.annotation.JSONField;
import com.smart.mvc.model.PersistentObject;

/**
 * 图片
 * @author kangtiancheng
 * @date 2017年5月17日
 */
public class Img extends PersistentObject {

	private static final long serialVersionUID = 7822463122176067371L;
	
	/** 名称 */
	private String imgCode;
	/** 编码  */
	private String imgName;
	/** 状态  */
	private Integer imgUrl;
	/** 创建时间 */
	@JSONField(format = "yyyy-MM-dd HH:mm:ss")
	private Date createTime;
	
	public Img(){
	}
	
	public Img(String imgCode, String imgName, Integer imgUrl, Date createTime) {
		super();
		this.imgCode = imgCode;
		this.imgName = imgName;
		this.imgUrl = imgUrl;
		this.createTime = createTime;
	}

	public Date getCreateTime() {
		return this.createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	
	public String getImgCode() {
		return imgCode;
	}
	
	public void setImgCode(String imgCode) {
		this.imgCode = imgCode;
	}
	
	public String getImgName() {
		return imgName;
	}
	
	public void setImgName(String imgName) {
		this.imgName = imgName;
	}
	
	public Integer getImgUrl() {
		return imgUrl;
	}
	
	public void setImgUrl(Integer imgUrl) {
		this.imgUrl = imgUrl;
	}
}
