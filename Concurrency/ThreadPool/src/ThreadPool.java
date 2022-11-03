import java.util.ArrayList;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class ThreadPool {

    private BlockingQueue taskQueue = null;
    private List<PoolThreadRunnable> runnables = new ArrayList<>();
    private boolean isStopped = false;

    public ThreadPool(int numOfThreads, int maxNumOfTasks) {
        taskQueue = new ArrayBlockingQueue(maxNumOfTasks);

        for (int i=0; i<numOfThreads; i++) {
            PoolThreadRunnable poolThreadRunnable = new PoolThreadRunnable(taskQueue);

            runnables.add(poolThreadRunnable);
        }
    }
}
