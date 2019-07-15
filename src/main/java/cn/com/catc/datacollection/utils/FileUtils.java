package cn.com.catc.datacollection.utils;

import java.io.File;
import java.util.List;

/**
 * @Description 文件工具类
 * @Author lwj
 * @Date 2019/7/15
 * @Version 1.0
 **/
public class FileUtils {

    /**
     * 获取所有的json文件
     * @param file
     * @param files
     */
    public static void getAllFile(File file, List<String> files){
        if(file != null){
            if(file.isDirectory()){
                File[] fileArray=file.listFiles();
                if(fileArray!=null){
                    for (int i = 0; i < fileArray.length; i++) {
                        //递归调用
                        getAllFile(fileArray[i],files);
                    }
                }
            }else{
                files.add(file.getAbsolutePath());
            }
        }
    }

    /**
     * 获取文件名
     * @param filePath 文件地址
     * @return
     */
    public static String getFileName(String filePath) {
        return filePath.substring(filePath.lastIndexOf("\\")+1,filePath.lastIndexOf("."));
    }
}
