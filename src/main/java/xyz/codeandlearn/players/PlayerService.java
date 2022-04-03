package xyz.codeandlearn.players;

import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;

@Service
public class PlayerService {

    private List<Player> players = new ArrayList<>(Arrays.asList(
            new Player(1, "Francesco", "Totti", "Roma", "midfielder"),
            new Player(2, "Gonzalo", "Higuain", "Juventus", "forward"),
            new Player(3, "Lionel", "Messi", "Barcelona", "forward"),
            new Player(4, "Cristiano", "Ronaldo", "Real Madrid", "forward"),
            new Player(5, "Neymar", "Junior", "Paris Saint Germain", "forward"),
            new Player(6, "Andres", "Iniesta", "Barcelona", "midfielder"),
            new Player(7, "Gareth", "Bale", "Real Madrid", "forward"),
            new Player(8, "Paul", "Pogba", "Manchester United", "midfielder"),
            new Player(9, "Sergio", "Ramos", "Real Madrid", "midfielder"),
            new Player(10, "Luka", "Modric", "Real Madrid", "forward")
    ));

    public List<Player> getAllPlayers() {
        return players;
    }

    public Player getPlayer(int id) {
        return players.stream()
                .filter(player -> player.getId() == id)
                .findFirst()
                .get();
    }

    public void addPlayer(Player player) {
        players.add(player);
    }

    public void updatePlayer(int id, Player player) {
        for (int i = 0; i < players.size(); i++) {
            Player p = players.get(i);
            if (p.getId() == id) {
                players.set(i, player);
            }
        }
    }

    public void deletePlayer(int id) {
        players.removeIf(player -> player.getId() == id);
    }

}
