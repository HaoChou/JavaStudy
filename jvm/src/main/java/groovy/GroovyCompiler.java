package groovy;

import groovy.lang.GroovyClassLoader;
import java.io.File;

//Created by zhou on 2017/10/24
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
