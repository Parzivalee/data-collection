package cn.com.catc.datacollection.handlers;

import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @Description 服务器JSON文件处理类
 *
 * @Author lwj
 * @Date 2019/7/15
 * @Version 1.0
 **/

public interface ServerService {

    void jsonHandler(String json);

    void fileHandler(String serverspath, List<String> serversJsonFiles);
}
