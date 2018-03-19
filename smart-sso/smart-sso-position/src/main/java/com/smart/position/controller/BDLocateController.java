package com.smart.position.controller;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
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
	
	private static final Logger LOG = Logger.getLogger(BDLocateController.class);
	
	@Autowired
	private ILocateRecordService locateRecordService;
	
	@ApiOperation("保存用户定位")
	@RequestMapping(value = "/save")
	public @ResponseBody Result list(@ApiParam String locateRecordParam) {
		LOG.info("请求参数：" + locateRecordParam);
		LocateRecord locateRecord = JSONObject.parseObject(locateRecordParam, LocateRecord.class);
		int resultData = locateRecordService.saveLocateRecord(locateRecord);
		return Result.createSuccessResult(resultData, "请求成功");
	}
}
