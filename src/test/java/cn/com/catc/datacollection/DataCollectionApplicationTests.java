package cn.com.catc.datacollection;

import cn.com.catc.datacollection.config.ScheduleTask;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DataCollectionApplicationTests {

    @Autowired
    private ScheduleTask scheduleTask;

    @Autowired
    private RedisTemplate redisTemplate;

    @Test
    public void contextLoads() {
    }

    @Test
    public void testProcess1() {
        scheduleTask.process1();
    }


    @Test
    public void test1() throws Exception {
        redisTemplate.opsForValue().set("lwj","1111");
        System.out.println("lwj值："+redisTemplate.opsForValue().get("lwj"));
        Assert.assertEquals("1111",redisTemplate.opsForValue().get("lwj"));
    }

}
