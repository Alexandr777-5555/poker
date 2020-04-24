package concurrency.example_3;

public class Main {

    public static void main(String[] args) throws InterruptedException {

        Counter counter =new Counter();

        int threadCount=100000;

        for (int i = 0; i < threadCount; i++) {
            new MainThread(counter).start();
        }

        Thread.sleep(5000);

        System.out.println(counter.getValue());

    }
}
