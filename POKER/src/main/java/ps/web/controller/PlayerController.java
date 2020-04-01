package ps.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import ps.model.base.Player;
import ps.service.PlayerService;

import java.util.List;

@Controller
public class PlayerController {

    @Autowired
    @Qualifier("playerService")
    private PlayerService service;


     @GetMapping("/view_winners")
    public String all(ModelMap model) {
        List<Player> list=service.list();
        model.put("players" , list);
        return "view_winners";
    }





}
