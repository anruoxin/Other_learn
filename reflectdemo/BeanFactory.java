package reflectdemo;

/**
 * @author admin
 * @title: CreateBeanFactory
 * @projectName ideaDemo
 * @description: TODO
 * @date 2019/5/2810:00
 */
public class BeanFactory {
    public static <T> T createBean(Class<T> clazz, String content){
        T t = null;
        try {
            t = clazz.newInstance();
        } catch (Exception e) {
            e.printStackTrace();
        }
        BeanUtils.updateInfo(t, content);
        return t;
    }
}
