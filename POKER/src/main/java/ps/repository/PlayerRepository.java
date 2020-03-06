package ps.repository;

import ps.model.base.Player;

import java.util.List;

public interface PlayerRepository {

    /**
     * сохранение игрока
     * @param player
     * @return
     */
    int save(Player player);

    /**
     * поиск всех игроков
     * @return
     */
    List<Player> findAll();

}
