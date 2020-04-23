package poker_game.model.players;


import poker_game.model.thinks.Think;

public abstract class Player {

    /**
     * id игрока
     */
    private   int id;

    /**
     * количество фишек у игрока
     */
    private  int chips;

    /**
     * рука (2 карманные карты) у игрока
     */
    private String hand;

    /**
     * сила руки
     */
    private int strongHand;


    /**
     * мозг игрока , принимает решения в зависимости
     * от условий  ( по какой  схеме играет игрок )
     */
    private  Think think;

    public Player() {
    }




    public Player(int id, int chips, Think think) {
        this.id = id;
        this.chips = chips;
        this.think = think;
    }










    //GETTER and SETTER

    public int getId() {
        return id;
    }

    public int getChips() {
        return chips;
    }

    public void setChips(int chips) {
        this.chips = chips;
    }

    public String getHand() {
        return hand;
    }

    public void setHand(String hand) {
        this.hand = hand;
    }

    public int getStrongHand() {
        return strongHand;
    }

    public void setStrongHand(int strongHand) {
        this.strongHand = strongHand;
    }

    public Think getThink() {
        return think;
    }

    public void setThink(Think think) {
        this.think = think;
    }


    @Override
    public String toString() {
        return
                 "id=" + id + " " +
                " chips=" + chips + " " +
                " think=" + think ;
    }


}
