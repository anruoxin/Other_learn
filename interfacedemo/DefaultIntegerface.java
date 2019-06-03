package interfacedemo;

/**
 * @author admin
 * @title: DefaultIntegerface
 * @projectName ideaDemo
 * @description: TODO
 * @date 2019/5/3113:07
 */
@FunctionalInterface
public interface DefaultIntegerface {

    void printAge();
    default void print(){
        System.out.println("this is defalut interface");
    }

    static void print(String name){
        System.out.println("content: " + name);
    }
}
