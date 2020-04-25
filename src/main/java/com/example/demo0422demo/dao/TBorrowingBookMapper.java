package com.example.demo0422demo.dao;

import com.example.demo0422demo.pojo.TBorrowingBook;
import com.example.demo0422demo.pojo.TBorrowingBookExample;
import com.example.demo0422demo.vo.TBorrowingBookVo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * The interface T borrowing book mapper.
 */
@Mapper
@Repository
public interface TBorrowingBookMapper {
    /**
     * Count by example int.
     *
     * @param example the example
     * @return the int
     */
    int countByExample(TBorrowingBookExample example);

    /**
     * Delete by example int.
     *
     * @param example the example
     * @return the int
     */
    int deleteByExample(TBorrowingBookExample example);

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
    int insert(TBorrowingBook record);

    /**
     * Insert selective int.
     *
     * @param record the record
     * @return the int
     */
    int insertSelective(TBorrowingBook record);

    /**
     * Select by example list.
     *
     * @param example the example
     * @return the list
     */
    List<TBorrowingBook> selectByExample(TBorrowingBookExample example);

    /**
     * Select by primary key t borrowing book.
     *
     * @param id the id
     * @return the t borrowing book
     */
    TBorrowingBook selectByPrimaryKey(String id);

    /**
     * Update by example selective int.
     *
     * @param record  the record
     * @param example the example
     * @return the int
     */
    int updateByExampleSelective(@Param("record") TBorrowingBook record, @Param("example") TBorrowingBookExample example);

    /**
     * Update by example int.
     *
     * @param record  the record
     * @param example the example
     * @return the int
     */
    int updateByExample(@Param("record") TBorrowingBook record, @Param("example") TBorrowingBookExample example);

    /**
     * Update by primary key selective int.
     *
     * @param record the record
     * @return the int
     */
    int updateByPrimaryKeySelective(TBorrowingBook record);

    /**
     * Update by primary key int.
     *
     * @param record the record
     * @return the int
     */
    int updateByPrimaryKey(TBorrowingBook record);

    /**
     * Query all borrowing records list.
     *
     * @param id the id
     * @return the list
     */
    List<TBorrowingBookVo> queryAllBorrowingRecords(String id);
}