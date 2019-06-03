package parentdemo;

/**
 * @author admin
 * @title: Child
 * @projectName ideaDemo
 * @description: TODO
 * @date 2019/5/3114:48
 */
public class Child extends Parent{
    private static  final int aa;
    static {
        aa = 10;
        System.out.println("子类静态快： " + aa);
    }
    public Child() {
        System.out.println("这是子类");
    }
}
