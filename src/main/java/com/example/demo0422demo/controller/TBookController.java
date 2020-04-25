package com.example.demo0422demo.controller;

import com.alibaba.fastjson.JSON;
import com.example.demo0422demo.constant.ConstantFinal;
import com.example.demo0422demo.pojo.TBoot;
import com.example.demo0422demo.pojo.TUser;
import com.example.demo0422demo.service.TBookService;
import com.example.demo0422demo.utils.UploadUtils;
import com.example.demo0422demo.vo.BookVo;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * The type T book controller.
 *
 * @User lpc /李金超
 * @ClassName TBookController 类名
 * @Author AUSUA 作者
 * @Date 2020 /4/22 14:00  时间
 * @Version 1.0 版本
 */
@Controller
@RequestMapping("/book")
public class TBookController {
    /**
     * 通过Spring进行依赖注入
     */
    @Autowired
    private TBookService tBookService;


    @Autowired
    private RedisTemplate redisTemplate ;

    /**
     * List string.
     *
     * @param tBook       the t book
     * @param model       the model
     * @param httpSession the http session
     * @param current     the page num
     * @return the string
     */
    @RequestMapping("/list")
    public String list(BookVo tBook, Model model, HttpSession httpSession, @RequestParam(defaultValue = "1")Integer current){
        TUser attribute = (TUser) httpSession.getAttribute(ConstantFinal.USER_INFO);
        PageHelper.startPage(current,3);
        List<BookVo> list = tBookService.list(tBook);
        PageInfo<BookVo> pageInfo = new PageInfo<>(list);
        model.addAttribute("bookList",list);
        model.addAttribute("page",pageInfo);
        if(null!=attribute){
            model.addAttribute("userName",attribute.getLoginName());
        }
        return "list";
    }

    /**
     * Return book string.
     *
     * @param id the id
     * @return the string
     */
    @RequestMapping("/returnBook")
    @ResponseBody
    public String returnBook(String id){
        String flag = tBookService.returnBook(id);
        return JSON.toJSONString(flag);
    }

    /**
     * Borrow string.
     *
     * @param id          the id
     * @param httpSession the http session
     * @return the string
     */
    @RequestMapping("/Borrow")
    @ResponseBody
    public String Borrow(String id, HttpSession httpSession){
        String flag="";
        TUser attribute = (TUser) httpSession.getAttribute(ConstantFinal.USER_INFO);
        if(null!=attribute){
            flag=  tBookService.Borrow(id,attribute);
            return JSON.toJSONString(flag);
        }
        return JSON.toJSONString(flag);
    }

    /**
     * To book add string.
     *
     * @return the string
     */
    @RequestMapping("/toBookAdd")
    public String toBookAdd(){
        return "book_add";
    }

    /**
     * Add book string.
     *
     * @param tBoot the t boot
     * @param file  the file
     * @param model the model
     * @return the string
     */
    @RequestMapping("/addBook")
    public String addBook(TBoot tBoot, @RequestParam("file") MultipartFile file, Model model){
        if(null!=file){
            String upload = UploadUtils.upload(file);
            tBoot.setPicUrl(upload);
        }
        Integer i = null;
        if(null!=tBoot.getId()){
            i = tBookService.update(tBoot);
        }else {
            i= tBookService.addBook(tBoot);
        }
        if (i>0){
            return "redirect:/book/list";
        }
        model.addAttribute("tBoot",tBoot);
        return "book_add";
    }

    /**
     * Check book name string.
     *
     * @param bookName the book name
     * @return the string
     */
    @RequestMapping("/checkBookName")
    @ResponseBody
    public String checkBookName(String bookName){
        return JSON.toJSONString(tBookService.checkBookName(bookName));
    }

    /**
     * 点赞功能
     *
     * @param id          the id
     * @param httpSession the http session
     * @return string
     */
    @RequestMapping("/awesome")
    @ResponseBody
    public String awesome(String id, HttpSession httpSession){
        //获取登录者的信息
        TUser attribute = (TUser) httpSession.getAttribute(ConstantFinal.USER_INFO);
        if(null!=attribute){
            Boolean aBoolean = redisTemplate.hasKey(attribute.getId()+"awesome_" + id);
            if(aBoolean){
                return "no";
            }
            redisTemplate.opsForValue().increment(attribute.getId()+"awesome_"+id,1);
            return "ok";
        }
        return "notLogin";
    }
    @RequestMapping("/Details")
    public String Details(String id,Model model){
        redisTemplate.opsForValue().increment(id,1); //完成点击量的加1
        model.addAttribute("bookId",id);
        return "Details_book";
    }

    @RequestMapping("/bookInfo")
    @ResponseBody
    public TBoot bookInfo(String id){
        TBoot tBoot =  tBookService.bookInfo(id);
        Boolean aBoolean = redisTemplate.hasKey(id);
        if(aBoolean){
            Integer  count = (Integer) redisTemplate.opsForValue().get(id);
            tBoot.setTraffic((long)count);
        }else{
            tBoot.setTraffic((long)0);
        }
        return tBoot;
    }

    /**
     * 跳转到书籍详情页面，同时点击量新增1
     * @param bookId
     * @param model
     * @return
     */
    @RequestMapping("/toQueryBookInfo")
    public String toQueryBookInfo(String bookId,Model model){
        model.addAttribute("bookId",bookId) ;
        //完成点击量的加1
        redisTemplate.opsForValue().increment(bookId,1);
        return "Details_book";
    }


    @RequestMapping("/queryBookInfo")
    @ResponseBody
    public TBoot queryBookInfo(String id){
        TBoot tBook =  tBookService.bookInfo(id);
        Boolean aBoolean = redisTemplate.hasKey(id);
        if(aBoolean){
            //如果id存在redis中，则去获取他的点击量
            Integer  count = (Integer) redisTemplate.opsForValue().get(id);
            //赋值
            tBook.setTraffic((long)count);
        }else{
            //如果不存在，则设置当前的点击量量为0
            tBook.setTraffic((long)0);
        }
        return tBook;
    }


}
