package jdkStudy.annotation.inheritedTest;

import java.lang.annotation.*;

/**
 * @author zhouhao
 */
@Documented
@Inherited //加上这行 在子类sub中 clazz.getAnnotations() 可以拿到 WithInherited
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
public @interface WithInherited {
}
