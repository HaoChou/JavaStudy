package jdkstudy.classloder;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

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
        System.out.println(test.class.getClassLoader().getResource("/jdkstudy/jvm.txt"));
        System.out.println(test.class.getClassLoader().getClass());
        System.out.println(test.class.getClassLoader().getClass().getClassLoader());

        System.out.println(ClassLoader.getSystemClassLoader().getClass());


        String a = "10301_AwardDetail_T001_18048.txt";
        String[] split = a.split("\\.");
        System.out.println(split);
        String  b ="01,02,04,05,29|01,05";
        System.out.println(convertLeShanMa(b));


        List<String> lotteryOrderList = new ArrayList<>();

        lotteryOrderList.add("1");
        lotteryOrderList.add("3");
        lotteryOrderList.add("5");
        lotteryOrderList.add("2");
        lotteryOrderList.sort(new Comparator<String>()
        {//根据 period从小大到大排序
            @Override
            public int compare(String o1, String o2)
            {
                return o1.compareTo(o2);
            }
        });

        System.out.println(lotteryOrderList);

        BigDecimal currentBonus =new BigDecimal("100");
        if(null != currentBonus && currentBonus.compareTo(new BigDecimal(0)) > 0) {
            System.out.println("!!!!1");
        }


        for(int i=0;i<5;i++)
        {
            if(i==1)
            {
                continue;
            }
            System.out.println(i);

        }

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
