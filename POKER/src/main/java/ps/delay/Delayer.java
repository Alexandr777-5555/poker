package ps.delay;

import java.util.Random;

public abstract class Delayer {

    private static final Random rnd = new Random();

    private Delayer() {}

    public static void delay(long delay) {
        try {
            Thread.sleep(delay);
        } catch (InterruptedException e) {
        }
    }

    public static void randomDelay() {
        int delay = rnd.nextInt(100000);
        delay(delay);
    }
}
