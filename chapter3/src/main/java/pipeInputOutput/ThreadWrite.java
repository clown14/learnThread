package pipeInputOutput;

import java.io.PipedInputStream;
import java.io.PipedOutputStream;

public class ThreadWrite extends Thread {
    private WriteData write;

    @Override
    public void run() {
        write.writeMethod(out);
    }

    private PipedOutputStream out;

    public ThreadWrite(WriteData write, PipedOutputStream out) {
        super();
        this.write = write;
        this.out = out;
    }
}
