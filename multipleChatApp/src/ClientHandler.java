import java.io.*;
import java.net.Socket;
import java.util.Set;

public class ClientHandler implements Runnable {
    private Socket socket;
    private BufferedReader in;
    private PrintWriter out;
    private Set<ClientHandler> clientHandlers;

    public ClientHandler(Socket socket, Set<ClientHandler> clientHandlers) {
        this.socket = socket;
        this.clientHandlers = clientHandlers;
        try{
            in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            out = new PrintWriter(new OutputStreamWriter(socket.getOutputStream()),true);

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void SendMessage (String message) {
        out.println(message)
        ;
    }

    @Override
    public void run() {
        try{
            String name = in.readLine();
            BroadCast(name + "new join");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }finally{
            try {
                socket.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }

        }

    }
    public void BroadCast(String message) {
        for (ClientHandler clientHandler : clientHandlers) {
            clientHandler.SendMessage(message);
        }
    }
}
