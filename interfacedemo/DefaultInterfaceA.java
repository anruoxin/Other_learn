package interfacedemo;

/**
 * @author admin
 * @title: DefaultInterfaceA
 * @projectName ideaDemo
 * @description: TODO
 * @date 2019/5/3113:20
 */
public interface DefaultInterfaceA {
    void printAge();
    default void print(){
        System.out.println("this is defalut interfaceA");
    }

    static void print(String name){
        System.out.println("content: " + name);
    }
}
