package com.example.demo0422demo.dao;

import com.example.demo0422demo.pojo.TBoot;
import com.example.demo0422demo.pojo.TBootExample;
import com.example.demo0422demo.vo.BookVo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface TBootMapper {
    int countByExample(TBootExample example);

    int deleteByExample(TBootExample example);

    int deleteByPrimaryKey(String id);

    int insert(TBoot record);

    int insertSelective(TBoot record);

    List<TBoot> selectByExample(TBootExample example);

    TBoot selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") TBoot record, @Param("example") TBootExample example);

    int updateByExample(@Param("record") TBoot record, @Param("example") TBootExample example);

    int updateByPrimaryKeySelective(TBoot record);

    int updateByPrimaryKey(TBoot record);

    List<BookVo> list(BookVo tBook);
}