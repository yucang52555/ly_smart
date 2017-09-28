package org.smart.sso.poetry.service.poetry.impl;

import java.util.List;

import org.smart.sso.poetry.dao.poetry.GushiwenAuthorMapper;
import org.smart.sso.poetry.model.po.poetry.Author;
import org.smart.sso.poetry.service.poetry.IAuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.smart.mvc.util.CommonUtils;

@Service("authorService")
public class AuthorServiceImpl implements IAuthorService{
	
	@Autowired
	private GushiwenAuthorMapper authorMapper;
	
	public void saveAuthors(List<Author> gswAuthor) {
		Integer size = CommonUtils.sizeOf(gswAuthor);
		for (int i = 0; i < size; i++) {
			Author author = gswAuthor.get(i);
			Integer result = authorMapper.insertSelective(author);
			System.out.println(result);
		}
	}
	
}
