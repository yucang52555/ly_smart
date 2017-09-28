package org.smart.sso.poetry.controller.poetry;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.smart.sso.poetry.model.bo.poetry.MinjuRecommendBo;
import org.smart.sso.poetry.service.poetry.IMinjuService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.smart.mvc.controller.BaseController;
import com.smart.mvc.model.Result;
import com.smart.mvc.validator.Validator;
import com.smart.mvc.validator.annotation.ValidateParam;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

/**
 * 名句管理
 * @author kangtiancheng
 * @date 2017年7月24日
 */
@Api(tags = "名句管理")
@Controller
@RequestMapping("/poetry/minju")
public class MinjuController extends BaseController {

	private static final Logger LOG = Logger.getLogger(MinjuController.class);
	
	@Resource
	private IMinjuService minjuService;
	
	@ApiOperation("每日推荐名句")
	@RequestMapping(value = "/recommend", method = RequestMethod.GET)
	public @ResponseBody Result recommend() {
		LOG.info("查询每日推荐名句...");
		MinjuRecommendBo minju = minjuService.findMinjuByRecommend();
		return Result.createSuccessResult().setData(minju);
	}
	
	@ApiOperation("获取明日推荐")
	@RequestMapping(value = "/recommendNext", method = RequestMethod.GET)
	public @ResponseBody Result recommendNext(
			@ApiParam(value = "当前名句id", required = true) @ValidateParam({ Validator.NOT_BLANK }) Integer minjuId) {
		LOG.info("查询每日推荐名句...");
		MinjuRecommendBo minju = minjuService.findMinjuByRecommendNext(minjuId);
		return Result.createSuccessResult().setData(minju);
	}
}