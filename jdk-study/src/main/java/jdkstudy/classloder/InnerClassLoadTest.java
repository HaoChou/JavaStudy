package jdkstudy.classloder;

/**
 * @author zhou
 * Created on 2018/6/28
 */
public class InnerClassLoadTest {


    public static class Inner{

        public final static InnerClassLoadTest testInstance = new InnerClassLoadTest(3);
        public final static Test2 test2 = new Test2();


        static {
            System.out.println("TestInner Static!");
        }

    }

    public static InnerClassLoadTest getInstance(){
        return Inner.testInstance;
    }

    public InnerClassLoadTest(int i ) {
        System.out.println("Test " + i +" Construct! ");
    }

    public final static Test2 test2 = new Test2();

    static {
        System.out.println("Test Stataic");
    }

    public static InnerClassLoadTest testOut = new InnerClassLoadTest(1);

    public static void main(String args[]){
        InnerClassLoadTest t = new InnerClassLoadTest(2);
        InnerClassLoadTest.getInstance();
    }

}
