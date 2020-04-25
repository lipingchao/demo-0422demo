package com.example.demo0422demo.controller;

import com.example.demo0422demo.constant.ConstantFinal;
import com.example.demo0422demo.pojo.TUser;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;

/**
 * The type To index controller.
 *
 * @User lpc /李金超
 * @ClassName TestIndexController 类名
 * @Author AUSUA 作者
 * @Date 2020 /4/24 11:33  时间
 * @Version 1.0 版本
 */
@Controller
public class ToIndexController {


    /**
     * To index string.
     *
     * @param httpSession the http session
     * @param model       the model
     * @return the string
     */
    @RequestMapping("/toIndex")
    public String toIndex(HttpSession httpSession, Model model) {
        TUser attribute = (TUser) httpSession.getAttribute(ConstantFinal.USER_INFO);
        if (null != attribute) {
            model.addAttribute("LoginName", attribute.getLoginName());
            return "index";
        }
        return "redirect:/";
    }

    /**
     * Out user string.
     *
     * @param httpSession the http session
     * @return the string
     */
    @RequestMapping("/outUser")
    public String outUser(HttpSession httpSession){
        httpSession.removeAttribute(ConstantFinal.USER_INFO);
        return "redirect:/";
    }
    @RequestMapping("/testAnt")
    @ResponseBody
    public String test(String name){
        if(null==name){
            name="张三";
        }
        return name;
    }
    @RequestMapping("/toss")
    public String toss(){
        return "ss";
    }
}
