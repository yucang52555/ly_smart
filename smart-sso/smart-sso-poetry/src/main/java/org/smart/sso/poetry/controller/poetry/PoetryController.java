package org.smart.sso.poetry.controller.poetry;

import javax.annotation.Resource;

import org.smart.sso.poetry.service.poetry.IPoetryService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.smart.mvc.controller.BaseController;

import io.swagger.annotations.Api;

/**
 * 诗词管理
 * @author kangtiancheng
 * @date 2017年6月30日
 */
@Api(tags = "诗词管理")
@Controller
@RequestMapping("/poetry/poetry")
public class PoetryController extends BaseController {

	@Resource
	private IPoetryService poetryService;

}