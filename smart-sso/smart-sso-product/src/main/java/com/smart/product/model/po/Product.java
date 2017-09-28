package com.smart.product.model.po;

import java.math.BigDecimal;
import java.util.Date;

import com.alibaba.fastjson.annotation.JSONField;
import com.smart.mvc.model.PersistentObject;

/**
 * 产品
 * @author kangtiancheng
 * @date 2017年5月17日
 */
public class Product extends PersistentObject {

	private static final long serialVersionUID = 6584402959131525219L;
	
	/** 名称 */
	private String productName;
	/** 编码  */
	private String productCode;
	/** 状态  */
	private Integer productStatus;
	/** 类型  */
	private Integer productType;
	/** 排序 */
	private Integer sort = Integer.valueOf(1);
	/** 销售价格 */
	private BigDecimal salesPrice;
	/** 进货价格 */
	private BigDecimal purchasePrice;
	/** 主页链接 */
	private String homePage;
	/** 订单描述 */
	private String productDesc;
	/** 创建时间 */
	@JSONField(format = "yyyy-MM-dd HH:mm:ss")
	private Date createTime;
	/** 更新时间 */
	@JSONField(format = "yyyy-MM-dd HH:mm:ss")
	private Date updateTime;
	
	/** 以下为显示辅助参数 */
	private Boolean isChecked = Boolean.valueOf(false);
	
	public Product(){
	}
	
	public Product(String productName, String productCode, Integer productStatus, Integer productType, Integer sort, 
			BigDecimal salesPrice, BigDecimal purchasePrice, String homePage, String productDesc, 
			Date createTime, Date updateTime, Boolean isChecked) {
		super();
		this.productName = productName;
		this.productCode = productCode;
		this.productStatus = productStatus;
		this.productType = productType;
		this.sort = sort;
		this.salesPrice = salesPrice;
		this.purchasePrice = purchasePrice;
		this.homePage = homePage;
		this.productDesc = productDesc;
		this.createTime = createTime;
		this.updateTime = updateTime;
		this.isChecked = isChecked;
	}

	public String getProductName() {
		return productName;
	}
	
	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getProductCode() {
		return productCode;
	}
	
	public void setProductCode(String productCode) {
		this.productCode = productCode;
	}
	
	public Integer getProductStatus() {
		return productStatus;
	}
	
	public void setProductStatus(Integer productStatus) {
		this.productStatus = productStatus;
	}

	public Integer getProductType() {
		return productType;
	}
	
	public void setProductType(Integer productType) {
		this.productType = productType;
	}
	
	public String getProductDesc() {
		return productDesc;
	}
	
	public void setProductDesc(String productDesc) {
		this.productDesc = productDesc;
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
	
	public BigDecimal getSalesPrice() {
		return salesPrice;
	}
	
	public void setSalesPrice(BigDecimal salesPrice) {
		this.salesPrice = salesPrice;
	}
	
	public BigDecimal getPurchasePrice() {
		return purchasePrice;
	}
	
	public void setPurchasePrice(BigDecimal purchasePrice) {
		this.purchasePrice = purchasePrice;
	}
	
	public String getHomePage() {
		return homePage;
	}

	public void setHomePage(String homePage) {
		this.homePage = homePage;
	}
	
	public Date getUpdateTime() {
		return updateTime;
	}
	
	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}
	
}
