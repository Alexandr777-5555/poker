package ps.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ps.model.base.Player;
import ps.repository.PlayerRepository;

import java.util.ArrayList;
import java.util.List;

@Service("playerService")
public class PlayerServiceIMPL implements PlayerService {

    @Autowired
    private PlayerRepository repository;



    @Override
    @Transactional
    public void save(Player player) {
        repository.save(player);
    }

    @Override
    @Transactional
    public List<Player> list(){
        List<Player> all = repository.findAll();
        return all;
    }

    @Override
    @Transactional
    public List<Player> queryId(int id) {
          List<Player> result=new ArrayList<>();
          result=repository.listForId(id);
        return result;
    }


}
