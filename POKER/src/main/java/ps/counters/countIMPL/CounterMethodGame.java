package ps.counters.countIMPL;

import ps.counters.Counter;

public class CounterMethodGame implements Counter {

    private int count;

    @Override
    public void count() {
        count++;
    }

    @Override
    public int getCount() {
        return count;
    }
}
