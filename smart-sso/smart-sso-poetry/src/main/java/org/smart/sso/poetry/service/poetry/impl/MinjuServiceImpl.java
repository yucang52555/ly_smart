package org.smart.sso.poetry.service.poetry.impl;

import java.text.ParseException;
import java.util.List;

import org.apache.log4j.Logger;
import org.smart.sso.poetry.dao.poetry.GushiwenMinjuMapper;
import org.smart.sso.poetry.model.bo.poetry.MinjuRecommendBo;
import org.smart.sso.poetry.model.po.poetry.Minju;
import org.smart.sso.poetry.service.poetry.IMinjuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.druid.support.json.JSONUtils;
import com.smart.mvc.config.ConfigUtils;
import com.smart.mvc.util.CommonUtils;
import com.smart.mvc.util.DateUtils;

@Service("minjuService")
public class MinjuServiceImpl implements IMinjuService {
	
	private static final Logger LOG = Logger.getLogger(MinjuServiceImpl.class);
	
	@Autowired
	private GushiwenMinjuMapper minjuMapper;
	
	@Override
	public void saveMinjus(List<Minju> gswMinjus) {
		LOG.info("saveMinjus:" + JSONUtils.toJSONString(gswMinjus));
		Integer size = CommonUtils.sizeOf(gswMinjus);
		for (int i = 0; i < size; i++) {
			Minju minju = gswMinjus.get(i);
			Integer result = minjuMapper.insertSelective(minju);
			System.out.println(minju.getSourcePoetry() + ":" + result);
		}
	}

	@Override
	public MinjuRecommendBo findMinjuByRecommend() {
		String recommendBaseDate = ConfigUtils.getProperty("recommend.base.date");
		String curDate = DateUtils.getCurDateStr();
		MinjuRecommendBo minjuBo = null;
		try {
			Integer days = DateUtils.daysBetween(recommendBaseDate, curDate);
			Integer totalCount = minjuMapper.selectTotalMinjuCount();
			Integer orderId = days%totalCount;
			if (days == 0) {
				orderId = totalCount;
			}
			Minju minju = minjuMapper.selectByOrderId(orderId);
			minjuBo = new MinjuRecommendBo(minju);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return minjuBo;
	}

	@Override
	public MinjuRecommendBo findMinjuByRecommendNext(Integer minjuId) {
		MinjuRecommendBo minjuBo = null;
		try {
			Minju minju = minjuMapper.selectRecommendNextByMinjuId(minjuId);
			minjuBo = new MinjuRecommendBo(minju);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return minjuBo;
	}
	
}
