package org.smart.sso.poetry.model.po.poetry;

import java.io.Serializable;
import java.util.Date;

/**
 * 古诗文作者
 * @author kangtiancheng
 * @date 2017年6月19日
 */
public class Author implements Serializable{

	private static final long serialVersionUID = -6171990435798033685L;
	
	private Long id;
	
	private String authorName;
	
	private String authorDesc;
	
	private String authorImg;

	private Integer pointNumber;
	
	private String authorDynasty;
	
	private String authorUrl;
	
	private Date createTime;
	
	private Date updateTime;
	
	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}

	public String getAuthorName() {
		return authorName;
	}
	
	public void setAuthorName(String authorName) {
		this.authorName = authorName;
	}
	
	public String getAuthorDesc() {
		return authorDesc;
	}
	
	public void setAuthorDesc(String authorDesc) {
		this.authorDesc = authorDesc;
	}
	
	public String getAuthorImg() {
		return authorImg;
	}
	
	public void setAuthorImg(String authorImg) {
		this.authorImg = authorImg;
	}

	public Integer getPointNumber() {
		return pointNumber;
	}

	public void setPointNumber(Integer pointNumber) {
		this.pointNumber = pointNumber;
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
	
	public String getAuthorDynasty() {
		return authorDynasty;
	}

	public void setAuthorDynasty(String authorDynasty) {
		this.authorDynasty = authorDynasty;
	}

	public String getAuthorUrl() {
		return authorUrl;
	}

	public void setAuthorUrl(String authorUrl) {
		this.authorUrl = authorUrl;
	}
}
