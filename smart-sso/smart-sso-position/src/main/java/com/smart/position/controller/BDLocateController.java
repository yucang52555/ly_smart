package com.smart.position.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONObject;
import com.smart.mvc.controller.BaseController;
import com.smart.mvc.model.Result;
import com.smart.position.model.po.LocateRecord;
import com.smart.position.service.ILocateRecordService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

/**
 * 百度定位服务
 * @author kangtiancheng
 * @date 2018年3月2日
 */
@Api(tags = "百度定位控制器")
@Controller
@RequestMapping("/baidu/locate")
public class BDLocateController extends BaseController {
	
	@Autowired
	private ILocateRecordService locateRecordService;
	
	@ApiOperation("保存用户定位")
	@RequestMapping(value = "/save", method = RequestMethod.GET)
	public @ResponseBody Result list(@ApiParam(value = "用户定位数据") String locateRecordParam) {
		LocateRecord locateRecord = JSONObject.parseObject(locateRecordParam, LocateRecord.class);
		int resultData = locateRecordService.saveLocateRecord(locateRecord);
		return Result.createSuccessResult(resultData, "请求成功");
	}
}
