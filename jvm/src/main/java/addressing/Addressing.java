package addressing;

import sun.misc.Unsafe;

import java.lang.reflect.Field;

/**
 * @author zhou
 * 来自 https://stackoverflow.com/questions/13860194/what-is-an-internal-address-in-java
 * Created on 2018/8/1
 */
public class Addressing {


    public static void main(String[] args) throws NoSuchFieldException, IllegalAccessException {


        Field theUnsafe = Unsafe.class.getDeclaredField("theUnsafe");
        theUnsafe.setAccessible(true);
        Unsafe unsafe = (Unsafe) theUnsafe.get(null);

        for (int t = 0; t < 10; t++) {
            System.gc();
            Object[] objects = new Object[10];
            for (int i = 0; i < objects.length; i++)
                objects[i] = new Object();

            for (int i = 0; i < objects.length; i++) {
                if (i > 0) System.out.print(", ");
                int location = unsafe.getInt(objects, Unsafe.ARRAY_OBJECT_BASE_OFFSET + Unsafe.ARRAY_OBJECT_INDEX_SCALE * i);
                System.out.printf("%08x: hc= %08x : %s", location, objects[i].hashCode(), objects[i].toString());
            }
            System.out.println();
        }
    }
}
