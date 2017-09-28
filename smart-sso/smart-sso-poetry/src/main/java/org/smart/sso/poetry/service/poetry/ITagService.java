package org.smart.sso.poetry.service.poetry;

import java.util.List;

import org.smart.sso.poetry.model.po.poetry.Tag;

/**
 * 古诗文标签服务
 * @author kangtiancheng
 * @date 2017年6月20日
 */
public interface ITagService {
	
	/**
	 * 保存标签信息
	 * @param GSWAuthor
	 * @return
	 */
	public void saveTags(List<Tag> GSWTags);
	
	/**
	 * 查询标签列表
	 * @param GSWAuthor
	 * @return
	 */
	public List<Tag> selectAllTags();
	
}
