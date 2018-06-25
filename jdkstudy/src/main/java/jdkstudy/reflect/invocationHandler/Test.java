package jdkstudy.reflect.invocationHandler;

/**
 * @author zhou
 * Created on 2018/5/17
 */
public class Test {


    public static void main(String[] args) {

        Class<?>[] interfaces = new Class[]{Worker.class};

//        NotNullWorker notNullWorker =new NotNullWorker();
//        System.out.println( notNullWorker.sayHello());

        NullInvocationHandler handler = new NullInvocationHandler();


        Worker b = (Worker) handler.bindInterface(new Class[]{Worker.class});

        String nullHello =b.sayHello();

        Integer bInteger = b.getAgeInteger();
        int bInt =b.getAgeInt();



        System.out.println(nullHello);
    }
}
