package ps.service;

import ps.model.base.Player;

import java.util.List;

public interface PlayerService {



    void save(Player  player);

    public List<Player> list();

}
