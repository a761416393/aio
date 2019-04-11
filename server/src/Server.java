import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    final static int PROT = 7788;
    public static void main(String []args){
        ServerSocket server = null;
        try {
            server = new ServerSocket(PROT);
            System.out.println("server start ..");
            //增加线程池
            HandlerExecutorPool executorPool = new HandlerExecutorPool(50,100);
            Socket socket = null;
            while (true){
                //进行阻塞
                socket = server.accept();
                //新建一个线程执行客户端的任务
                //new Thread(new ServerHandler(socket)).start();
                executorPool.execute(new ServerHandler(socket));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
