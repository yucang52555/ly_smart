package org.smart.sso.poetry.model.po.poetry;

import java.io.Serializable;
import java.util.Date;

public class Chapter implements Serializable{
	
	private static final long serialVersionUID = -3699057988733911465L;
	
    private Long id;

    private String charpterName;

    private String charpterUrl;

    private Long bookId;

    private String charpterClass;

    private Date createTime;

    private Date updateTime;

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
        this.charpterName = charpterName == null ? null : charpterName.trim();
    }

    public String getCharpterUrl() {
        return charpterUrl;
    }

    public void setCharpterUrl(String charpterUrl) {
        this.charpterUrl = charpterUrl == null ? null : charpterUrl.trim();
    }

    public Long getBookId() {
        return bookId;
    }

    public void setBookId(Long bookId) {
        this.bookId = bookId;
    }

    public String getCharpterClass() {
        return charpterClass;
    }

    public void setCharpterClass(String charpterClass) {
        this.charpterClass = charpterClass == null ? null : charpterClass.trim();
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