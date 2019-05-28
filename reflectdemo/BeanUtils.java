package reflectdemo;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

/**
 * @author admin
 * @title: BeanUtils
 * @projectName ideaDemo
 * @description: TODO
 * @date 2019/5/2810:00
 */
public class BeanUtils {

    public static Object getVaule(String type, String value){
        if ("long".equals(type) || "java.lang.Long".equals(type)){
            return Long.parseLong(value);
        } else if ("int".equals(type) || "java.lang.Integer".equals(type)){
            return  Integer.parseInt(value);
        } else if("java.util.Date".equals(type)){
            try {
                SimpleDateFormat formatter = null;
                if (value.matches("\\d{4}-\\d{2}-\\d{2} \\d{2}:\\d{2}:\\d{2}")){
                    formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                        return formatter.parse(value);
                } else if(value.matches("\\d{4}-\\d{2}-\\d{2}")){
                    formatter = new SimpleDateFormat("yyyy-MM-dd");
                    return formatter.parse(value);
                } else {
                    return  new Date();
                }
            } catch (ParseException e) {
                e.printStackTrace();
                return  new Date();
            }
        } else {
            return value;
        }
    }

    public static void updateInfo(Object object, String content){
        String[] split = content.split("\\|");
        for (int i = 0; i < split.length; i ++) {
            try {
                System.out.println("处理内容：" + split[i]);
                String[] text = split[i].split(":");
                String key = text[0];
                String value = text[1];
                if (key != null){
                    String[] subKey = key.split("\\.");
                    if (subKey.length == 1){
                        Field field = null;
                        Field[] declaredFields = object.getClass().getDeclaredFields();
                        System.out.println(Arrays.asList(declaredFields).toString());
                        field = object.getClass().getDeclaredField(subKey[0]);
                        Method method = object.getClass().getDeclaredMethod("set" + StringUtils.toUpperFirst(subKey[0]), field.getType());
                        method.invoke(object, getVaule(field.getType().getName(),value));
                    } else {
                        Object currentObject = object;
                        for (int j = 0; j < subKey.length - 1; j ++) {
                            Field nowField = currentObject.getClass().getDeclaredField(subKey[j]);
                            Method getMethod = currentObject.getClass().getDeclaredMethod("get" + StringUtils.toUpperFirst(subKey[j]));
                            Method setMethod = currentObject.getClass().getDeclaredMethod("set" + StringUtils.toUpperFirst(subKey[j]), nowField.getType());
                            Object invoke = getMethod.invoke(currentObject);
                            if (invoke == null ){
                                //当前对象未实例化,先实例化对象
                                Class<?> type = nowField.getType();
                                // 获取实例化对象的类型
                                String name = type.getName();
                                Class<?> pClass = Class.forName(name);
                                Object o = pClass.newInstance();
                                setMethod.invoke(currentObject, o);
                                currentObject = o;
                            } else {
                                currentObject = invoke;
                            }
                        }
                        Field nowField = currentObject.getClass().getDeclaredField(subKey[subKey.length - 1]);
                        Method setMethod = currentObject.getClass().getDeclaredMethod("set" + StringUtils.toUpperFirst(subKey[subKey.length - 1]), nowField.getType());
                        setMethod.invoke(currentObject, getVaule(nowField.getType().getName(),value));
                    }
                }

            } catch (Exception e) {
                e.printStackTrace();
            }
        }

    }
}
