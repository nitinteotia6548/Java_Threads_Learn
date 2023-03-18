public class GetAndSetThreadName {

    public static void main(String[] args) {

        Runnable runnable = () -> {
            String threadName = Thread.currentThread().getName();
            System.out.println(threadName + " running");
        };

        Thread thread1 = new Thread(runnable, "The thread 1");
        Thread thread2 = new Thread(runnable);
        thread1.start();
        thread2.start();
    }
}
