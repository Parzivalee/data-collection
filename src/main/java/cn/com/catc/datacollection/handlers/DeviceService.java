package cn.com.catc.datacollection.handlers;

import java.util.List;

public interface DeviceService {

    void fileHandler(String filePath, List<String> jsonFiles);

    void jsonHandler(String json);

}
