package addressing;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author zhou
 * Created on 2018/8/2
 */
public class HashCodeTest {


    public static void main(String[] args)
    {
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < 300000; i++)
        {
            HashCodeTest p = new HashCodeTest();
            if (!set.contains(p.hashCode()))
                set.add(p.hashCode());
        }
        System.out.println(set.size());
        //299981 hashCode是会重复的
    }

}
