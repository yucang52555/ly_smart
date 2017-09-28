package org.smart.sso.poetry.service.poetry.impl;

import java.util.List;

import org.smart.sso.poetry.dao.poetry.GushiwenPoetryMapper;
import org.smart.sso.poetry.model.po.poetry.Poetry;
import org.smart.sso.poetry.service.poetry.IPoetryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.smart.mvc.util.CommonUtils;

@Service("poetryService")
public class PoetryServiceImpl implements IPoetryService{
	
	@Autowired
	private GushiwenPoetryMapper poetryMapper;
	
	public void savePoetrys(List<Poetry> gswPoetry) {
		Integer size = CommonUtils.sizeOf(gswPoetry);
		for (int i = 0; i < size; i++) {
			Poetry poetry = gswPoetry.get(i);
			try {
				Integer result = poetryMapper.insertSelective(poetry);
				System.out.println(result);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	
}
