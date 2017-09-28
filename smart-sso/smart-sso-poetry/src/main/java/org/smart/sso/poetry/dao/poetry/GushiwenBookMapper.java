package org.smart.sso.poetry.dao.poetry;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.smart.sso.poetry.model.po.poetry.Book;

public interface GushiwenBookMapper {
    int deleteByPrimaryKey(Long id);

    int insert(Book record);

    int insertSelective(Book record);

    Book selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(Book record);

    int updateByPrimaryKey(Book record);

    /**
     * 查询学习书籍列表
     * @param pageNo
     * @param pageSize
     * @return
     */
	List<Book> selectBookListStudy(@Param("fromNo") Integer fromNo, @Param("pageSize") Integer pageSize);
}