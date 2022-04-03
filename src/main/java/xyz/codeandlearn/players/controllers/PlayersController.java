package xyz.codeandlearn.players.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import xyz.codeandlearn.players.models.Player;
import xyz.codeandlearn.players.services.PlayerServiceDB;
import xyz.codeandlearn.players.services.PlayerServiceMock;

import java.util.List;


@RestController
public class PlayersController {

    @Autowired
    private PlayerServiceDB playerService;
//    private PlayerServiceMock playerService;

    @GetMapping("/players")
    public List<Player> getAllPlayers() {
        return playerService.getAllPlayers();
    }

    @GetMapping("/players/{id}")
    // annotation @PathVariable tells Spring to map the value of the path variable to the id variable
    public Player getPlayer(@PathVariable Long id) {
        return playerService.getPlayer(id);
    }

    // annotation @RequestBody tells Spring to map the JSON object to the Player object
    @PostMapping("/players")
    public void addPlayer(@RequestBody Player player) {
        playerService.addPlayer(player);
    }

    @RequestMapping(value="players/{id}", method=RequestMethod.PUT)
    public void updatePlayer(@PathVariable Long id, @RequestBody Player player) {
        playerService.updatePlayer(id, player);
    }

    @RequestMapping(value="players/{id}", method=RequestMethod.DELETE)
    public void deletePlayer(@PathVariable Long id) {
        playerService.deletePlayer(id);
    }
}