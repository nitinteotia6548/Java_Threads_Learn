public class CustomStoppingThreads {

    public static class StoppableRunnable implements Runnable {

        private boolean stopRequested = false;

        public synchronized void requestStop() { // synchronized so that only one method can call requestStop at the same time
            this.stopRequested = true;
        }

        public synchronized boolean isStopRequested() {
            return this.stopRequested;
        }

        private void sleep(long millis) {
            try {
                Thread.sleep(millis);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        @Override
        public void run() {
            System.out.println("Stoppable Runnable Running");
            while(!isStopRequested()) {
                sleep(1000);
                System.out.println("...");// till the isStopRequested is not called this is returned
            }
            System.out.println("Stoppable Runnable Stopped"); //when value is false the flow get here
        }
    }

    public static void main(String[] args) {
        StoppableRunnable stoppableRunnable = new StoppableRunnable();
        Thread thread = new Thread(stoppableRunnable, "The thread");
        thread.start();

        try {
            Thread.sleep(5000);
        } catch ( InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("requested stop");
        stoppableRunnable.requestStop();
        System.out.println("stop requested");
    }
}
