package com.smart.product.controller;

import java.lang.reflect.InvocationTargetException;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.apache.commons.beanutils.BeanUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.smart.mvc.controller.BaseController;
import com.smart.mvc.model.Pagination;
import com.smart.mvc.model.Result;
import com.smart.mvc.validator.Validator;
import com.smart.mvc.validator.annotation.ValidateParam;
import com.smart.product.model.param.ProductUpdateParam;
import com.smart.product.model.po.Product;
import com.smart.product.service.IProductService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;

/**
 * 产品管理
 * @author kangtiancheng
 * @date 2017年5月17日
 */
@Api(tags = "产品管理")
@Controller
@RequestMapping("/admin/product")
public class ProductController extends BaseController {

	@Resource
	private IProductService productService;

	@ApiOperation("初始页")
	@RequestMapping(method = RequestMethod.GET)
	public String execute(Model model) {
		model.addAttribute("productList", getProductList());
		return "/product/product";
	}

	@ApiOperation("新增/修改页")
	@RequestMapping(value = "/edit", method = RequestMethod.GET)
	public String edit(@ApiParam(value = "id") Integer id, Model model) {
		Product product;
		if (id == null) {
			product = new Product();
		} else {
			product = productService.get(id);
		}
		model.addAttribute("product", product);
		model.addAttribute("productList", getProductList());
		return "/product/productEdit";
	}

	@ApiOperation("列表")
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public @ResponseBody Result list(
			@ApiParam(value = "产品名称") String productName,
			@ApiParam(value = "开始页码", required = true) @ValidateParam({ Validator.NOT_BLANK }) Integer pageNo,
			@ApiParam(value = "显示条数", required = true) @ValidateParam({ Validator.NOT_BLANK }) Integer pageSize) {
		return Result.createSuccessResult().setData(productService.findPaginationByProduct(productName, new Pagination<Product>(pageNo, pageSize)));
	}

	@ApiOperation("新增/修改提交")
	@ApiResponse(response = Result.class, code = 200, message = "success")
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public @ResponseBody Result save(ProductUpdateParam param) {
		Product product;
		if (param.getId() == null) {
			product = new Product();
			product.setCreateTime(new Date());
		} else {
			product = productService.get(param.getId());
		}
		try {
			BeanUtils.copyProperties(product, param);
		} catch (IllegalAccessException | InvocationTargetException e) {
			e.printStackTrace();
		}
		productService.save(product);
		return Result.createSuccessResult();
	}

	@ApiOperation("删除")
	@RequestMapping(value = "/delete", method = RequestMethod.POST)
	public @ResponseBody Result delete(
			@ApiParam(value = "ids", required = true) @ValidateParam({ Validator.NOT_BLANK }) String ids) {
		productService.deleteById(getAjaxIds(ids));
		return Result.createSuccessResult();
	}

	private List<Product> getProductList() {
		return productService.findByAll(null);
	}
}