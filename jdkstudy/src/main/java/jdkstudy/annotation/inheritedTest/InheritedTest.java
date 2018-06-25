package jdkstudy.annotation.inheritedTest;

import java.util.Arrays;

/**
 * Inherited的测试类.
 * <p>
 * 可以通过注释掉 {@link WithInherited} 的@Inherited注解进行测试 分析main方法输出结果。
 *
 * @author zhouhao
 */
public class InheritedTest {
    public static void main(String[] args) {
        Class<Sub> clazz = Sub.class;
        System.out.println("============================Field===========================");

        System.out.println(Arrays.toString(clazz.getFields()));
        System.out.println(Arrays.toString(clazz.getDeclaredFields()));

        System.out.println("============================Method===========================");
        System.out.println(Arrays.toString(clazz.getMethods()));
        System.out.println(Arrays.toString(clazz.getDeclaredMethods()));

        System.out.println("============================Constructor===========================");
        System.out.println(Arrays.toString(clazz.getConstructors()));
        System.out.println(Arrays.toString(clazz.getDeclaredConstructors()));


        System.out.println("============================Annotation===========================");
        //注解WithInherited是否存在于元素上
        System.out.println(clazz.isAnnotationPresent(WithInherited.class));
        System.out.println(clazz.isAnnotationPresent(WithoutInherited.class));

        //如果存在该元素的指定类型的注解WithInherited，则返回这些注释，否则返回 null。
        System.out.println(clazz.getAnnotation(WithInherited.class));
        System.out.println(Arrays.toString(clazz.getAnnotations()));
        System.out.println(Arrays.toString(clazz.getDeclaredAnnotations()));
    }
}
