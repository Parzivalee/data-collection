package cn.com.catc.datacollection;

import cn.com.catc.datacollection.config.ScheduleTask;
import cn.com.catc.datacollection.handlers.DeviceService;
import cn.com.catc.datacollection.utils.MyStringUtil;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DataCollectionApplicationTests {

    @Autowired
    private ScheduleTask scheduleTask;

    @Autowired
    private RedisTemplate redisTemplate;

    @Autowired
    private DeviceService deviceService;

    @Test
    public void contextLoads() {
    }

    @Test
    public void testProcess1() {
        scheduleTask.process1();
    }


    @Test
    public void test1() throws Exception {
        //redisTemplate.opsForValue().get("Z:\\FTPJson\\devices\\20005\\10.4.246.26\\memory.json");
        System.out.println("结果："+redisTemplate.opsForValue().get("Z:\\FTPJson\\devices\\20005\\10.1.255.151\\entity.json"));
        //Assert.assertEquals("1111",redisTemplate.opsForValue().get("Z:\\FTPJson\\devices\\20005\\10.4.246.26\\memory.json"));
    }
    @Test
    public void test2(){
        String s = "Z:\\FTPJson\\devices\\20005\\10.4.246.26\\memory.json";
        MyStringUtil.getStringAt(s, 0);
        MyStringUtil.getStringAt(s, 1);
        MyStringUtil.getStringAt(s, 2);
        MyStringUtil.getStringAt(s, 3);
    }

}
