package org.smart.sso.poetry.model.bo.poetry;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import org.smart.sso.poetry.model.po.poetry.Minju;

/**
 * 每日推荐名句对象封装
 * @author kangtiancheng
 * @date 2017年7月24日
 */
public class MinjuRecommendBo {
	private Long id;
	
	private String minjuContent;
	
	private String sourcePoetry;

	public MinjuRecommendBo(Minju minju) {
		this.id = minju.getId();
		this.minjuContent = minju.getMinjuContent();
		this.sourcePoetry = minju.getSourcePoetry();
	}
	
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

	public String getSourcePoetry() {
		return sourcePoetry;
	}

	public void setSourcePoetry(String sourcePoetry) {
		this.sourcePoetry = sourcePoetry;
	}

	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this, ToStringStyle.SHORT_PREFIX_STYLE);
	}
}
