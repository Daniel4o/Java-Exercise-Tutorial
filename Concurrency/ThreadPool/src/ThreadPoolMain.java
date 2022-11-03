public class ThreadPoolMain {

    // Thread pool is used for executing multiple tasks at the same time.
    // The tasks are submitted to the Thread pool with a number of pre-created
    // threads which then the tasks are being executed one by one.
    // By using the Thread pool the program can control how many threads
    // are active at the same time

    // The Thread Pool has an internal task queue- Blocking queue,
    // and in this queue all the tasks to be executed by the Thread pool are inserted
    // Whenever a thread is available for executing a task it will try to take a task from
    // the blocking queue. If there are no tasks in the queue the thread will simply wait until
    // a task is inserted into the queue. If multiple threads are waiting for tasks then only
    // of them will get the task that is inserted

    public static void main(String[] args) throws Exception {
        // 3 Threads and a maximum capacity for storing 10 tasks internally
        ThreadPool threadPool = new ThreadPool(3,10);

        for(int i=10; i<10; i++) {
            int taskNum = i;
            threadPool.execute(() -> {
                String message = Thread.currentThread().getName() + ": Task " + taskNum;
                System.out.println(message);
            });
        }

        threadPool.waitUntilAllTasksFinished();
        threadPool.stop();
    }
}
