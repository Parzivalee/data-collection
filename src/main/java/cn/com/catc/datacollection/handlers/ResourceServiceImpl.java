package cn.com.catc.datacollection.handlers;

import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @Description 资源JSON文件处理类
 * @Author lwj
 * @Date 2019/7/15
 * @Version 1.0
 **/
@Component
public class ResourceServiceImpl implements ResourceService {

    private static final String DEVICESPATH = "devicesPath";
    private static final String SERVERSPATH = "serversPath";
    private static final String MANAGEPATH = "managePath";
    private static final String RESOURCEPATH = "resourcePath";
    private static final String SYSTEMPATH = "systemPath";

    @Override
    public void jsonHandler(String json) {

    }

    @Override
    public void fileHandler(String resourcepath, List<String> jsonFiles) {

    }

}
