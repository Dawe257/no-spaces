import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(23444);

        while (true) {
            try (Socket socket = serverSocket.accept();
                 BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                 PrintWriter out = new PrintWriter(new OutputStreamWriter(socket.getOutputStream()), true)) {

                out.println("Привет, введи строку");

                String line;
                while (true) {
                    line = in.readLine();
                    if ("end".equals(line)) {
                        out.println("До скорого");
                        break;
                    }
                    line = line.replaceAll("\\s+", "");
                    out.println("Результат: " + line);
                }

            } catch (IOException ex) {
                ex.printStackTrace(System.out);
            }
        }
    }
}
