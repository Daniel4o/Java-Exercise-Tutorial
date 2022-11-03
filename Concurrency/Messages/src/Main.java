import java.util.Random;

public class Main {

    public static void main(String[] args) {
        Message message = new Message();
        (new Thread(new Writer(message))).start();
        (new Thread(new Reader(message))).start();
    }
}

class Message {
    private String message;
    private boolean empty = true;

    // Method used by reader
    // Reader reads the message when it is not empty otherwise
    // it will wait for the Writer to write the message
    public synchronized String read() {
        while(empty) {
            try {
                /*
                 Reader thread waits until Writer invokes the notify()
                 method or the notifyAll() method for 'message' object.
                 Reader thread releases ownership of lock and waits
                 until Writer thread notifies Reader thread waiting on
                 this object's lock to wake up either through a call to
                 the notify method or the notifyAll method.
                 */
                wait();
            } catch(InterruptedException e) {

            }
        }
        empty = true; // Reader reads the message and marks empty as true.
        notifyAll();
        /*
        Wakes up all threads that are waiting on 'message' object's monitor(lock).
        This thread(Reader) releases the lock for 'message' object.
        */
        return message;
    }

    // Method use by writer
    // Writer writes the message when it is empty else it waits for
    // Reader to read the message and marks the message empty
    public synchronized void write(String message) {
        while(!empty) {
            try{
                // Here wait() does the same for writer
                wait();
            } catch(InterruptedException e) {

            }
        }
        empty = false;
        this.message = message;
        notifyAll();
    }
}

class Writer implements Runnable {
    private Message message;

    public Writer(Message message) {
        this.message = message;
    }

    public void run() {
        String messages[] = {
                "Humpty Dumpty sat on a wall",
                "Humpty Dumpty had a great fall",
                "All the king's horses and all the king's men",
                "Couldn't put Humpty together again"
        };

        Random random = new Random();

        for(int i=0; i< messages.length; i++) {
            message.write(messages[i]);
            try{
                Thread.sleep(random.nextInt(2000));
            } catch(InterruptedException e) {

            }
        }
        message.write("Finished");
    }
}

class Reader implements Runnable {
    private Message message;


    public Reader(Message message) {
        this.message = message;
    }

    public void run() {
        Random random = new Random();
        for(String latestMessage = message.read(); !latestMessage.equals("Finished");
            latestMessage = message.read()) {
            System.out.println(latestMessage);
            try {
                Thread.sleep(random.nextInt(2000));
            } catch (InterruptedException e) {

            }
        }
    }
}

