import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class LockExample {

    public static void main(String[] args) {
        
        /* Differences in Synchronized block and Locks

        1. Synchronized blocks must be contained within a single method.
         lock.lock() and lock.unlock() can be called from different methods.

         2. lock.lock() and lock.unlock() provides the same visibility and
         happens before guarantees as entering and exiting a synchronized block

         3. Synchronized blocks are always reentrant. Lock could decide not to be.

         4. Synchronized blocks do not guarantee fairness. Locks can
         */
        lockBasics();
    }

    public static void lockBasics() {
        // Declaring a variable of type Lock which is the Interface
        // and then Instantiate a new ReentrantLock class that implements the Lock Interface
        Lock lock = new ReentrantLock(true);
        Runnable runnable = () -> {lockSleepUnlock(lock,1000);};

        Thread thread1 = new Thread(runnable, "Thread 1");
        Thread thread2 = new Thread(runnable, "Thread 2");
        Thread thread3 = new Thread(runnable, "Thread 3");

        thread1.start();
        thread2.start();
        thread3.start();

        lockInterruptibly();
        tryLock();
    }

    public static void lockSleepUnlock(Lock lock, long timeMillis) {
        try {
            lock.lock();
            printThreadMsg(" holds the lock.");
            sleep(timeMillis);
        } finally {
             lock.unlock();
        }
    }

    public static void printThreadMsg(String text) {
        System.out.println(Thread.currentThread().getName() + text);
    }

    private static void sleep(long timeMillis) {
        try {
            Thread.sleep(timeMillis);
        } catch(InterruptedException e) {
            e.printStackTrace();
        }
    }

    // lockInterruptibly method will only lock the lock if the Thread
    // is trying to  lock the lock has not been interrupted
    private static void lockInterruptibly() {
        Lock lock = new ReentrantLock();
        // By uncommenting the Thread is interrupting itself just before
        // calling lockInterruptibly() and it throws an Exception
        Thread.currentThread().interrupt();
        try {
            lock.lockInterruptibly();
            lock.unlock();
        } catch (InterruptedException e) {
            System.out.println("Thread interrupted");
        }
    }

    // The method will attempt to check the lock and if another thread holds the lock
    // rather than blocking until is possible to lock the lock the try lock will return false
    // if it's successful at locking the lock it will return true

    // The method is used when a Thread has other tasks to complete and instead of blocking
    // it can start them if they are also not locked
    private static void tryLock() {
        Lock lock = new ReentrantLock(true);
        try {
            boolean lockSuccessful = lock.tryLock();
            // If the method wants to use fairness the tryLock() method has to take a timeout
        //    boolean lockSuccessful = lock.tryLock(1000, TimeUnit.MILLISECOND);
            System.out.println("Lock successful: " + lockSuccessful);
        } finally {
            lock.unlock();
        }


    }
}