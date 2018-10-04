package twentyOne.fifth;

import java.io.IOException;
import java.io.PipedReader;
import java.io.PipedWriter;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * @author james
 * @date 10/3/2018
 */
class Sender implements Runnable {

    private Random random = new Random(47);
    private PipedWriter pipedWrite = new PipedWriter();
    public PipedWriter getPipedWrite() {
        return pipedWrite;
    }

    @Override
    public void run() {
        try {
            while(true) {
                for (char c = 'A'; c <= 'z'; c++) {
                    pipedWrite.write(c);
                    TimeUnit.MILLISECONDS.sleep(random.nextInt(100));
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

class Receiver implements Runnable {

    private PipedReader pipedReader;
    public Receiver(Sender sender) throws IOException {
        pipedReader = new PipedReader(sender.getPipedWrite());
    }

    @Override
    public void run() {
        try {
            while (true) {
                System.out.println("Read: " + (char)pipedReader.read() + ", ");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

public class PipedIO {
    public static void main(String[] args) throws Exception {
        Sender sender = new Sender();
        Receiver receiver = new Receiver(sender);
        ExecutorService exec = Executors.newCachedThreadPool();
        exec.execute(sender);
        exec.execute(receiver);
        TimeUnit.SECONDS.sleep(10);
        exec.shutdownNow();
    }
}
