package com.example.demo0422demo.pojo;

import lombok.Data;

import java.util.Date;

@Data
public class TBoot {
    private String id;

    private String bookAuthor;

    private String bookIntroduce;

    private String bookName;

    private Integer borrowingCount;

    private String borrowingFlag;

    private Date createTime;

    private String picUrl;

    private Long traffic;


}