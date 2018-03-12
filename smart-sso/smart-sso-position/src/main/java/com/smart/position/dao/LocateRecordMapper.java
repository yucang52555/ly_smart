package com.smart.position.dao;

import com.smart.position.model.po.LocateRecord;

public interface LocateRecordMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(LocateRecord record);

    int insertSelective(LocateRecord record);

    LocateRecord selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(LocateRecord record);

    int updateByPrimaryKey(LocateRecord record);
}