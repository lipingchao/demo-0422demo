package com.example.demo0422demo.filter;

import com.example.demo0422demo.utils.UploadUtils;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.ArrayList;
import java.util.List;

/**
 * The type Web mvc config.
 *
 * @User lpc /李金超
 * @ClassName WebMvcConfig 类名
 * @Author AUSUA 作者
 * @Date 2020 /4/22 16:39  时间
 * @Version 1.0 版本
 */
@Configuration
public class WebMvcConfig implements WebMvcConfigurer {
    /**
     * 虚拟映射目录
     * @param registry
     */
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        String s = UploadUtils.DuanUrl();
        String s1 = UploadUtils.LongUrl();
        registry.addResourceHandler(s).addResourceLocations("file:/" + s1);
        registry.addResourceHandler("/static/**").addResourceLocations("classpath:/static/");
    }

    /**
     * Add Spring MVC lifecycle interceptors for pre- and post-processing of
     * controller method invocations and resource handler requests.
     * Interceptors can be registered to apply to all requests or be limited
     * to a subset of URL patterns.
     *
     * @param registry
     */
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        List<String> list = new ArrayList<>();
        list.add("/static/**");
        list.add("/");
        list.add("/toLogin");
        list.add("/register");
        list.add("/toRegister");
        list.add("/checkPhone");
        list.add("/toHome");
        registry.addInterceptor(new MyHandel()).addPathPatterns("/**").excludePathPatterns(list);
    }
}

