package com.example.demo0422demo.controller;

import com.example.demo0422demo.service.BorrowingService;
import com.example.demo0422demo.vo.TBorrowingBookVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * The type Borrowing controller.
 *
 * @User lpc /李金超
 * @ClassName BorrowingController 类名
 * @Author AUSUA 作者
 * @Date 2020 /4/24 15:30  时间
 * @Version 1.0 版本
 */
@Controller
@RequestMapping("/borro")
public class BorrowingController {
    @Autowired
    private BorrowingService borrowingService;

    /**
     * Query all borrowing records list.
     *
     * @param id the id
     * @return the list
     */
    @RequestMapping("/queryAllBorrowingRecords")
    @ResponseBody
    public List<TBorrowingBookVo> queryAllBorrowingRecords(String id){
        List<TBorrowingBookVo> tBorrowingBookVos = borrowingService.queryAllBorrowingRecords(id);
        return tBorrowingBookVos;
    }


}
