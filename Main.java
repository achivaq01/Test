import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class Main {
    public static void main(String[] args) throws IOException, InterruptedException {
        ThreadManager manager = new ThreadManager();
        manager.start();


        TimeUnit.SECONDS.sleep(1);
        manager.addQueue("echo hey");
        manager.addQueue("echo hi");
        manager.addQueue("echo bye");
        manager.addQueue("echo lol");
        manager.addQueue("echo kek");

        TimeUnit.SECONDS.sleep(10);
//        manager.stop();


    }
}