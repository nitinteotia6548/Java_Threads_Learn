public class VirtualThreads {

    public static void main(String[] args) {

        Runnable runnable = () -> {
            for (int i = 0; i < 10; i++) {
                System.out.println("Index: "+i);
            }
        };
        Thread vThread1 = Thread.ofVirtual().start(runnable); // ofVirtual is static method creates virtual thread that is started


        Thread vThreadNotStarted = Thread.ofVirtual().unstarted(runnable); // creates virtual thread that is not started started yet
        vThreadNotStarted.start();

        // Join a Virtual Thread
        try {
            vThreadNotStarted.join(); // blocks the thread (join the platform thread) till this is executed
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
