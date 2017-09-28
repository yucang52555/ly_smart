package org.smart.sso.poetry.model.po.poetry;

import java.io.Serializable;
import java.util.Date;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * 古诗文-名句
 * @author kangtiancheng
 * @date 2017年6月20日
 */
public class Minju implements Serializable{

	private static final long serialVersionUID = -8364620467125905345L;

	private Long id;
	
	private String minjuContent;
	
	private String minjuUrl;
	
	private String sourcePoetry;
	
	private String sourceUrl;
	
	private Integer recommendFlag;
	
	private Date createTime;
	
	private Date updateTime;
	
	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	public String getMinjuContent() {
		return minjuContent;
	}
	
	public void setMinjuContent(String minjuContent) {
		this.minjuContent = minjuContent;
	}
	
	public String getMinjuUrl() {
		return minjuUrl;
	}
	
	public void setMinjuUrl(String minjuUrl) {
		this.minjuUrl = minjuUrl;
	}
	
	public String getSourcePoetry() {
		return sourcePoetry;
	}
	
	public void setSourcePoetry(String sourcePoetry) {
		this.sourcePoetry = sourcePoetry;
	}
	
	public String getSourceUrl() {
		return sourceUrl;
	}
	
	public void setSourceUrl(String sourceUrl) {
		this.sourceUrl = sourceUrl;
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

	public Integer getRecommendFlag() {
		return recommendFlag;
	}

	public void setRecommendFlag(Integer recommendFlag) {
		this.recommendFlag = recommendFlag;
	}

	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this, ToStringStyle.SHORT_PREFIX_STYLE);
	}
}
