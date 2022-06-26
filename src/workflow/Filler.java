package workflow;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Filler implements Runnable {

    private ServerSocket srvSocket = null;
    private final int PORT = 123;
    private File file;
    private int value1;
    private int value2;

    public Filler(File file) {this.file = file;}

    void save2File() throws IOException {

        OutputStream os = new FileOutputStream(file,true);
        DataOutputStream dos = new DataOutputStream(os);
        dos.writeInt(this.value1);
        dos.writeBytes(" ");
        dos.writeInt(this.value2);
        dos.writeBytes("\n");

    }

    @Override
    public void run() {
        ServerSocket serverSocket = null;
        try {
            serverSocket = new ServerSocket(PORT);
            Socket s = serverSocket.accept();

            InputStream is = s.getInputStream();
            DataInputStream dis = new DataInputStream(is);
            this.value1 = dis.readInt();
            this.value2 = dis.readInt();

            save2File();

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
