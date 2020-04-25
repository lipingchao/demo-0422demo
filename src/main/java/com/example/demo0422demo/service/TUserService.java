package com.example.demo0422demo.service;

import cn.hutool.crypto.SecureUtil;
import com.example.demo0422demo.dao.TUserMapper;
import com.example.demo0422demo.pojo.TUser;
import com.example.demo0422demo.pojo.TUserExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * The type T user service.
 *
 * @User lpc /李金超
 * @ClassName TUserService 类名
 * @Author AUSUA 作者
 * @Date 2020 /4/22 13:59  时间
 * @Version 1.0 版本
 */
@Service
public class TUserService {

    @Autowired
    private TUserMapper tUserDao;

    /**
     * 登陆
     *
     * @param tUser the t user
     * @return t user
     */
    public TUser login(TUser tUser) {
        tUser.setPassword(SecureUtil.md5(tUser.getPassword()));
        TUserExample tUserExample = new TUserExample();
        tUserExample.createCriteria().andLoginNameEqualTo(tUser.getLoginName()).andPasswordEqualTo(tUser.getPassword());
        List<TUser> tUsers = tUserDao.selectByExample(tUserExample);
        if(null!=tUsers&&tUsers.size()>0){
            return tUsers.get(0);
        }
        return null;
    }

    /**
     * 检查注册的手机号是否已存在
     *
     * @param phone the phone
     * @return string
     */
    public String checkPhone(String phone) {
        TUserExample tUserExample = new TUserExample();
        tUserExample.createCriteria().andPhoneEqualTo(phone);
        List<TUser> tUsers = tUserDao.selectByExample(tUserExample);
        if(null!=tUsers&&tUsers.size()>0){
            return "no";
        }
        return "yes";
    }

    /**
     * 去注册
     *
     * @param tUser the t user
     */
    public void toRegister(TUser tUser) {
        tUserDao.insert(tUser);
    }

    public List<TUser> userList(TUser tUser) {
        return tUserDao.userList(tUser);
    }
}
