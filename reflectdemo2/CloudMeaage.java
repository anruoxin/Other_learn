package reflectdemo2;

/**
 * @author admin
 * @title: CloudMeaage
 * @projectName ideaDemo
 * @description: TODO
 * @date 2019/5/2815:24
 */
public class CloudMeaage implements IMessageService{
    @Override
    public void sendMsg() {
        System.out.println("发送云消息");
    }
}
