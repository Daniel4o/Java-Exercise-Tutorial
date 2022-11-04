public class CounterSynchronized {

    private long count = 0;

    // synchronized: execute only one Thread at a time
    public synchronized  void inc() {
       this.count++;
    }

    public synchronized long getCount() {
        return this.count;
    }

}
