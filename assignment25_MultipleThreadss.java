class NumberThread extends Thread {

    private String threadName;

    NumberThread(String name) {
        threadName = name;
    }

    public void run() {

        for (int i = 1; i <= 10; i++) {

            System.out.println(threadName + " : " + i);

            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                System.out.println(e);
            }
        }
    }
}

public class assignment25_MultipleThreadss {

    public static void main(String[] args) {

        NumberThread t1 = new NumberThread("Thread 1");
        NumberThread t2 = new NumberThread("Thread 2");
        NumberThread t3 = new NumberThread("Thread 3");

        t1.start();
        t2.start();
        t3.start();
    }
}