package org.smart.sso.poetry.service.poetry.impl;

import java.util.List;

import org.smart.sso.poetry.dao.poetry.GushiwenTagMapper;
import org.smart.sso.poetry.model.po.poetry.Tag;
import org.smart.sso.poetry.service.poetry.ITagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.smart.mvc.util.CommonUtils;

@Service("tagService")
public class TagServiceImpl implements ITagService {
	
	@Autowired
	private GushiwenTagMapper tagMapper;
	
	@Override
	public void saveTags(List<Tag> gswTags) {
		Integer size = CommonUtils.sizeOf(gswTags);
		for (int i = 0; i < size; i++) {
			Tag tag = gswTags.get(i);
			Integer result = tagMapper.insertSelective(tag);
			System.out.println(result);
		}
	}

	@Override
	public List<Tag> selectAllTags() {
		return tagMapper.selectAllTags();
	}
	
}
