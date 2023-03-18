public class ThreadingByImplementingRunnableInterface {

    public static class myRunnable implements Runnable {

        @Override
        public void run() {
            System.out.println("MyRunnable running");
            System.out.println("MyRunnable finished");
        }

        public static void main(String[] args) {
            Thread thread = new Thread(new myRunnable());
            thread.start();
        }
    }
}
