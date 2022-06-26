package workflow;

import java.io.DataOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;

public class Producer implements Runnable{
    private static final int WAIT = 100;
    private final int PORT = 123;
    private int value1;
    private int value2;

    public Producer(int val1, int val2){
        this.value1 = val1;
        this.value2 = val2;

    }

    @Override
    public void run() {
        try {
            Socket socket = new Socket("localhost", PORT);
            
            OutputStream os = socket.getOutputStream();
            DataOutputStream dos = new DataOutputStream(os);
            dos.writeInt(this.value1);
            dos.writeInt(this.value2);
            os.close();
            dos.close();
            
        } catch (IOException e) {
            // if not connected - sleep
            try {
                Thread.sleep(this.WAIT);
            } catch (InterruptedException ex) {
                throw new RuntimeException(ex);
            }
        }
    }

}
