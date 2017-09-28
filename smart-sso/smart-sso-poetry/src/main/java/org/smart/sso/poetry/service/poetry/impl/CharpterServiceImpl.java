package org.smart.sso.poetry.service.poetry.impl;

import java.util.List;

import org.smart.sso.poetry.dao.poetry.GushiwenChapterMapper;
import org.smart.sso.poetry.model.po.poetry.Chapter;
import org.smart.sso.poetry.model.po.poetry.ChapterWithBLOBs;
import org.smart.sso.poetry.service.poetry.ICharpterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("charpterService")
public class CharpterServiceImpl implements ICharpterService {
	
	@Autowired
	GushiwenChapterMapper charpterMapper;

	@Override
	public List<Chapter> selectByBookId(Integer bookId) {
		List<Chapter> chapters = charpterMapper.selectByBookId(Long.valueOf(bookId));
		return chapters;
	}

	@Override
	public ChapterWithBLOBs findByCharpterId(Integer charpterId) {
		ChapterWithBLOBs charpter = charpterMapper.selectByPrimaryKey(Long.valueOf(charpterId));
		return charpter;
	}
	
}
