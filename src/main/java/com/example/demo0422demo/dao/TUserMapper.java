package com.example.demo0422demo.dao;

import com.example.demo0422demo.pojo.TUser;
import com.example.demo0422demo.pojo.TUserExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * The interface T user mapper.
 */
public interface TUserMapper {
    /**
     * Count by example int.
     *
     * @param example the example
     * @return the int
     */
    int countByExample(TUserExample example);

    /**
     * Delete by example int.
     *
     * @param example the example
     * @return the int
     */
    int deleteByExample(TUserExample example);

    /**
     * Delete by primary key int.
     *
     * @param id the id
     * @return the int
     */
    int deleteByPrimaryKey(String id);

    /**
     * Insert int.
     *
     * @param record the record
     * @return the int
     */
    int insert(TUser record);

    /**
     * Insert selective int.
     *
     * @param record the record
     * @return the int
     */
    int insertSelective(TUser record);

    /**
     * Select by example list.
     *
     * @param example the example
     * @return the list
     */
    List<TUser> selectByExample(TUserExample example);

    /**
     * Select by primary key t user.
     *
     * @param id the id
     * @return the t user
     */
    TUser selectByPrimaryKey(String id);

    /**
     * Update by example selective int.
     *
     * @param record  the record
     * @param example the example
     * @return the int
     */
    int updateByExampleSelective(@Param("record") TUser record, @Param("example") TUserExample example);

    /**
     * Update by example int.
     *
     * @param record  the record
     * @param example the example
     * @return the int
     */
    int updateByExample(@Param("record") TUser record, @Param("example") TUserExample example);

    /**
     * Update by primary key selective int.
     *
     * @param record the record
     * @return the int
     */
    int updateByPrimaryKeySelective(TUser record);

    /**
     * Update by primary key int.
     *
     * @param record the record
     * @return the int
     */
    int updateByPrimaryKey(TUser record);

    List<TUser> userList(TUser tUser);
}