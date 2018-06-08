package pipeReaderWriter;


import java.io.PipedInputStream;
import java.io.PipedReader;

public class ThreadRead extends Thread {
    private ReadData read;
    private PipedReader input;

    @Override
    public void run() {
        read.readMethod(input);
    }

    public ThreadRead(ReadData read, PipedReader input) {
        super();
        this.read = read;
        this.input = input;
    }
}
