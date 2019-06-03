package interfacedemo;

/**
 * @author admin
 * @title: Main
 * @projectName ideaDemo
 * @description: TODO
 * @date 2019/5/3113:07
 */
public class Main {
    public static void main(String[] args) {
        DefaultIntegerface a = () -> {
            System.out.println("this is a function interface");
        };
        a.printAge();
        new InterfaceImpl().print();

    }
}
