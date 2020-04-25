package com.example.demo0422demo.timing;

import com.example.demo0422demo.dao.TBootMapper;
import com.example.demo0422demo.pojo.TBoot;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * The type Time sear ch.
 *
 * @User lpc /李金超
 * @ClassName timeSearCh 类名
 * @Author AUSUA 作者
 * @Date 2020 /4/22 16:34  时间
 * @Version 1.0 版本
 */
@Component
public class timeSearCh {

    @Autowired
    private RedisTemplate redisTemplate;

    @Autowired
    private TBootMapper tBootMapper;

    /**
     * 定时器
     */
    @Scheduled(fixedDelay = 50000)
    public void timSearCh() {
        List<TBoot> tBoots = tBootMapper.selectByExample(null);
        for (TBoot t : tBoots) {
            if (redisTemplate.hasKey(t.getId())) {
                Integer o = (Integer) redisTemplate.opsForValue().get(t.getId());
                t.setTraffic((long) o);
                tBootMapper.updateByPrimaryKey(t);
            }
        }
        System.out.println("开始执行同步操作！！ 稍等！！timSearCh--------------------------------------------Hello");
    }

}
