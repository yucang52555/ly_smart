package org.smart.sso.poetry.model.bo.poetry;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import org.smart.sso.poetry.model.po.poetry.ChapterWithBLOBs;

/**
 * 章节详情
 * @author kangtiancheng
 * @date 2017年8月9日
 */
public class ChapterBo {
	
	private Long id;

    private String charpterName;

	private String charpterContent;
	
	private String translateContent;
	
	public ChapterBo(ChapterWithBLOBs chapterWithBLOB) {
		this.id = chapterWithBLOB.getId();
		this.charpterName = chapterWithBLOB.getCharpterName();
		this.charpterContent = chapterWithBLOB.getCharpterContentStr();
		this.translateContent = chapterWithBLOB.getTranslateContentStr();
	}

	public ChapterBo(String charpterContent, String translateContent) {
		this.charpterContent = charpterContent;
		this.translateContent = translateContent;
	}
	
	public ChapterBo() { }
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCharpterName() {
		return charpterName;
	}

	public void setCharpterName(String charpterName) {
		this.charpterName = charpterName;
	}

	public String getCharpterContent() {
		return charpterContent;
	}

	public void setCharpterContent(String charpterContent) {
		this.charpterContent = charpterContent;
	}

	public String getTranslateContent() {
		return translateContent;
	}

	public void setTranslateContent(String translateContent) {
		this.translateContent = translateContent;
	}

	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this, ToStringStyle.SHORT_PREFIX_STYLE);
	}
}