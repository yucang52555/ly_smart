package org.smart.sso.poetry.controller.poetry;

import java.util.List;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.smart.sso.poetry.model.bo.poetry.ChapterBo;
import org.smart.sso.poetry.model.po.poetry.Chapter;
import org.smart.sso.poetry.model.po.poetry.ChapterWithBLOBs;
import org.smart.sso.poetry.service.poetry.ICharpterService;
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
 * 典籍章节
 * @author kangtiancheng
 * @date 2017年8月8日
 */
@Api(tags = "典籍章节")
@Controller
@RequestMapping("/poetry/charpter")
public class CharpterController extends BaseController {

	private static final Logger LOG = Logger.getLogger(CharpterController.class);
	
	@Resource
	private ICharpterService charpterService;
	
	@ApiOperation("章节列表")
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public @ResponseBody Result list(@ApiParam(value = "书籍id", required = true) @ValidateParam({ Validator.NOT_BLANK }) Integer bookId) {
		LOG.info("查询古文典籍章节列表...");
		List<Chapter> charpters = charpterService.selectByBookId(bookId);
		return Result.createSuccessResult().setData(charpters);
	}
	
	@ApiOperation("章节内容")
	@RequestMapping(value = "/content", method = RequestMethod.GET)
	public @ResponseBody Result detail(@ApiParam(value = "章节id", required = true) @ValidateParam({ Validator.NOT_BLANK }) Integer charpterId) {
		LOG.info("查询古文典籍章节内容...");
		ChapterWithBLOBs charpter = charpterService.findByCharpterId(charpterId);
		ChapterBo chapterBo = new ChapterBo(charpter);
		return Result.createSuccessResult().setData(chapterBo);
	}
}