package concurrency.example_7;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class Main {


    public static void main(String[] args) throws ExecutionException, InterruptedException {

        Table table = new TableGame();
        Callable callable = new Game(table);
        FutureTask futureTask = new FutureTask(callable);
        new Thread(futureTask).start();

        System.out.println(futureTask.get());
    }
}
