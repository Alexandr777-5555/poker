package ps.web.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import ps.model.base.Player;
import ps.service.PlayerService;

import java.util.Collections;
import java.util.List;

@Controller
@RequestMapping("/view_winner_id")
public class PlayerIdController {

    @Autowired
    @Qualifier("playerService")
    private PlayerService service;

    @RequestMapping(method = RequestMethod.GET)
    public void setup(){

    }



    @RequestMapping(method = RequestMethod.POST)
    public String show(@RequestParam("numberID") int id, Model model) {
        List<Player> list = Collections.emptyList();
        if (id > 0) {
            list = service.queryId(id);
        }
        model.addAttribute("players", list);

        return "view_winner_id";
    }


}
