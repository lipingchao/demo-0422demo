package com.example.demo0422demo.service;

import com.example.demo0422demo.dao.TBootMapper;
import com.example.demo0422demo.dao.TBorrowingBookMapper;
import com.example.demo0422demo.pojo.TBoot;
import com.example.demo0422demo.pojo.TBootExample;
import com.example.demo0422demo.pojo.TBorrowingBook;
import com.example.demo0422demo.pojo.TUser;
import com.example.demo0422demo.vo.BookVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.UUID;

/**
 * The type T book service.
 *
 * @User lpc /李金超
 * @ClassName TBookService 类名
 * @Author AUSUA 作者
 * @Date 2020 /4/22 16:30  时间
 * @Version 1.0 版本
 */
@Service
public class TBookService {

    @Autowired
    private TBootMapper tBootDao;

    @Autowired
    private TBorrowingBookMapper tBorrowingBookMapper;

    /**
     * 获取全部书籍
     *
     * @param tBook the t book
     * @return list
     */
    public List<BookVo> list(BookVo tBook) {
        return tBootDao.list(tBook);
    }

    /**
     * Return book string.
     *
     * @param id the id
     * @return the string
     */
    public String returnBook(String id) {
        TBoot tBoot = new TBoot();
        tBoot.setId(id);
        tBoot.setBorrowingFlag("0");
        int i = tBootDao.updateByPrimaryKeySelective(tBoot);
        return i>0? "ok":"no";
    }

    /**
     * Borrow string.
     *
     * @param BookId    the book id
     * @param attribute the attribute
     * @return the string
     */
    public String  Borrow(String  BookId, TUser attribute) {
        //1.需要去中间表操作
        TBoot tBoot = new TBoot();
        tBoot.setId(BookId);
        tBoot.setBorrowingFlag("1");
        int i =0;
        tBoot.setBorrowingCount(1);
        i = tBootDao.updateByPrimaryKeySelective(tBoot);
        if(i>0){
            //2.需要修改TBook借阅状态
            TBorrowingBook tBorrowingBook = new TBorrowingBook();
            tBorrowingBook.setBookId(BookId);
            tBorrowingBook.setBorrowingTime(new Date());
            tBorrowingBook.setUserId(attribute.getId());
            tBorrowingBook.setId(UUID.randomUUID().toString().replaceAll("-",""));
            i+= tBorrowingBookMapper.insert(tBorrowingBook);
        }
        return i>0? "ok":"no";
    }

    public String  checkBookName(String bookName) {
        TBootExample tBootExample = new TBootExample();
        tBootExample.createCriteria().andBookNameEqualTo(bookName);
        List<TBoot> tBoots = tBootDao.selectByExample(tBootExample);
        if(null!=tBoots&&tBoots.size()>0){
            return "ok";
        }
        return "no";
    }

    public Integer addBook(TBoot tBoot) {
        tBoot.setId(UUID.randomUUID().toString().replaceAll("-",""));
        tBoot.setBorrowingFlag("0");
        tBoot.setBorrowingCount(0);
        tBoot.setCreateTime(new Date());
        int insert = tBootDao.insert(tBoot);
        return insert;
    }

    public Integer update(TBoot tBoot) {
        return tBootDao.updateByPrimaryKey(tBoot);
    }

    public TBoot bookInfo(String id) {
        return tBootDao.selectByPrimaryKey(id);
    }
}
