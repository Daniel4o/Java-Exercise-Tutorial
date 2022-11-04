
// static synchronized method uses the class object of the method that belongs to as Monitor Object
// i.e. instead of using the Instance method is uses the class object that is because
// the static methods do not belong to any instance they belong to the class

public class StaticSynchronizedExchanger {

    private static Object object = null;

    public static synchronized Object getObject() {
        return object;
    }

    public static synchronized void setObject(Object o) {
        object = o;
    }

    public static Object getObj() {
        synchronized (StaticSynchronizedExchanger.class) {
            return object;
        }
    }

    public static void setObj(Object o) {
        synchronized (StaticSynchronizedExchanger.class) {
            object = o;
        }
    }
}
