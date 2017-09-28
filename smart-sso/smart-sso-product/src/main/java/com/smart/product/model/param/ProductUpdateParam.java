package com.smart.product.model.param;

import java.math.BigDecimal;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import io.swagger.annotations.ApiParam;

/**
 * 产品更新/新增参数模型
 * @author kangtiancheng
 * @date 2017年5月26日
 */
public class ProductUpdateParam {
	/** 主键id */
	private Integer id;
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
	
	@ApiParam(value = "id")
	public Integer getId() {
		return id;
	}
	
	public void setId(Integer id) {
		this.id = id;
	}
	
	@ApiParam(value = "产品名称")
	public String getProductName() {
		return productName;
	}
	
	public void setProductName(String productName) {
		this.productName = productName;
	}
	
	@ApiParam(value = "产品编号")
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
		return sort;
	}
	
	public void setSort(Integer sort) {
		this.sort = sort;
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
	
	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this, ToStringStyle.SHORT_PREFIX_STYLE);
	}
}
