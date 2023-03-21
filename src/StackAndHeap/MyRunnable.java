package StackAndHeap;

public class MyRunnable implements Runnable {

    int count = 0;
    private MyObject myObject = null; // now it is like a field

    public MyRunnable(MyObject myObject) { // it is a field stored in a field, it can be shared between the threads
        this.myObject = myObject;
    }

    @Override
    public void run() {

       // MyObject myObject = new MyObject(); // each method ends up instantiating a new object, each local variable will be created for each object
                                            // both thread stacks will have one local variable of myObject and will point to
                                            // one new object created for each thread stack. These instances will not be shared in case of single or more runnable
                                            // here myObject is in a local Variable
        System.out.println(myObject);

        for (int i = 0; i < 1_000_000; i++) {
            this.count++;
        }

        System.out.println(Thread.currentThread().getName()+" : "+this.count);
    }
}
