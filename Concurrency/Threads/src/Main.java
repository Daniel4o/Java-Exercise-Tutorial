import java.nio.file.Path;

public class Main {

    public static void main(String[] args) {
        System.out.println(ThreadColor.ANSI_PURPLE + "Hello from the main thread.");

        Thread anotherThread = new AnotherThread();
        anotherThread.setName("===Another Thread===");
        // When program calls the start() method a new Thread is created and code inside run()
        // method is executed in newer Thread. If the program calls run() method directly no new
        // Thread is created and code inside run() will execute on current Thread
        anotherThread.start();

        // Anonymous class - When used the thread has to start immediately and it's only run once
        new Thread() {
            public void run() {
                System.out.println(ThreadColor.ANSI_GREEN + "Hello from the anonymous class thread.");
            }
        }.start();

        Thread myRunnableThread = new Thread(new MyRunnable() {
            @Override
            public void run() {
                System.out.println(ThreadColor.ANSI_RED + "Hello from the anonymous class's implementation of run()");
            }
        });

        myRunnableThread.start();
        System.out.println(ThreadColor.ANSI_PURPLE + "Hello again from the main thread.");
        try {
            // Waiting for another Thread to finish before continuing
            anotherThread.join();
            System.out.println(ThreadColor.ANSI_RED + "AnotherThread terminated, or timed out so I'm running again");
        } catch(InterruptedException e) {
            System.out.println(ThreadColor.ANSI_RED + "I couldn't wait after all. I was interrupted");
        }
    }
}
