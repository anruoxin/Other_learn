package loader;

import java.lang.reflect.Method;

/**
 * @author admin
 * @title: Main
 * @projectName ideaDemo
 * @description: TODO
 * @date 2019/5/309:52
 */
public class Main {
    public static void main(String[] args) throws Exception {

        TestClassLoader testClassLoader = new TestClassLoader();
        Class<?> aClass = testClassLoader.loadClass("cn.weicelove.anruoxin.Test");
        if (aClass == null){
            System.out.println("加载出错");
            return;
        }
        Object o = aClass.newInstance();
        Method count = aClass.getDeclaredMethod("count");
        count.invoke(o);
    }
}
