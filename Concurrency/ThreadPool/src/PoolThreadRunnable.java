import java.util.concurrent.BlockingQueue;

public class PoolThreadRunnable implements Runnable {

    private Thread thread = null;
    private BlockingQueue taskQueue = null;
    private boolean isStopped = false;

    public PoolThreadRunnable(BlockingQueue queue) {
        taskQueue = queue;
    }

    public void run() {
        // this.thread stores a reference to the thread that
        // is executing this runnable
        this.thread = Thread.currentThread();
        while(!isStopped()) {
            try {
                // Takes one Runnable out of the task queue
                Runnable runnable = (Runnable) taskQueue.take();
                // Loops back to the method and repeats
                runnable.run();
            } catch(Exception e) {
                // log or otherwise report exception,
                // but keep pool thread alive.
            }
        }
    }

    public synchronized void doStop() {
        isStopped = true;
        // break pool thread out of dequeue() call.
        this.thread.interrupt();
    }

    public synchronized boolean isStopped() {
        return isStopped;
    }
}
