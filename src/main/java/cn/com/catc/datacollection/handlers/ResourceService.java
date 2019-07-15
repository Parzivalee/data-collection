package cn.com.catc.datacollection.handlers;

import java.util.List;

/**
 * 资源JSON文件处理接口
 */
public interface ResourceService {

    void jsonHandler(String json);

    void fileHandler(String resourcepath, List<String> jsonFiles);
}
