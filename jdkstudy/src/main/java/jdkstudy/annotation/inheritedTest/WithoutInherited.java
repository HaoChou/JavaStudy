package jdkstudy.annotation.inheritedTest;

import java.lang.annotation.*;

/**
 * @author zhouhao
 */
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
public @interface WithoutInherited {
}
