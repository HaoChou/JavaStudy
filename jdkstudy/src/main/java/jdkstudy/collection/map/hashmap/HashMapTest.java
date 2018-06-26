package jdkstudy.collection.map.hashmap;

import java.util.HashMap;
import java.util.Map;
import java.util.function.BiConsumer;

/**
 * @author zhou
 * Created on 2018/6/26
 */
public class HashMapTest {

    public static void main(String[] args) {

        Map hashMap = new HashMap();
        hashMap.put("GAME_EN", "DESC");
        hashMap.put("PERIOD", "ASC");
        hashMap.put("ALREADY_COMPENSATE_AMOUNT","DESC");
        hashMap.put("PRE_COMPENSATE_AMOUNT", "DESC");
        hashMap.put("ORDER_ID","DESC");



        //HashMap是无序的
        hashMap.forEach(new BiConsumer() {
            @Override
            public void accept(Object o, Object o2) {
                System.out.println(""+o+";"+o2);
            }
        });
    }
}
