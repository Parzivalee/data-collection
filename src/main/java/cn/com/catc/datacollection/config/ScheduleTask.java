package cn.com.catc.datacollection.config;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @Description 定时读取指定文件夹的文件
 * @Author lwj
 * @Date 2019/7/12
 * @Version 1.0
 **/
@Component
public class ScheduleTask {

    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");

    @Scheduled(cron = "0 0/5 * * * ?")
    private void process() {

        System.out.println("-------------------定时器1（间隔5分钟）触发--------------------");
        System.out.println("读取文件中的JSON数据，时间："+dateFormat.format(new Date()));
        System.out.println("文件读取完毕，时间："+dateFormat.format(new Date()));
        System.out.println("-------------------定时器执行结束--------------------");


    }
}
