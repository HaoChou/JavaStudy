package jdkstudy.proxy;

import java.lang.reflect.InvocationHandler;

/**
 * @author zhou
 * Created on 2018/7/5
 */
public class ProxyTest {

    public static void main(String[] args) {

        FallbackInvocationHandler<ITargetService> fallbackInvocationHandler = new FallbackInvocationHandler<ITargetService>();

        ITargetService bind = fallbackInvocationHandler.bind(ITargetService.class);

        boolean b=bind.getBoolean();
        byte bytE=bind.getByte();
        char c=bind.getChar();
        short aShort=bind.getShort();
        int aInt=bind.getInt();
        long aLong=bind.getLong();
        float aFloat=bind.getFloat();
        double aDouble=bind.getDouble();
        bind.getVoid();


        String s= bind.getString();
        Integer integer= bind.getInteger();

        System.out.println(s);
        System.out.println(bind==null);


        System.out.println(InvocationHandler.class.isInterface());
//        System.out.println(Long.class.());

    }
}
