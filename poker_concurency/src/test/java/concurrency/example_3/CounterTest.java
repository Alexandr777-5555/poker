package concurrency.example_3;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import static org.junit.Assert.*;

public class CounterTest {

    @Test
    public void getValueAndIncrement() throws InterruptedException {

        ExecutorService service = Executors.newCachedThreadPool();

        Counter counter = new Counter();
        int threadCount = 333;
        List<Future> future = new ArrayList<>();
        for (int i = 0; i < threadCount; i++) {
            future.add(service.submit(() -> {
                        counter.increment();
                    }
            ));
        }
        Thread.sleep(5000);

        assertEquals(333, counter.getValue());
    }


}