package workflow;

import java.io.File;
import java.io.IOException;

public class Addition {
    public static void main(String[] args) {

        //make a Filler Server and wait for producer
        String currentPath = null;
        try {
            currentPath = new File(".").getCanonicalPath();
            Filler f = new Filler(new File(currentPath + "\\tempAdd.txt"));
            Thread ft = new Thread(f);
            ft.start();
        } catch (IOException e) {
            e.printStackTrace();
        }

        //make Producer Client and write to filler
        Thread pt  = new Thread(new Producer(69, 96));
        pt.start();
        Thread pt2  = new Thread(new Producer(42, 42));
        pt2.start();
        Thread pt3  = new Thread(new Producer(420, 187));
        pt3.start();
        Thread pt4  = new Thread(new Producer(-1337, 10));
        pt4.start();

        //read out file
        try {
            Prozessor pro = new Prozessor(new File(currentPath + "\\tempAdd.txt"));
            pro.restoreFromFile();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
