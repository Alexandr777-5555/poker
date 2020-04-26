package concurrency.example_4;

import java.util.List;

public class MyThread extends Thread {

    private Table table;

    public MyThread(Table table) {
        this.table = table;
    }

    @Override
    public void run() {
      table.startGame();
    }




}
