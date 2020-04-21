package concurrency.example_1;


import java.util.ArrayList;
import java.util.List;

public class Players {

    private List<Player> list;

    public Players() {
        list=new ArrayList<>();
    }

    public void add(Player player){
        if (!list.contains(player)){
            list.add(player);
        }
    }


    public List<Player> getList() {
        return list;
    }


}
