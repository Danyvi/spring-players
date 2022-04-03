package xyz.codeandlearn.players.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import xyz.codeandlearn.players.models.Player;

@Repository
public interface PlayerRepository extends JpaRepository<Player, Long> {
}
