package com.smart.sso.server.model.po.category;

import java.util.Date;

import com.alibaba.fastjson.annotation.JSONField;
import com.smart.mvc.model.PersistentObject;

/**
 * 产品类别
 * @author kangtiancheng
 * @date 2017年5月17日
 */
public class Category extends PersistentObject {

	private static final long serialVersionUID = 6762408321861783695L;
	
	/** 名称 */
	private String name;
	/** 编码  */
	private String code;
	/** 状态  */
	private Integer status;
	/** 类型  */
	private Integer type;
	/** 父id */
	private Integer pid;
	/** 排序 */
	private Integer sort = Integer.valueOf(1);
	/** 订单描述 */
	private String desc;
	/** 创建时间 */
	@JSONField(format = "yyyy-MM-dd HH:mm:ss")
	private Date createTime;
	/** 更新时间 */
	@JSONField(format = "yyyy-MM-dd HH:mm:ss")
	private Date updateTime;
	
	/** 以下为显示辅助参数 */
	private Boolean isChecked = Boolean.valueOf(false);
	
	public Category(){
	}

	public Category(String name, String code, Integer status, Integer type, Integer pid, 
			Integer sort, String desc, Date createTime, Date updateTime, Boolean isChecked) {
		this.name = name;
		this.code = code;
		this.status = status;
		this.type = type;
		this.pid = pid;
		this.sort = sort;
		this.desc = desc;
		this.createTime = createTime;
		this.updateTime = updateTime;
		this.isChecked = isChecked;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public Integer getSort() {
		return this.sort;
	}

	public void setSort(Integer sort) {
		this.sort = sort;
	}

	public Date getCreateTime() {
		return this.createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public Boolean getIsChecked() {
		return isChecked;
	}

	public void setIsChecked(Boolean isChecked) {
		this.isChecked = isChecked;
	}
	
	public Integer getStatus() {
		return status;
	}
	
	public void setStatus(Integer status) {
		this.status = status;
	}
	
	public Integer getType() {
		return type;
	}
	
	public void setType(Integer type) {
		this.type = type;
	}
	
	public String getDesc() {
		return desc;
	}
	
	public void setDesc(String desc) {
		this.desc = desc;
	}
	
	public Date getUpdateTime() {
		return updateTime;
	}
	
	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}
	
	public Integer getPid() {
		return pid;
	}

	public void setPid(Integer pid) {
		this.pid = pid;
	}
}
