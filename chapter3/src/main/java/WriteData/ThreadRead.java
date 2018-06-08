package WriteData;


import java.io.PipedInputStream;

public class ThreadRead extends Thread {
    private ReadData read;
    private PipedInputStream input;

    @Override
    public void run() {
        read.readMethod(input);
    }

    public ThreadRead(ReadData read, PipedInputStream input) {
        super();
        this.read = read;
        this.input = input;
    }
}
