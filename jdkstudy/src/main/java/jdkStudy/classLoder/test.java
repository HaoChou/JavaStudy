package jdkStudy.classLoder;

import com.sun.org.apache.bcel.internal.generic.NEW;

import java.math.BigDecimal;

/**
 * @author zhou
 * Created on 2018/4/2
 */
public class test {

    public static void main(String[] args) {

        BigDecimal bb = new BigDecimal("69");
        bb=bb.setScale(2, BigDecimal.ROUND_HALF_UP);
        System.out.println(bb);
        System.out.println(System.class.getClassLoader());
        System.out.println(test.class.getClassLoader());
        System.out.println(test.class.getClassLoader().getParent());
        System.out.println(test.class.getClassLoader().getResource("/test/jvm.txt"));
        System.out.println(test.class.getClassLoader().getClass());
        System.out.println(test.class.getClassLoader().getClass().getClassLoader());

        System.out.println(ClassLoader.getSystemClassLoader().getClass());


        String a = "10301_AwardDetail_T001_18048.txt";
        String[] split = a.split("\\.");
        System.out.println(split);
        String  b ="01,02,04,05,29|01,05";
        System.out.println(convertLeShanMa(b));



    }

    /**
     * 转化乐善码
     * @param codeIn 01，02，03，04，05|06，07
     * @return 01 02 03 04 05:06 07
     */
    public static String convertLeShanMa(String codeIn)

    {
        return codeIn.replaceAll(","," ").replaceAll("\\|",":");
    }

}
