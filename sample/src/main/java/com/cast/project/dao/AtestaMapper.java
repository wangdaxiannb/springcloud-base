package com.panpass.project.dao;

import com.panpass.project.entity.Atesta;
import com.panpass.project.entity.AtestaExample;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface AtestaMapper {
    long countByExample(AtestaExample example);

    int deleteByExample(AtestaExample example);

    int insert(Atesta record);

    int insertSelective(Atesta record);

    List<Atesta> selectByExample(AtestaExample example);

   int updateByExampleSelective(@Param("record") Atesta record, @Param("example") AtestaExample example);

    int updateByExample(@Param("record") Atesta record, @Param("example") AtestaExample example);
}