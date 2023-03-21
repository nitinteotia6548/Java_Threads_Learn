package StackAndHeap;

public class SeparateObjects {

    public static void main(String[] args) {

        MyObject myObject = new MyObject(); // refers to same myObject instance on the heap

        int varLocalVariable = 0;   // Local Variables  - byte, short, char, int, long, float, double are in Thread Stack since they are inside the main method
        String myLocalString = "Text"; // objects are inside the heap space - we both have a reference which is stored on the thread stack
                                    // and the string object itself which is stored on the heap

        Runnable runnable1 = new MyRunnable(myObject);
        Runnable runnable2 = new MyRunnable(myObject);

        Thread t1 = new Thread(runnable1, "Thread 1");
        Thread t2 = new Thread(runnable2, "Thread 2");

        t1.start();
        t2.start();
    }
}
