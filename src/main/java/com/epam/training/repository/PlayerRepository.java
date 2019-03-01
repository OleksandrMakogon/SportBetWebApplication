package com.epam.training.repository;

import com.epam.training.model.Player;
import org.springframework.data.jpa.repository.JpaRepository;

//@Repository
public interface PlayerRepository extends JpaRepository<Player, Long> {

}
