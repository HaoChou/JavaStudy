package jdkstudy.event;

/**
 * @author zhou
 * Created on 2018/5/25
 */
public class Test {

    public static void main(String[] args) {
        MyObject mo=new MyObject();
        //注册该事件
        mo.addMyListener(new MyListener());

//触发该事件
        mo.test();
    }
}
