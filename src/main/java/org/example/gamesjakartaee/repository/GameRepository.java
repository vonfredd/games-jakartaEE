package org.example.gamesjakartaee.repository;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.example.gamesjakartaee.entity.Game;

import java.util.List;
import java.util.Optional;
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
    public void update(Game game){
        entityManager.merge(game);
    }

    @Transactional
    public Game add(Game game) {
        entityManager.persist(game);
        return game;
    }

    public Optional<Game> findById(UUID id) {
        Game game = entityManager.find(Game.class, id);
        return Optional.ofNullable(game);
    }

}
