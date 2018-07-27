package jdkstudy.collection.set.treeset;

import java.util.Iterator;
import java.util.TreeSet;

/**
 * @author zhou
 * Created on 2018/6/9
 */
public class TreeSetTest {
    public static void main(String[] args) {
        TreeSet<String> tree = new TreeSet<String>();
        tree.add("123");
        tree.add("123");
        tree.add("121");
        tree.add("192");
        tree.add("102");
        System.out.println(tree.size());

        Iterator<String> iterator = tree.iterator();
        System.out.print("Tree set data: ");
        while (iterator.hasNext()) {
            System.out.print(iterator.next() + " ");
        }

    }
}
