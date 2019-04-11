import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerHandler implements Runnable {
    private Socket socket;

    public ServerHandler(Socket socket){
        this.socket=socket;
    }
    @Override
    public void run() {
        BufferedReader in = null;
        PrintWriter out = null;
        try {
            in = new BufferedReader(new InputStreamReader(this.socket.getInputStream()));
            out = new PrintWriter(this.socket.getOutputStream(),true);
            String body = null;
            while (true){
                body = in.readLine();
                if(body == null) break;
                System.out.println("Server:"+body);
                out.println("服务器端回送响应的数据。");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
