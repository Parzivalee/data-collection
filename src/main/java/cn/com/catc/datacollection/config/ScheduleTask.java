package cn.com.catc.datacollection.config;

import cn.com.catc.datacollection.handlers.DeviceService;
import cn.com.catc.datacollection.handlers.ResourceService;
import cn.com.catc.datacollection.handlers.ServerService;
import cn.com.catc.datacollection.utils.FileUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @Description 定时读取指定文件夹的文件
 * @Author lwj
 * @Date 2019/7/12
 * @Version 1.0
 **/
@Slf4j
@Component
public class ScheduleTask {

    private static final String DEVICESPATH = "devicesPath";
    private static final String SERVERSPATH = "serversPath";
    private static final String MANAGEPATH = "managePath";
    private static final String RESOURCEPATH = "resourcePath";
    private static final String SYSTEMPATH = "systemPath";

    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");

    @Value("${ftpjson.devices-path}")
    private String devicesPath;
    @Value("${ftpjson.servers-path}")
    private String serversPath;
    @Value("${ftpjson.manage-path}")
    private String managePath;
    @Value("${ftpjson.resource-path}")
    private String resourcePath;
    @Value("${ftpjson.system-path}")
    private String systemPath;

    @Autowired
    private DeviceService deviceService;
    @Autowired
    private ServerService serverService;
    @Autowired
    private ResourceService resourceService;

    /**
     * 定时器1-间隔5分钟触发
     */
    @Scheduled(cron = "0 0/5 * * * ?")
    public void process1() {
        System.out.println("-------------------定时器1（间隔5分钟）触发--------------------");
        System.out.println("读取文件中的JSON数据，时间：" + dateFormat.format(new Date()));
        try {
            //读取设备文件夹的json文件
            File devicesDirectory = new File(devicesPath);
            List<String> devicesJsonFiles = new ArrayList<>();
            //读取指定文件夹下所有json文件
            FileUtils.getAllFile(devicesDirectory, devicesJsonFiles);
            System.out.println("->"+devicesJsonFiles.size()+"-->"+devicesDirectory.getAbsolutePath());
            //对文件内容进行加工处理
            deviceService.fileHandler(DEVICESPATH,devicesJsonFiles);

            //读取服务器文件夹的json文件
            File serversDirectory = new File(serversPath);
            List<String> serversJsonFiles = new ArrayList<>();
            //读取指定文件夹下所有json文件
            FileUtils.getAllFile(serversDirectory, serversJsonFiles);
            System.out.println("->"+serversJsonFiles.size()+"-->"+serversDirectory.getAbsolutePath());
            //对文件内容进行加工处理
            serverService.fileHandler(SERVERSPATH,serversJsonFiles);
        }catch (Exception e) {
            log.error("文件解析失败",e);
        }

        System.out.println("文件读取完毕，时间：" + dateFormat.format(new Date()));
        System.out.println("-------------------定时器执行结束--------------------");

    }

    /**
     * 定时器2-间隔3分钟触发
     */
    @Scheduled(cron = "0 0/3 * * * ?")
    public void process2() {

        System.out.println("-------------------定时器2（间隔3分钟）触发--------------------");
        System.out.println("读取文件中的JSON数据，时间：" + dateFormat.format(new Date()));
        File JSONDirectory = new File(resourcePath);
        List<String> JsonFiles = new ArrayList<>();
        //读取resource文件夹下所有json文件
        FileUtils.getAllFile(JSONDirectory, JsonFiles);
        System.out.println("->"+JsonFiles.size()+"-->"+JSONDirectory.getAbsolutePath());
        //对文件内容进行加工处理
        resourceService.fileHandler(RESOURCEPATH,JsonFiles);

        System.out.println("文件读取完毕，时间：" + dateFormat.format(new Date()));
        System.out.println("-------------------定时器执行结束--------------------");

    }

}
