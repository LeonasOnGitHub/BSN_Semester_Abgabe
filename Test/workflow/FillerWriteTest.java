package workflow;

import org.junit.Test;

import java.io.IOException;

public class FillerWriteTest {
    @Test
    public void goodTest1() throws IOException {
        int num1 = 1;
        int num2 = 2;
        Filler f = new Filler(num1 , num2);
        f.save2File();

    }
}
