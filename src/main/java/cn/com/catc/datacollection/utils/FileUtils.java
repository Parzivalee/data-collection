package cn.com.catc.datacollection.utils;

import cn.com.catc.datacollection.handlers.*;
import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.Resource;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.Executor;


/**
 * @Description 文件工具类
 * @Author lwj
 * @Date 2019/7/15
 * @Version 1.0
 **/
public class FileUtils {



    @Resource(name = "asyncServiceExecutor")
    private Executor executor;

    /**
     * 获取所有的json文件
     *
     * @param file
     * @param files
     */
    public static void getAllFile(File file, List<String> files) {
        if (file != null) {
            if (file.isDirectory()) {
                File[] fileArray = file.listFiles();
                if (fileArray != null) {
                    for (int i = 0; i < fileArray.length; i++) {
                        //递归调用
                        getAllFile(fileArray[i], files);
                    }
                }
            } else {
                files.add(file.getAbsolutePath());
            }
        }
    }

    /**
     * 获取文件名
     *
     * @param filePath 文件地址
     * @return
     */
    public static String getFileName(String filePath) {
        return filePath.substring(filePath.lastIndexOf("\\") + 1, filePath.lastIndexOf("."));
    }

    /**
     * 以行为单位读取文件，常用于读面向行的格式化文件
     *
     * @param fileName 无引号
     *            文件名
     */
    public static String readFileByLines(String fileName) {
        File file = CreateFile(fileName);
        BufferedReader reader = null;
        String tempString = "";
        StringBuffer tmp = new StringBuffer();
        try {
//            System.out.println("以行为单位读取文件内容，一次读一整行：");
            reader = new BufferedReader(new FileReader(file));
            int line = 1;
            // 一次读入一行，直到读入null为文件结束
            while ((tempString = reader.readLine()) != null) {
                tmp.append(tempString);
                line++;
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e1) {
                }
            }
        }
        return tmp.toString();
    }

    public static File CreateFile(String destFileName) {
        File file = new File(destFileName);
        if (file.exists()) {
            return file;
        }
        if (destFileName.endsWith(File.separator)) {
            return file;
        }
        if (!file.getParentFile().exists()) {
            if (!file.getParentFile().mkdirs()) {
                return file;
            }
        }

        // 创建目标文件
        try {
            if (file.createNewFile()) {
                return file;
            } else {
                return file;
            }
        } catch (IOException e) {
            e.printStackTrace();
            return file;
        }
    }


}
