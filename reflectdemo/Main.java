package reflectdemo;

/**
 * @author admin
 * @title: Main
 * @projectName ideaDemo
 * @description: TODO
 * @date 2019/5/289:50
 */
public class Main {
    public static void main(String[] args) {
        String content = "name:anruoxin|age:19|dept.name:Information Security|dept.addtime:2019-10-10" +
                "|dept.company.name:XXX|dept.company.id:1001|dept.company.address:浙江金华|dept.company.sum:1000";
        Person person = BeanFactory.createBean(Person.class, content);
        System.out.println(person);

    }
}
