package xyz.codeandlearn.players;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
public class PlayersController {

    @Autowired
    private PlayerService playerService;

    @GetMapping("/players")
    public List<Player> getAllPlayers() {
        return playerService.getAllPlayers();
    }

    @GetMapping("/players/{id}")
    // annotation @PathVariable tells Spring to map the value of the path variable to the id variable
    public Player getPlayer(@PathVariable int id) {
        return playerService.getPlayer(id);
    }

    // annotation @RequestBody tells Spring to map the JSON object to the Player object
    @PostMapping("/players")
    public void addPlayer(@RequestBody Player player) {
        playerService.addPlayer(player);
    }

    @RequestMapping(value="players/{id}", method=RequestMethod.PUT)
    public void updatePlayer(@PathVariable int id, @RequestBody Player player) {
        playerService.updatePlayer(id, player);
    }

    @RequestMapping(value="players/{id}", method=RequestMethod.DELETE)
    public void deletePlayer(@PathVariable int id) {
        playerService.deletePlayer(id);
    }
}