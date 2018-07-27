package jdkstudy.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @author zhou
 * Created on 2018/7/5
 */
public class FallbackInvocationHandler<T>  implements InvocationHandler {

    private Class<T> tar;
    //绑定委托对象，并返回代理类
    public T bind(Class<T> a)
    {
        this.tar = a;
        //绑定该类实现的所有接口，取得代理类
        return (T) Proxy.newProxyInstance(FallbackInvocationHandler.class.getClassLoader(), new Class[]{a}, this);
    }


    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {


        if(method.getReturnType().equals(boolean.class))
        {
            return false;
        }else  if(method.getReturnType().equals(byte.class))
        {
            return (byte)0;
        }else if(method.getReturnType().equals(char.class))
        {
            return (char)0;
        }else if(method.getReturnType().equals(short.class))
        {
            return (short)0;
        }else if(method.getReturnType().equals(int.class))
        {
            return (int)0;
        }else if(method.getReturnType().equals(long.class))
        {
            return (long)0;
        }else if(method.getReturnType().equals(float.class))
        {
            return (float)0;
        }else if(method.getReturnType().equals(double.class))
        {
            return (double)0;
        }else if(method.getReturnType().equals(void.class))
        {
            System.out.println("doNothing");
        }
        return null;
    }
}
