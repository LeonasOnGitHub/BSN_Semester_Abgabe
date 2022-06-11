package workflow;

import org.junit.Test;

import java.io.File;
import java.io.IOException;

public class FillerWriteTest {
    @Test
    public void goodTest1() throws IOException {
        int num1 = 1;
        int num2 = 2;
        String currentPath = new java.io.File(".").getCanonicalPath();
        Filler f = new Filler(num1 , num2, new File(currentPath + "\\tempAdd.txt"));
        f.save2File();

    }
}
