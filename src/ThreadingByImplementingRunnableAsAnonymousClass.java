public class ThreadingByImplementingRunnableAsAnonymousClass {

        public static void main(String[] args) {

            Runnable runnable = new Runnable() {
                @Override
                public void run() {
                    System.out.println("Anonymous Runnable running");
                    System.out.println("Anonymous Runnable finished");
                }
            };

            Thread thread = new Thread(runnable);
            thread.start();
        }
    }
