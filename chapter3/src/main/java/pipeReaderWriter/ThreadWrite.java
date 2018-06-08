package pipeReaderWriter;


import java.io.PipedOutputStream;
import java.io.PipedWriter;

public class ThreadWrite extends Thread {
    private WriteData write;

    @Override
    public void run() {
        write.writeMethod(out);
    }

    private PipedWriter out;

    public ThreadWrite(WriteData write, PipedWriter out) {
        super();
        this.write = write;
        this.out = out;
    }
}
