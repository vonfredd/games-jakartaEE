package org.example.gamesjakartaee.repository;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.example.gamesjakartaee.dto.GameDTO;
import org.example.gamesjakartaee.entity.Game;

import java.util.List;

@ApplicationScoped
public class GameRepository {

    @PersistenceContext(name = "mysql")
    private EntityManager entityManager;

    public List<GameDTO> findAll(){
        return entityManager.createNamedQuery("GameEntity.findAll", GameDTO.class)
                .getResultList();
    }

    @Transactional
    public Long insertGame(Game game) {
        entityManager.persist(game);
        return game.getId();
    }

    @Transactional
    public void updateGame(Game game) {
        entityManager.merge(game);
    }

    public Game findGameById(Long id){
        return entityManager.find(Game.class, id);
    }
}
