package com.example.demo0422demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @User lpc/李金超
 * @ClassName toHomeController  类名
 * @Author AUSUA  作者
 * @Date 2020/4/25 16:40  时间
 * @Version 1.0 版本
 */
@Controller
public class toHomeController {

    /**
     * Listcontent string.
     *
     * @return the string
     */
    @RequestMapping("/toHome")
    public String listcontent() {
        return "Home";
    }

}
