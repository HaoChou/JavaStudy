package jdkStudy.enumStudy;

/**
 * @author zhou
 * Created on 2018/5/31
 */
public enum TestEnum {

    ERROR("error","-1"),
    SUCCESS("success","1");


    private String name;
    private String code;
    TestEnum(String name,String code){
        this.name=name;
        this.code=code;
    }

    public static void main(String[] args) {
        System.out.println(ERROR.ordinal());
        System.out.println(SUCCESS.ordinal());
    }

}
