package jdkStudy.event;

import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

/**
 * @author zhou
 * Created on 2018/5/25
 */
public class MyObject {

    private Vector vectorListeners=new Vector();

    public synchronized void addMyListener(MyListener ml)
    {
        vectorListeners.addElement(ml);
    }

    public synchronized void removeMyListener(MyListener ml)
    {
        vectorListeners.removeElement(ml);
    }

    protected void activateMyEvent()
    {
        Vector tempVector=null;

        MyEvent e=new MyEvent(this);

        synchronized(this)
        {
            tempVector=(Vector)vectorListeners.clone();

            for(int i=0;i<tempVector.size();i++)
            {
                MyListener ml=(MyListener)tempVector.elementAt(i);
                ml.EventActivated(e);
            }
        }

    }

    //定义一个公用方法用于触发事件
    public void test()
    {
        activateMyEvent();
    }

    public static void main(String[] args) {
        List a  = null;

        for (Object b : new ArrayList<Object>())
        {
            System.out.println("1");
        }
        System.out.println("2");

    }
}
