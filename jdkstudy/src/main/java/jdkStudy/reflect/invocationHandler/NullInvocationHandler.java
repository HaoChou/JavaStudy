package jdkStudy.reflect.invocationHandler;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @author zhou
 * Created on 2018/5/17
 */
public class NullInvocationHandler implements InvocationHandler {

    private Object tar;

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        if (method.getReturnType().equals(String.class))
        {
            return  "哈哈哈String";
        }

        if (method.getReturnType().equals(int.class))
        {
            return  0;
        }


        if (method.getReturnType().equals(Integer.class))
        {
            return  1;
        }

        return "ss";
    }


    public Object bind(Object tar)
    {
        this.tar = tar;
        return Proxy.newProxyInstance(tar.getClass().getClassLoader(),
                tar.getClass().getInterfaces(),
                this);
    }



    public Object bindInterface(Class<?>[] interfaces)
    {
        return Proxy.newProxyInstance(this.getClass().getClassLoader(),
                interfaces,
                this);
    }
}
