package org.smart.sso.poetry.service.poetry;

import java.util.List;

import org.smart.sso.poetry.model.po.poetry.Chapter;
import org.smart.sso.poetry.model.po.poetry.ChapterWithBLOBs;

/**
 * 典籍章节服务
 * @author kangtiancheng
 * @date 2017年8月8日
 */
public interface ICharpterService {
	
	/**
	 * 查询书籍章节列表
	 * @param pageNo
	 * @param pageSize
	 * @return
	 */
	public List<Chapter> selectByBookId(Integer bookId);

	/**
	 * 查询书籍章节详情
	 * @param charpterId
	 * @return
	 */
	public ChapterWithBLOBs findByCharpterId(Integer charpterId);
	
}
