package com.example.demo0422demo.pojo;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

/**
 * 实体类   类似于中间表
 */
public class TBorrowingBook {
    private String id;

    private String bookId;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date borrowingTime;

    private String userId;

    /**
     * Gets id.
     *
     * @return the id
     */
    public String getId() {
        return id;
    }

    /**
     * Sets id.
     *
     * @param id the id
     */
    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    /**
     * Gets book id.
     *
     * @return the book id
     */
    public String getBookId() {
        return bookId;
    }

    /**
     * Sets book id.
     *
     * @param bookId the book id
     */
    public void setBookId(String bookId) {
        this.bookId = bookId == null ? null : bookId.trim();
    }

    /**
     * Gets borrowing time.
     *
     * @return the borrowing time
     */
    public Date getBorrowingTime() {
        return borrowingTime;
    }

    /**
     * Sets borrowing time.
     *
     * @param borrowingTime the borrowing time
     */
    public void setBorrowingTime(Date borrowingTime) {
        this.borrowingTime = borrowingTime;
    }

    /**
     * Gets user id.
     *
     * @return the user id
     */
    public String getUserId() {
        return userId;
    }

    /**
     * Sets user id.
     *
     * @param userId the user id
     */
    public void setUserId(String userId) {
        this.userId = userId == null ? null : userId.trim();
    }
}