package reflectdemo2;

/**
 * @author admin
 * @title: ServiceFactory
 * @projectName ideaDemo
 * @description: TODO
 * @date 2019/5/2815:38
 */
public class ServiceFactory {
    private ServiceFactory() {
    }

    public static Object getInstance(String className, Class<?> serviceClass){
        try {
            Class<?> serviceImplClass = Class.forName(className);
            Object newInstance = serviceImplClass.newInstance();
            if (!serviceClass.isInstance(newInstance)){
                System.out.println("类型与对象不兼容");
                throw new IllegalArgumentException();
            }
            return newInstance;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
