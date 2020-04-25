package com.example.demo0422demo.vo;

import com.example.demo0422demo.pojo.TBorrowingBook;

/**
 * The type T borrowing book vo.
 *
 * @User lpc /李金超
 * @ClassName TBorrowingBookVo 类名
 * @Author AUSUA 作者
 * @Date 2020 /4/24 16:08  时间
 * @Version 1.0 版本
 */
public class TBorrowingBookVo extends TBorrowingBook {
    private String loginName ;

    private String bookName ;

    /**
     * Gets login name.
     *
     * @return the login name
     */
    public String getLoginName() {
        return loginName;
    }

    /**
     * Sets login name.
     *
     * @param loginName the login name
     */
    public void setLoginName(String loginName) {
        this.loginName = loginName;
    }

    /**
     * Gets book name.
     *
     * @return the book name
     */
    public String getBookName() {
        return bookName;
    }

    /**
     * Sets book name.
     *
     * @param bookName the book name
     */
    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    /**
     * Instantiates a new T borrowing book vo.
     *
     * @param loginName the login name
     * @param bookName  the book name
     */
    public TBorrowingBookVo(String loginName, String bookName) {
        this.loginName = loginName;
        this.bookName = bookName;
    }
}
