package reflectdemo2;

/**
 * @author admin
 * @title: ClientReceive
 * @projectName ideaDemo
 * @description: TODO
 * @date 2019/5/2815:29
 */
public class ClientReceive implements ReceiveService{
    @Override
    public void receive() {
        System.out.println("收到消息");
    }
}
