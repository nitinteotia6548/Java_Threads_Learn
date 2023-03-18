public class JoinAThreadThreadWaitForAnotherToTerminate {

    public static void main(String[] args) {

        Runnable runnable = () -> {
            for (int i = 0; i < 5; i++) {
                sleep(1000);
                System.out.println("Running");
            }
        };
        Thread t1 = new Thread(runnable);
        t1.setDaemon(true); // since it is a daemon thread, the jvm terminates without running it
        t1.start();
        // main thread would terminate before running t1, so
        try {
            t1.join(); // it makes main thread to wait for the other other thread by thread.join() on the other thread
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void sleep(long millis) {
        try{
            Thread.sleep(millis);
        } catch (InterruptedException e){
            e.printStackTrace();
        }
    }
}
