package jdkstudy.annotation.inheritedTest;

/**
 * @author zhouhao
 */
@WithoutInherited
public class Sub extends Super {
    public int subPublicVariable;
    private int subPrivateVariable;

    public int subPublicMethod() {
        return 0;
    }

    private int subPrivateMethod() {
        return 0;
    }

    @Override
    public int superPublicMethod() {
        return super.superPublicMethod();
    }
}
