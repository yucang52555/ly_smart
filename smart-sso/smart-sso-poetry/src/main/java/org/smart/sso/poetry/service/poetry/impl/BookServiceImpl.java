package org.smart.sso.poetry.service.poetry.impl;

import java.util.List;

import org.smart.sso.poetry.dao.poetry.GushiwenBookMapper;
import org.smart.sso.poetry.model.po.poetry.Book;
import org.smart.sso.poetry.service.poetry.IBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.smart.mvc.util.CommonUtils;

@Service("bookService")
public class BookServiceImpl implements IBookService {
	
	@Autowired
	private GushiwenBookMapper bookMapper;
	
	public void saveBooks(List<Book> gswBooks) {
		Integer size = CommonUtils.sizeOf(gswBooks);
		for (int i = 0; i < size; i++) {
			Book book = gswBooks.get(i);
			Integer result = bookMapper.insertSelective(book);
			System.out.println(result);
		}
	}

	@Override
	public List<Book> selectBookList(Integer pageNo, Integer pageSize) {
		Integer fromNo = pageNo * pageSize;
		List<Book> books = bookMapper.selectBookListStudy(fromNo, pageSize);
		return books;
	}

	@Override
	public Book selectBookById(Integer bookId) {
		Book book = bookMapper.selectByPrimaryKey(Long.valueOf(bookId));
		return book;
	}
	
}
