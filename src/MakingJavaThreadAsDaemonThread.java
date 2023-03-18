public class MakingJavaThreadAsDaemonThread {

    public static void main(String[] args) {

        Runnable runnable = () -> {
            while (true) {
                sleep(1000);
                System.out.println("println");
            }
        };
        Thread t1 = new Thread(runnable);
        t1.setDaemon(true);
        t1.start();
        sleep(3000); // main thread is in sleep
    }

    public static void sleep(long millis) {
        try{
            Thread.sleep(millis);
        } catch (InterruptedException e){
            e.printStackTrace();
        }
    }
}
