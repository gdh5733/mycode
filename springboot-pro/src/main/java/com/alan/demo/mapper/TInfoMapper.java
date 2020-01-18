package com.alan.demo.mapper;

import com.alan.demo.entity.TInfo;
import com.alan.demo.entity.TInfoExample;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

@Component
public interface TInfoMapper {
    long countByExample(TInfoExample example);

    int deleteByExample(TInfoExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(TInfo record);

    int insertSelective(TInfo record);

    List<TInfo> selectByExample(TInfoExample example);

    TInfo selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") TInfo record, @Param("example") TInfoExample example);

    int updateByExample(@Param("record") TInfo record, @Param("example") TInfoExample example);

    int updateByPrimaryKeySelective(TInfo record);

    int updateByPrimaryKey(TInfo record);

    String selectTeleByid(Map<String, Object> map);
}