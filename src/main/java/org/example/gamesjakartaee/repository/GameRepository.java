package org.example.gamesjakartaee.repository;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.example.gamesjakartaee.entity.Game;

import java.util.List;
import java.util.UUID;

@ApplicationScoped
public class GameRepository {

    @PersistenceContext(name = "mysql")
    private EntityManager entityManager;

    public List<Game> all(){
        return entityManager.createNamedQuery("GameEntity.findAll", Game.class)
                .getResultList();
    }

    @Transactional
    public Game add(Game game) {
        game.setId(UUID.randomUUID());
        entityManager.persist(game);
        return game;
    }

    public Game findById(long id) {
        return entityManager.find(Game.class, id);
    }

}
