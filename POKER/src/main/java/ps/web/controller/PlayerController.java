package ps.web.controller;

import com.sun.org.apache.xpath.internal.operations.Mod;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import ps.model.Table;
import ps.model.base.Player;
import ps.model.base.Players;
import ps.service.PlayerService;

import java.util.List;

@Controller
public class PlayerController {

    @Autowired
    @Qualifier("playerService")
    private PlayerService service;


     @GetMapping("/view_winner")
    public String all(ModelMap model) {
        List<Player> list=service.list();
        model.put("players" , list);
        return "view_winner";
    }



}
