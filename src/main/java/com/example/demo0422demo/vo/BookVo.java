package com.example.demo0422demo.vo;

import com.example.demo0422demo.pojo.TBoot;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;

/**
 * The type Book vo.
 *
 * @User lpc /李金超
 * @ClassName BookVo 类名
 * @Author AUSUA 作者
 * @Date 2020 /4/22 14:04  时间
 * @Version 1.0 版本多余字段的汇总，利于修改
 */
@Data
public class BookVo extends TBoot implements Serializable {
    private String id;

    private Date createTime;

    private String email;

    private String loginName;

    private String password;

    private String phone;

    private String sex;

    private Date borrowingTime;

    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm") //用于接收参数使用
    private Date startTime;

    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm") //用于接收参数使用
    private Date endTime;

}
