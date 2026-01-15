import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashSet;
import java.util.Set;

public class ChatServer {
    private static Set<ClientHandler> clientHandler = new HashSet<>();

    public static void main(String[] args) throws IOException {
        final int PORT = 1234;
        try(ServerSocket serverSocket = new ServerSocket(PORT)) {
            System.out.println("Server Started on port " + PORT);

            while(true) {
                Socket socket = serverSocket.accept();
                System.out.println("New Client Connected");

                ClientHandler client = new ClientHandler(socket ,clientHandler);
                clientHandler.add(client);
                new Thread(client).start();
            }
        }


    }


}
