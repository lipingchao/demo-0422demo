package com.example.demo0422demo.utils;


import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Collection;

/**
 * 工具类  用于字符串的判断 或实体  或集合  自写
 *
 * @author AUSUA
 */
public class EmptyUtilsAndRedisConfig {

    /**
     * Is not empty bean boolean.
     *
     * @param obj the obj
     * @return the boolean
     */
    public static Boolean isNotEmptyBean(Object obj) {
        Boolean flag = false;

        try {
            if (null != obj){

                //得到类对象
                Class<?> c = (Class<?>) obj.getClass();

                //得到属性集合
                Field[] fs = c.getDeclaredFields();

                //得到方法体集合
                Method[] methods = c.getDeclaredMethods();

                //遍历属性

                for (Field f : fs) {

                    //设置属性是可以访问的(私有的也可以)
                    f.setAccessible(true);

                    String fieldGetName = parGetName(f.getName());

                    //判断属性是否存在get方法
                    if (!checkGetMet(methods, fieldGetName)) {
                        continue;
                    }

                    //得到此属性的值
                    Object val = f.get(obj);

                    //只要有1个属性不为空,那么就不是所有的属性值都为空
                    if (isNotEmpty((CharSequence) val)) {
                        flag = true;
                        break;
                    }
                }
            }
        } catch (Exception e) {
        }
        return flag;
    }
    private static boolean isNotEmpty(String str) {
        return !isEmpty(str);
    }
    private static boolean isEmpty(String str) {
        return str == null || str.length() == 0;
    }
    /**
     * 拼接某属性的 get方法
     * @param fieldName
     * @return String
     */
    private static String parGetName(String fieldName) {
        if (null == fieldName || "".equals(fieldName)) {
            return null;
        }
        int startIndex = 0;
        if (fieldName.charAt(0) == '_')
            startIndex = 1;
        return "get"
                + fieldName.substring(startIndex, startIndex + 1).toUpperCase()
                + fieldName.substring(startIndex + 1);
    }

    /**
     * 判断是否存在某属性的 get方法
     * @param methods
     * @param fieldGetMet
     * @return boolean
     */
    private static Boolean checkGetMet(Method[] methods, String fieldGetMet) {
        for (Method met : methods) {
            if (fieldGetMet.equals(met.getName())) {
                return true;
            }
        }
        return false;
    }
    /**
     * 获取String不为空
     * @param cs
     * @return
     */
    private static boolean isNotEmpty(CharSequence  cs) {
        return  !isEmpty(cs);
    }

    /**
     * 获取String不为空不为null
     *
     * @param cs the cs
     * @return boolean boolean
     */
    public static boolean isNotEmptyAdnNotNull(CharSequence  cs) {
        return  !isEmpty(cs)&&cs!=null;
    }

    /**
     * 获取String为空
     * @param cs
     * @return
     */
    private static boolean isEmpty(CharSequence cs) {
        int strLen;
        if (cs != null && (strLen = cs.length()) != 0) {
            for(int i = 0; i < strLen; ++i) {
                if (!Character.isWhitespace(cs.charAt(i))) {
                    return false;
                }
            }
            return true;
        } else {
            return true;
        }
    }

    /**
     * 获取interger不为空
     *
     * @param integer the integer
     * @return boolean boolean
     */
    public static boolean isNotEmpty(Integer integer) {
        if (integer != null && isNotEmpty(integer.toString())) {
            return true;
        }else {
            return false;
        }
    }
    /**
     * 获取interger为空
     * @param integer
     *
     * @return
     */
    private static boolean isEmpty(Integer integer) {
        boolean b = isEmpty(integer.toString());
        if (integer == null ||(integer != null && b)) {
            return true;
        }else {
            return false;
        }
    }

    /**
     * 获取集合类是否不为空
     *
     * @param collection the collection
     * @return boolean boolean
     */
    public static boolean isNotEmpty(Collection<?> collection) {
        return  !isEmpty(collection);


    }
    /**
     * 获取集合类是否为空
     * @param collection
     * @return
     */
    private static boolean isEmpty(Collection<?> collection) {
        return collection == null || collection.isEmpty();

    }

    /**
     * 去除空格
     *
     * @param str the str
     * @return string string
     */
    public static String trimAll(String str ){
        return str.trim()
                .replaceAll("[　*| *| *|//s*]*", "")
                .replaceAll("^[　*| *| *|//s*]*", "")
                .replaceAll("[　*| *| *|//s*]*$", "");
    }
}
@Configuration
 class RedisConfig {
    /**
     * Redis template redis template.
     *
     * @param connectionFactory the connection factory
     * @return the redis template
     */
    @Bean
    public RedisTemplate<Object, Object> redisTemplate(RedisConnectionFactory connectionFactory) {
        RedisTemplate<Object, Object> redisTemplate = new RedisTemplate<>();
        redisTemplate.setConnectionFactory(connectionFactory);
        // 使用Jackson2JsonRedisSerialize替换默认序列化
        Jackson2JsonRedisSerializer jackson2JsonRedisSerializer = new Jackson2JsonRedisSerializer(Object.class);
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.setVisibility(PropertyAccessor.ALL, JsonAutoDetect.Visibility.ANY);
        objectMapper.enableDefaultTyping(ObjectMapper.DefaultTyping.NON_FINAL);
        jackson2JsonRedisSerializer.setObjectMapper(objectMapper);
        // 设置key和value的序列化规则
        redisTemplate.setValueSerializer(jackson2JsonRedisSerializer);
        redisTemplate.setKeySerializer(new StringRedisSerializer());
        redisTemplate.afterPropertiesSet();
        return redisTemplate;
    }
}