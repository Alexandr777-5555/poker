package concurrency.example_5;

public class Player {

    /**
     * количество фишек у игрока
     */
    private int chips;

    private final int id;

    private Player (Player player){
        this.id=player.id;
        this.chips=player.chips;
    }


    public Player(int chips, int id) {
        this.chips = chips;
        this.id = id;
    }

    // SET AND GET

    public int getId() {
        return id;
    }

    public synchronized int getChips() {
        return chips;
    }

    public synchronized void setChips(int chips) {
        this.chips = chips;
    }


    public synchronized void addChips(int addChips){
               this.chips+=addChips;
    }


}
