import java.io.*;
import java.net.*;

public class Server {

    static final int PORTA = 12345;

    public static void main(String[] args) throws IOException {
        try (ServerSocket serverSocket = new ServerSocket(PORTA)) {
            System.out.println("Servidor rodando na porta " + PORTA);

            while (true) {
                // Aguarda uma conexão de cliente
                Socket clientSocket = serverSocket.accept();
                System.out.println("Cliente conectado: " + clientSocket.getInetAddress());

                // Cada cliente é tratado em uma thread separada
                new Thread(() -> tratarCliente(clientSocket)).start();
            }
        }
    }

    private static void tratarCliente(Socket socket) {
        try (
            BufferedReader entrada = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter saida = new PrintWriter(socket.getOutputStream(), true)
        ) {
            String linha;
            while ((linha = entrada.readLine()) != null) {
                System.out.println("Recebido: " + linha);
                saida.println("Echo do servidor: " + linha);
            }
        } catch (IOException e) {
            System.out.println("Erro com o cliente: " + e.getMessage());
        } finally {
            try {
                socket.close();
            } catch (IOException ignored) {}
        }
    }
}
