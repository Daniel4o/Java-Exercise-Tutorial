
// Synchronized block is a block which can be only executed by one Thread at a time.


public class SynchronizedExchanger {

    protected Object object = null;

    // Declaring an instance method synchronized means that only one Thread can execute
    // that method at a time on a given instance of that class.
    // I.e. one Thread can execute either getObject or setObject
    public SynchronizedExchanger(Object object) {
        this.object = object;
    }

    public synchronized Object getObject() {
        return this.object;
    }

    public synchronized void setObject(Object object) {
        this.object = object;
    }

    // Synchronized can also be declared in a block instead in a method
    public Object getObj() {
        // this is Monitor Object which is the object on which these blocks are synchronized
        synchronized (this) {
            return this.object;
        }
    }

    public void setObj(Object object) {
        synchronized (this) {
            this.object = object;
        }
    }
}
