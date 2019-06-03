package parentdemo;

/**
 * @author admin
 * @title: Parent
 * @projectName ideaDemo
 * @description: TODO
 * @date 2019/5/3114:47
 */
public class Parent {

    private static  final int a ;
    static {
        a = 10;
        System.out.println("付类静态快： " + a);
    }
    public Parent() {
        System.out.println("这是父类");
    }
}
