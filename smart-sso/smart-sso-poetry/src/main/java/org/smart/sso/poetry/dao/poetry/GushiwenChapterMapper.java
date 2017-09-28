package org.smart.sso.poetry.dao.poetry;

import java.util.List;

import org.smart.sso.poetry.model.po.poetry.Chapter;
import org.smart.sso.poetry.model.po.poetry.ChapterWithBLOBs;

public interface GushiwenChapterMapper {
    int deleteByPrimaryKey(Long id);

    ChapterWithBLOBs selectByPrimaryKey(Long id);

    int updateByPrimaryKey(Chapter record);

	List<Chapter> selectByBookId(Long bookId);
    
}