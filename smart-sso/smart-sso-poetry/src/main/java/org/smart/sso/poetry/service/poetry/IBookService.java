package org.smart.sso.poetry.service.poetry;

import java.util.List;

import org.smart.sso.poetry.model.po.poetry.Book;

/**
 * 古诗文书籍服务
 * @author kangtiancheng
 * @date 2017年6月23日
 */
public interface IBookService {
	
	/**
	 * 保存书籍信息
	 * @param GSWAuthor
	 * @return
	 */
	public void saveBooks(List<Book> GSWBooks);

	/**
	 * 查询书籍列表
	 * @param pageNo
	 * @param pageSize
	 * @return
	 */
	public List<Book> selectBookList(Integer pageNo, Integer pageSize);

	/**
	 * 根据数据id获取书籍详情
	 * @param bookId
	 * @return
	 */
	public Book selectBookById(Integer bookId);
	
}
