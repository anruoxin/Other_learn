package reflectdemo;

/**
 * @author admin
 * @title: StringUtils
 * @projectName ideaDemo
 * @description: TODO
 * @date 2019/5/289:55
 */
public class StringUtils {
    public static String toUpperFirst(String str){
        if (str == null || "".equals(str)){
            return null;
        }
        if (str.length() == 1){
            return str.toUpperCase();
        } else {
            return str.substring(0, 1).toUpperCase() + str.substring(1);
        }
    }
}
