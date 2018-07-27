package jdkstudy.map.hashmap;

import java.util.HashMap;
import java.util.Map;
import java.util.function.BiConsumer;

/**
 * @author zhou
 * Created on 2018/6/26
 */
public class HashMapTest {

    public static void main(String[] args) {

        Map<String, String> hashMap = new HashMap();
        hashMap.put("GAME_EN", "DESC1");
        //返回上一个被覆盖的值
        String a = hashMap.put("GAME_EN", "DESC2");
        String b = hashMap.putIfAbsent("GAME_EN", "DESC3");

        hashMap.put("PERIOD", "ASC");
        hashMap.put("ALREADY_COMPENSATE_AMOUNT", "DESC");
        hashMap.put("PRE_COMPENSATE_AMOUNT", "DESC");
        hashMap.put("ORDER_ID", "DESC");

        System.out.println(a);
        System.out.println(b);


        //HashMap是无序的
        hashMap.forEach(new BiConsumer() {
            @Override
            public void accept(Object o, Object o2) {
                System.out.println("" + o + ";" + o2);
            }
        });
    }
}
