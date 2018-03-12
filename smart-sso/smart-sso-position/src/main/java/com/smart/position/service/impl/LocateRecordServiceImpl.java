package com.smart.position.service.impl;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.smart.position.dao.LocateRecordMapper;
import com.smart.position.model.po.LocateRecord;
import com.smart.position.service.ILocateRecordService;

/**
 * 定位记录保存
 * @author kangtiancheng
 * @date 2018年3月10日
 */
@Service("locateRecordService")
public class LocateRecordServiceImpl implements ILocateRecordService {
	
	@Autowired
	LocateRecordMapper locateRecordMapper;

	@Override
	public int saveLocateRecord(LocateRecord locateRecord) {
		locateRecord.setCreateTime(new Date());
		return locateRecordMapper.insert(locateRecord);
	}
	
	
}
