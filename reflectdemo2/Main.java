package reflectdemo2;

/**
 * @author admin
 * @title: Main
 * @projectName ideaDemo
 * @description: TODO
 * @date 2019/5/2815:22
 */
public class Main {
    public static void main(String[] args) {
        IMessageService iMessageService = (IMessageService)ServiceFactory.getInstance("reflectdemo2.NetMessage", IMessageService.class);
        iMessageService.sendMsg();
        IMessageService iMessageService1 = (IMessageService)ServiceFactory.getInstance("reflectdemo2.CloudMeaage", IMessageService.class);
        iMessageService1.sendMsg();
        ReceiveService receiveService = (ReceiveService)ServiceFactory.getInstance("reflectdemo2.ClientReceive", ReceiveService.class);
        receiveService.receive();
    }
}
