package reflectdemo2;

/**
 * @author admin
 * @title: NetMessage
 * @projectName ideaDemo
 * @description: TODO
 * @date 2019/5/2815:24
 */
public class NetMessage implements  IMessageService{
    @Override
    public void sendMsg() {
        System.out.println("发送网络消息");
    }
}
