package pipeInputOutput;

import java.io.IOException;
import java.io.PipedOutputStream;

public class WriteData {
    public void writeMethod(PipedOutputStream out) {
        try {
            System.out.println("write :");
            for (int i = 0; i< 300; i++) {
                String outData = "" + (i + i);
                out.write(outData.getBytes());
                System.out.println(outData);
            }
            System.out.println();
            out.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
