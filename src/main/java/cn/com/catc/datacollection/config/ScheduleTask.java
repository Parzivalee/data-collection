package cn.com.catc.datacollection.config;

import cn.com.catc.datacollection.utils.FileUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @Description 定时读取指定文件夹的文件
 * @Author lwj
 * @Date 2019/7/12
 * @Version 1.0
 **/
@Component
public class ScheduleTask {

    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");

    @Value("{FTPJson.path}")
    private String path;

    @Scheduled(cron = "0 0/5 * * * ?")
    private void process() {

        System.out.println("-------------------定时器1（间隔5分钟）触发--------------------");
        System.out.println("读取文件中的JSON数据，时间：" + dateFormat.format(new Date()));
        File JSONDirectory = new File(path);
        List<String> JsonFiles = new ArrayList<>();
        //读取json文件夹下所有json文件
        FileUtils.getAllFile(JSONDirectory, JsonFiles);
        //System.out.println("->"+JSONfiles.size()+"-->"+JSONDirectory.getAbsolutePath());
        //对文件内容进行加工处理
        /*JsonFiles.parallelStream().forEach(json -> {
            switch (FileUtils.getFileName(json)) {
                case "ips":
                    OperationIps(json);
                    break;
                case "ipsegs":
                    OperationIpsegs(json);
                    break;
                case "netdevs":
                    OperationNetdevs(json);
                    break;
                case "racks":
                    OperationRacks(json);
                    break;
                case "room":
                    OperationRoom(json);
                    break;
                case "servers":
                    OperationServers(json);
                    break;
                case "useats":
                    OperationUseats(json);
                    break;
                case "user":
                    OperationUser(json);
                    break;
                default:
                    break;
            }
        });*/

        System.out.println("文件读取完毕，时间：" + dateFormat.format(new Date()));
        System.out.println("-------------------定时器执行结束--------------------");


    }
}
