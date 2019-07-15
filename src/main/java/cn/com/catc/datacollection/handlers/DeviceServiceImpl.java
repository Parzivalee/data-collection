package cn.com.catc.datacollection.handlers;

import cn.com.catc.datacollection.entity.devices.Cpu;
import cn.com.catc.datacollection.utils.FileUtils;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import sun.plugin2.gluegen.runtime.CPU;

import java.util.Date;
import java.util.List;
import java.util.concurrent.Executor;

/**
 * @Description 设备JSON文件处理类
 * @Author lwj
 * @Date 2019/7/15
 * @Version 1.0
 **/
@Slf4j
@Service
public class DeviceServiceImpl implements DeviceService {

    private static final String DEVICESPATH = "devicesPath";
    private static final String SERVERSPATH = "serversPath";
    private static final String MANAGEPATH = "managePath";
    private static final String RESOURCEPATH = "resourcePath";
    private static final String SYSTEMPATH = "systemPath";

    @Autowired
    private RedisTemplate redisTemplate;

    @Autowired
    private Executor executor;

    @Async
    public void fileHandler(String filePath, List<String> jsonFiles) {
        System.out.println("工作线程："+Thread.currentThread().getName());
        System.out.println(jsonFiles.size());
        jsonFiles.stream().forEach(json -> {
            if (json != null)
                this.jsonHandler(json);
        });

    }

    public void jsonHandler(String jsonPath) {
        switch (FileUtils.getFileName(jsonPath)) {
            case "cpu":
                operationCpu(jsonPath);
                break;
            case "entity":
                operationEntity(jsonPath);
                break;
            case "ifvalue":
                operationIfValue(jsonPath);
                break;
            case "interface":
                operationInterface(jsonPath);
                break;
            case "memory":
                operationMemory(jsonPath);
                break;
            case "sys":
                operationSys(jsonPath);
                break;
            case "vlan":
                operationVlan(jsonPath);
                break;
            default:
                break;
        }
    }

    public void operationCpu(String jsonPath) {
        try {
            //将json转对象
            String jsonContent = FileUtils.readFileByLines(jsonPath);
            JSONArray jsonArray = JSONArray.parseArray(jsonContent);
            int size = jsonArray.size();
            String filePath = FileUtils.getFileName(jsonPath);
            //遍历Json
            for (int i = 0; i < size; i++) {
                Cpu cpu = new Cpu();
                //对象赋值及insert
                JSONObject jsonObject = jsonArray.getJSONObject(i);

                try {
                    cpu.setCpuindex(Integer.parseInt(jsonObject.getString("index")));
                } catch (Exception e) {
                    log.error("ERROR index", e);
                }
                try {
                    cpu.setValue(Double.parseDouble(jsonObject.getString("value")));
                } catch (Exception e) {
                    log.error("ERROR value", e);
                }

                cpu.setUpdateTime(new Date());

                redisTemplate.opsForValue().set(jsonPath, cpu);
            }
        } catch (Exception e) {
            log.error("ERROR", e);
        }
    }

    public void operationEntity(String jsonPath) {

    }

    public void operationIfValue(String jsonPath) {

    }

    public void operationInterface(String jsonPath) {

    }

    public void operationMemory(String jsonPath) {

    }

    public void operationSys(String jsonPath) {

    }

    public void operationVlan(String jsonPath) {

    }

}
