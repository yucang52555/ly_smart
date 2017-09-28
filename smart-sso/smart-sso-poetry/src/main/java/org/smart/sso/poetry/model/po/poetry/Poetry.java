package org.smart.sso.poetry.model.po.poetry;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * 古诗文-诗词
 * @author kangtiancheng
 * @date 2017年6月24日
 */
public class Poetry implements Serializable{
	
    private static final long serialVersionUID = 2597571202174743257L;

	private Long id;

    private String poetryName;

    private String poetryUrl;

    private String dynasty;

    private String author;

    private Long authorId;

    private String poetryContent;

    private Integer pointNumber;
    
	private List<Tag> tags;

    private Date createTime;

    private Date updateTime;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPoetryName() {
        return poetryName;
    }

    public void setPoetryName(String poetryName) {
        this.poetryName = poetryName == null ? null : poetryName.trim();
    }

    public String getPoetryUrl() {
        return poetryUrl;
    }

    public void setPoetryUrl(String poetryUrl) {
        this.poetryUrl = poetryUrl == null ? null : poetryUrl.trim();
    }

    public String getDynasty() {
        return dynasty;
    }

    public void setDynasty(String dynasty) {
        this.dynasty = dynasty == null ? null : dynasty.trim();
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author == null ? null : author.trim();
    }

    public Long getAuthorId() {
        return authorId;
    }

    public void setAuthorId(Long authorId) {
        this.authorId = authorId;
    }

    public String getPoetryContent() {
        return poetryContent;
    }

    public void setPoetryContent(String poetryContent) {
        this.poetryContent = poetryContent == null ? null : poetryContent.trim();
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

	
	public List<Tag> getTags() {
		return tags;
	}

	
	public void setTags(List<Tag> tags) {
		this.tags = tags;
	}
    
}