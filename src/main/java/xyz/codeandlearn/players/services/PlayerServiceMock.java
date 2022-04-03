package xyz.codeandlearn.players.services;

import xyz.codeandlearn.players.services.PlayerService;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import xyz.codeandlearn.players.models.Player;

import org.springframework.stereotype.Service;

@Service
public class PlayerServiceMock implements PlayerService {

    private List<Player> players = new ArrayList<>(Arrays.asList(
            new Player(1L, "Francesco", "Totti", "Roma", "midfielder"),
            new Player(2L, "Gonzalo", "Higuain", "Juventus", "forward"),
            new Player(3L, "Mauro", "Icardi", "Inter", "forward")
    ));

    public List<Player> getAllPlayers() {
        return players;
    }

    public Player getPlayer(Long id) {

        return players.stream()
                .filter(p -> p.getId() == id)
                .findFirst()
                .get();
    }

    public void addPlayer(Player player) {
        players.add(player);
    }

    public void updatePlayer(Long id, Player player) {
        for (int i = 0; i < players.size(); i++) {
            Player p = players.get(i);
            if (p.getId() == id) {
                players.set(i, player);
            }
        }

    }

    public void deletePlayer(Long id) {
        players.removeIf(p -> p.getId() == id);

    }

}