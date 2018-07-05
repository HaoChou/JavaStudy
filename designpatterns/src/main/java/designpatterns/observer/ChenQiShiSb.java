package designpatterns.observer;

import com.alibaba.fastjson.JSON;

import java.util.HashMap;
import java.util.List;

/**
 * @author zhou
 * C
 * reated on 2018/7/1
 */
public class ChenQiShiSb {

    public static void main(String[] args) {

        String testStr = "{\"32\":\"江苏\"}";

        HashMap hashMaps = JSON.parseObject(testStr, HashMap.class);

//        System.out.println(System.getProperty("sun.boot.class.path"));
        System.out.println(System.getProperty("java.ext.dirs"));
    }
}
