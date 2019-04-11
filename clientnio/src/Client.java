import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;

public class Client {

    public static void main(String []args){
        SocketChannel sc = null; //声明连接通道
        InetSocketAddress address = new InetSocketAddress("127.0.0.1",7788);
        ByteBuffer buf = ByteBuffer.allocate(1024); //在jvm中分配内存资源 建立缓冲区
        //ByteBuffer buf = ByteBuffer.allocateDirect(1024);//在jvm外分配资源

        try {
            sc = SocketChannel.open();//打开通道
            sc.connect(address); //进行连接
            while (true){
                //定义一个字符数组，然后使用系统的录入功能
                byte[] bytes = new byte[1024];
                System.in.read(bytes);
                buf.put(bytes);//将数据放到缓冲区中
                buf.flip();//对缓冲区进行复位
                sc.write(buf);//将数据写入通道
                buf.clear();//清空缓冲区

            }

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
