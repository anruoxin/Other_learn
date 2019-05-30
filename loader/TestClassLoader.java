package loader;

import java.io.*;

/**
 * @author admin
 * @title: TestClassLoader
 * @projectName ideaDemo
 * @description: TODO
 * @date 2019/5/309:57
 */
public class TestClassLoader extends ClassLoader{

    private static String MY_CLASSPATH = "d:" + File.separator + "cn" + File.separator + "weicelove" + File.separator + "anruoxin" + File.separator + "Test.class";

    @Override
    public Class<?> findClass(String name) throws ClassNotFoundException {
        byte[] bytes = null;
        try {
            bytes = this.loadData();
            System.out.println("文件大小: " + bytes.length);
            return super.defineClass(name, bytes, 0 , bytes.length);
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("加载出错");
        }
        return null;
    }

//    @Override
//    public Class<?> loadClass(String name)  {
//
//    }

    private byte[] loadData() throws IOException {
        InputStream fileInputStream = null;
        ByteArrayOutputStream bos = null;
        byte[] data = null;
        try{
            File file = new File(MY_CLASSPATH);
            fileInputStream = new FileInputStream(file);
            bos = new ByteArrayOutputStream();
            data = new byte[1024];
            int len = 0;
            while((len=fileInputStream.read(data))!=-1){
                bos.write(data,0,len);
            }
            data = bos.toByteArray();

        } catch (Exception e){
            e.printStackTrace();
        } finally {
            if (fileInputStream != null) {
                fileInputStream.close();
            }
            if (bos != null){
                bos.close();
            }
        }
        return data;
    }
}
