package org.example.gamesjakartaee.repository;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.example.gamesjakartaee.dto.GameDTO;
import org.example.gamesjakartaee.entity.Game;

import java.util.List;
import java.util.UUID;

@ApplicationScoped
public class GameRepository {

    @PersistenceContext(name = "mysql")
    private EntityManager entityManager;

    public List<GameDTO> findAll(){
        return entityManager.createNamedQuery("GameEntity.findAll", GameDTO.class)
                .getResultList();
    }

    @Transactional
    public UUID insertGame(GameDTO gameDTO) {
        Game game = GameDTO.map(gameDTO);
        entityManager.persist(game);
        return game.getId();
    }

}
