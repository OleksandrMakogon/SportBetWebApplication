package com.epam.training.service;

import com.epam.training.model.Player;
import com.epam.training.model.Wager;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

@Service("JpaPlayerService")
@Transactional(readOnly = true)
public class JpaPlayerService implements PlayerService {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Player> getAll() {
        return entityManager.createQuery(
                "select p from Player p", Player.class).
                getResultList();
    }

    @Override
    public Player getPlayer(String player_login, String password) {
        TypedQuery<Player> query = entityManager.createQuery(
                "select p from Player p where p.player_login = :player_login and p.password = :password",
                Player.class);
        query.setParameter("player_login", player_login);
        query.setParameter("password", password);
        return query.getResultList().stream().findAny().orElse(null);
    }

    @Transactional
    public void addPlayer(Player player) {
        entityManager.persist(player);
    }

    @Override
    public List<Wager> getAllWagers(){
        return entityManager.createQuery(
                "select p from Wager p", Wager.class).
                getResultList();
    }
}
