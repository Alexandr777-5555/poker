package concurrency.example_2;


import concurrency.annotation.ThreadSafe;

@ThreadSafe
public class Player {

   private final int id;
   private final String nickname;
   

    public Player(int id, String nickname) {
        this.id = id;
        this.nickname = nickname;
    }


}
