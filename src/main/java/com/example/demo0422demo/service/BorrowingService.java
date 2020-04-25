package com.example.demo0422demo.service;

import com.example.demo0422demo.dao.TBorrowingBookMapper;
import com.example.demo0422demo.vo.TBorrowingBookVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @User lpc/李金超
 * @ClassName BorrowingService  类名
 * @Author AUSUA  作者
 * @Date 2020/4/24 16:09  时间
 * @Version 1.0 版本
 */
@Service
public class BorrowingService {

    @Autowired
    private TBorrowingBookMapper tBorrowingBookMapper;

    public List<TBorrowingBookVo> queryAllBorrowingRecords(String id) {
        return tBorrowingBookMapper.queryAllBorrowingRecords(id);
    }
}
