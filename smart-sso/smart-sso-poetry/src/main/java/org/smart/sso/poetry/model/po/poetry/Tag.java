package org.smart.sso.poetry.model.po.poetry;

import java.io.Serializable;
import java.util.Date;

/**
 * 古诗文标签
 * @author kangtiancheng
 * @date 2017年6月20日
 */
public class Tag implements Serializable{

	private static final long serialVersionUID = -8364620467125905345L;

	private Long id;
	
	private String tagName;
	
	private String tagUrl;
	
	private Date createTime;
	
	private Date updateTime;
	
	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	public String getTagName() {
		return tagName;
	}
	
	public void setTagName(String tagName) {
		this.tagName = tagName;
	}
	
	public String getTagUrl() {
		return tagUrl;
	}

	public void setTagUrl(String tagUrl) {
		this.tagUrl = tagUrl;
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
	
}
