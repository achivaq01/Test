import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.TimeUnit;

class ThreadManager {
    private List<JavaCommand> commandQueue;
    private Thread currentThread;
    private Boolean alive;

    public ThreadManager() {
        super();

        commandQueue = new CopyOnWriteArrayList<>();
        currentThread = new Thread(this::executeCommands);
        alive = true;
    }

    public void start() {
        currentThread.start();
    }

    public void addQueue(String command) {
        commandQueue.add(JavaCommand.getInstance(command));

    }

    private void executeCommands() {
        while (alive) {
            executeCommand();
        }
    }

    public void stop() {
        alive = false;
    }

    private void executeCommand() {

        if(commandQueue.isEmpty()) {
            return;
        }


        if (currentThread != null) {
            currentThread.interrupt();
        }

        currentThread = new Thread(commandQueue.get(0));
        commandQueue.remove(0);
        currentThread.start();

        try {
            TimeUnit.SECONDS.sleep(1);

        } catch (InterruptedException e) {
            currentThread.interrupt();

        }

    }

}
