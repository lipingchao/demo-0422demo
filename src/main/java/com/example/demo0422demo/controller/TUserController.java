package com.example.demo0422demo.controller;

import cn.hutool.crypto.SecureUtil;
import com.alibaba.fastjson.JSON;
import com.example.demo0422demo.constant.ConstantFinal;
import com.example.demo0422demo.pojo.TUser;
import com.example.demo0422demo.service.TUserService;
import com.example.demo0422demo.utils.EmptyUtilsAndRedisConfig;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.Date;
import java.util.List;
import java.util.UUID;

/**
 * The type T user controller.
 *
 * @User lpc /李金超
 * @ClassName TUserController 类名
 * @Author AUSUA 作者
 * @Date 2020 /4/22 13:27  时间
 * @Version 1.0 版本
 */
@Controller
public class TUserController {

    @Autowired
    private TUserService tUserService;

    /**
     * 进入端接口加载登陆接口
     *
     * @return string string
     */
    @RequestMapping("/")
    public String login() {
        return "login";
    }

    /**
     * 校验账号和密码
     *
     * @param tUser       the t user
     * @param httpSession the http session
     * @param model       the model
     * @return string string
     */
    @RequestMapping("/toLogin")
    public String toLogin(TUser tUser, HttpSession httpSession, Model model) {
        TUser attribute = (TUser) httpSession.getAttribute(ConstantFinal.USER_INFO);
        if(null!=attribute){
            return "index";
        }
        if (EmptyUtilsAndRedisConfig.isNotEmptyBean(tUser)) {
            TUser login = tUserService.login(tUser);
            if (null != login && !"".equals(login.getId())) {
                httpSession.setAttribute(ConstantFinal.USER_INFO, login);
                return "index";
            }
            model.addAttribute("msg", "抱歉您的用户名或密码有误");
            return "login";
        }
        model.addAttribute("msg", "抱歉，您还未登陆！ 请先登录");
        return "login";
    }

    /**
     * Register string.
     *
     * @return the string
     */
    @RequestMapping("/register")
    public String register() {
        return "register";
    }

    /**
     * To register string.
     *
     * @param tUser the t user
     * @return the string
     */
    @RequestMapping("/toRegister")
    public String toRegister(TUser tUser) {
        tUser.setId(UUID.randomUUID().toString().replaceAll("-", ""));
        tUser.setPassword(SecureUtil.md5(tUser.getPassword()));
        tUser.setCreateTime(new Date());
        tUserService.toRegister(tUser);
        return "redirect:/";
    }

    /**
     * Check phone string.
     *
     * @param phone the phone
     * @return the string
     */
    @RequestMapping("/checkPhone")
    @ResponseBody
    public String checkPhone(String phone) {
        return JSON.toJSONString(tUserService.checkPhone(phone));
    }
    @RequestMapping("/userList")
    public String userList(TUser tUser, @RequestParam(defaultValue = "1")Integer pageNum,Model model){
        PageHelper.startPage(pageNum,3);
        List<TUser> list = tUserService.userList(tUser);
        PageInfo pageInfo = new PageInfo(list);
        model.addAttribute("userList",list);
        model.addAttribute("pageInfo",pageInfo);
        return "userList";
    }
    @RequestMapping("/information")
    public String information(HttpSession httpSession,Model model){
        TUser attribute = (TUser) httpSession.getAttribute(ConstantFinal.USER_INFO);
        if(null!=attribute){
            model.addAttribute("userInfoMation",attribute);
            return "userMsg";
        }
        model.addAttribute("userInfoMation","非法操作！！");
        return "userMsg";
    }


}
