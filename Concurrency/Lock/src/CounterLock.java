import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

// The Lock is locked in a try finally block. The reason is in case the operation is executed
// (after the Lock is locked and before the Lock is unlocked) and it throws an Exception then
// the unlock() statement  will still get executed because it is listed in a finally block

public class CounterLock {

    private long count = 0;

    //ReentrantLock is a lock which a thread that already has locked the lock can lock as many
    // times it needs. Once the Thread is done it needs to unlock the ReentrantLock instance as
    // many times it was locked. When lock is unlocked the same amount of times it has been locked
    // then the next Thread will be allowed to lock the lock.

    // If the lock was not Reentrant it could not be locked more than once by the same Thread or by
    // any Thread at all. If it locks more than one time the Thread will be BLOCKED. All other Threads
    // that try to lock the same lock will also be blocked (Re-entrance lockout).

    // STARVATION: A situation where a lock does not guarantee fairness among the threats waiting to lock it
    // To avoid starvation a boolean true needs to be passed in the ReentrantLock constructor which
    // guarantees fairness or not. This will guarantee in which order the Threads arrive at the lock method
    // HOWEVER it's not guaranteed what happens with the order from the time Thread is started and until it
    // unlocks the lock
    private Lock lock = new ReentrantLock(true);

    public void inc() {
        try {
            lock.lock();
            this.count++;
        } finally {
            lock.unlock();
        }
    }

    public long getCount() {
       try {
           lock.lock();
           return this.count;
       } finally {
           lock.unlock();
       }
    }
}
