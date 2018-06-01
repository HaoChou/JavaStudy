package jdkStudy.annotation.inheritedTest;

/**
 * @author zhouhao
 */
@WithInherited
public class Super {
    public int superPublicVariable;
    private int subPrivateVariable;

    public int superPublicMethod() {
        return 0;
    }

    private int superPrivateMethod() {
        return 0;
    }

}
