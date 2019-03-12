package com.epam.training.repository;

import com.epam.training.model.Player;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PlayerRepository extends JpaRepository<Player, Long> {
    Player findByPlayer_loginAndPassword(String login, String password);
}
