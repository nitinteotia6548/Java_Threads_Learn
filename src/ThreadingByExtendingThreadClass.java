public class ThreadingByExtendingThreadClass{

    public static class myThread extends Thread {

        public void run() {
            System.out.println("MyThread running");
            System.out.println("MyThread finished");
        }
    }

    public static void main(String[] args) {

        myThread t1 =  new myThread();
        t1.start();
    }
}
