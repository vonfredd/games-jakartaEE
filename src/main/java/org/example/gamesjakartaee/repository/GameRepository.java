package org.example.gamesjakartaee.repository;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.example.gamesjakartaee.entity.Game;
import org.example.gamesjakartaee.exception.NotFoundException;

import java.util.List;
import java.util.Optional;

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

    public Optional<Game> findById(Long id) {
        Game game = entityManager.find(Game.class, id);
        return Optional.ofNullable(game);
    }

    @Transactional
    public void remove(Long id){
        Optional<Game> optionalGame = findById(id);
        if (optionalGame.isPresent()){
            Game game = optionalGame.get();
            entityManager.remove(game);
        }else
            throw new NotFoundException("No such ID.");
    }
}
