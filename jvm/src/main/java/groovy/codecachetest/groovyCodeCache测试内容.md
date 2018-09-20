* JIT：Just In Time Compiler是即时编译器，这是是针对解释型语言而言的一种优化手段。

* HotSpot虚拟机的执行引擎在执行Java代码是可以采用【解释执行】和【编译执行】两种方式的，如果采用的是编译执行方式，那么就会使用到JIT，而解释执行就不会使用到JIT。

* JVM会把热点代码进行编译，编译后缓存在CodeCache，这样热点代码的执行效率得到提高。



Groovy可以在JVM上运行的动态的语言。昨天分享的淘金活动系统中又用到了Groovy，于是想到了之前的一个问题，这里实验一下看看结论。

问题：
JVM加载不同的类（Groovy编译而成）后，方法变成热点代码并且被codeCache缓存后,脚本被更新，新的代码成为热点代码，如此反复，会怎么样？（成为类可能随时发生变化，变化次数未知）。



下面的测试就是基于 【很多次的修改Groogy脚本然后运行】 的前提的，模拟多次修改Groovy脚本的场景。

（例如放假期间 服务没有发布，不重启，频繁的上传新的groogy脚本，脚本较大，有可能会踩坑）



下面是模拟了以下不同的Groovy脚本生成的方法多次执行后CodeCache的变化，直到245M占满后编译器停止工作。

编译器停止工作带来的影响是会导致原本的热点代码可能无法被编译运行速度变慢，系统吞吐率变小。

中间又多次GC但是CodeCache没有被回收。

本地java版本

        java version "1.8.0_144"
        Java(TM) SE Runtime Environment (build 1.8.0_144-b01)
        Java HotSpot(TM) 64-Bit Server VM (build 25.144-b01, mixed mode)



上图中CodeCache满了之后就不会再增加，后面的曲线呈水平。

系统提示的编译器停止工作.
           
        CodeCache is full. Compiler has been disabled
        


-XX:ReservedCodeCacheSize=20m  -XX:+UseCodeCacheFlushing 
ReservedCodeCacheSize设置codecache的值， +UseCodeCacheFlushing  是打开codecache的Flush功能，关闭后codeCache不会回收，打开后codeCache会进行回收。

在看下另外一个内存区 Comresssed Class Space也一直增长

疑点：不随着GC而回收 也没有随着Groovy的ClassLoader的回收被回收（每次编译都用一个新的GroovyClassLoader实例的）

JDK8内存模型默认已经没有PermGen了，也就是说不会发生OOM:PermGen space了。

但是使用的是LVS自带的内存，所以最好还是指定这个参数-XX:MaxMetaspaceSize=XXXm控制下大小 ，否则就有可能吃光LVS的内存。





        测试代码
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


        GroovyCompiler
        public class GroovyCompiler  implements DynamicCodeCompiler{
         
            @Override
            public Class compile(String sCode) throws Exception {
                GroovyClassLoader loader = getGroovyClassLoader();
                Class groovyClass = loader.parseClass(sCode);
                return groovyClass;
            }
         
            @Override
            public Class compile(File file) throws Exception {
                GroovyClassLoader loader = getGroovyClassLoader();
                Class groovyClass = loader.parseClass(file);
                return groovyClass;
            }
         
            GroovyClassLoader getGroovyClassLoader() {
                return new GroovyClassLoader();
            }
         
        }
        
        
