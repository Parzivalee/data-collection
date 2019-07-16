package cn.com.catc.datacollection.utils;

/**
 * User :Administrator
 * Date:2019年7月16日14:42:25
 * Version:1.0
 */
public class MyStringUtil {
    public static String getStringAt(String str,int index){
        String result = null;
        if (str !=null){
            String[] strArr = str.split("\\\\");
            if (strArr!=null&&index<strArr.length){
                result= strArr[index];
            }
        }
        return result;
    }
}
