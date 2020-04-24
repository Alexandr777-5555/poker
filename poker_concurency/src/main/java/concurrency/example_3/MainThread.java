package concurrency.example_3;

public class MainThread  extends Thread{

   private Counter counter;

    public MainThread(Counter counter) {
        this.counter = counter;
    }


    @Override
    public void run() {
        System.out.println(getName());
        counter.increment();
    }
}
