package groovy.codecachetest;

import groovy.GroovyCompiler;
import groovy.lang.GroovyClassLoader;

/**
 * @author zhou
 * Created on 2018/9/18
 */
public class GroovyCodeCacheTest {

    public static void main(String[] args) throws Exception {


        Thread.sleep(15000);
        System.out.println("休眠结束！");

        GroovyCompiler  compiler = new GroovyCompiler();
        for(int i=0;i<100000;i++) {
            Class compile = compiler.compile("public class TestCode {\n" +
                    "\n" +
                    "\n" +
                    "    public String get(){\n" +
                    "\n" +
                    "        return System.currentTimeMillis()+" + i+"+\"\";\n" +
                    "    }\n" +
                    "}");

            Object o = (compile.newInstance());

            for(int j=0;j<10000;j++) {
                compile.getMethod("get").invoke(o);
            }

            System.out.println("第"+i+"个结束！");
//            Thread.sleep(3000);
        }
        Thread.sleep(300000);
        System.out.println("休眠结束2！");
    }
}
