package StackAndHeap;

public class SharedObjects {

    public static void main(String[] args) {

        //now i variable is created for each thread stack as it is a local variable
        // but since they are accessing the same runnable for both the threads. the count field will be the same
        // as we have only one runnable object on the heap

        MyObject myObject = new MyObject();

        Runnable runnable = new MyRunnable(myObject);

        Thread t1 = new Thread(runnable, "Thread 1");
        Thread t2 = new Thread(runnable, "Thread 2");

        t1.start();
        t2.start();
    }
}
