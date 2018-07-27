package designpatterns.factory;

import com.alibaba.fastjson.JSON;

import java.util.AbstractList;
import java.util.List;

/**
 * @author zhou
 * Created on 2018/7/3
 */
public class ListFactory {


    static List<Integer> intArrayAsList(final int[] a){
        if(a==null)
            throw new NullPointerException();

        return new AbstractList<Integer>() {
            @Override
            public Integer get(int index) {
                return a[index];//autoboxing
            }

            @Override public Integer set(int i , Integer value) {
                int oldValue = a[i];
                a[i]=value;//unboxing
                return oldValue;//autoboxing
            }
            @Override
            public int size() {
                return a.length;
            }
        };
    }


    public static void main(String[] args) {
        int[] testArray = new int[]{1,3,4,2,3};

        List<Integer> list= intArrayAsList(testArray);

        Integer a = list.get(2);
        System.out.println(JSON.toJSON(list));
        list.set(2,0);
        testArray[4]=0;
        System.out.println(JSON.toJSON(list));


    }
}
