package concurrency.example_7;

public class TableGame implements Table {


    @Override
    public Player game() {
        return new Player();
    }
}
