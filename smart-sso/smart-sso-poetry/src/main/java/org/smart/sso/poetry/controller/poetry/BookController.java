package org.smart.sso.poetry.controller.poetry;

import java.util.List;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.smart.sso.poetry.model.po.poetry.Book;
import org.smart.sso.poetry.service.poetry.IBookService;
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
 * 古文典籍
 * @author kangtiancheng
 * @date 2017年7月25日
 */
@Api(tags = "古文典籍")
@Controller
@RequestMapping("/poetry/book")
public class BookController extends BaseController {

	private static final Logger LOG = Logger.getLogger(BookController.class);
	
	@Resource
	private IBookService bookService;
	
	@ApiOperation("列表")
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public @ResponseBody Result list(
			@ApiParam(value = "开始页码", required = true) @ValidateParam({ Validator.NOT_BLANK }) Integer pageNo,
			@ApiParam(value = "显示条数", required = true) @ValidateParam({ Validator.NOT_BLANK }) Integer pageSize) {
		LOG.info("查询古文典籍列表...");
		List<Book> books = bookService.selectBookList(pageNo, pageSize);
		return Result.createSuccessResult().setData(books);
	}
	
	@ApiOperation("典籍详情")
	@RequestMapping(value = "/detail", method = RequestMethod.GET)
	public @ResponseBody Result detail(@ApiParam(value = "书籍id", required = true) @ValidateParam({ Validator.NOT_BLANK }) Integer bookId) {
		LOG.info("查询古文典籍详情...");
		Book book = bookService.selectBookById(bookId);
		return Result.createSuccessResult().setData(book);
	}
	
	public static void main(String[] args) {
		String a = new String("1");
		String b = new String("1");
		System.out.println(1 << 16);
		System.out.println(a == b ? true : false);
		System.out.println(a.equals(b) ? true : false);
	}
}