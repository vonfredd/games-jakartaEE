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
    public Long insertGame(GameDTO gameDTO) {
        Game game = GameDTO.map(gameDTO);
        entityManager.persist(game);
        return game.getId();
    }

    @Transactional
    public Long updateGame(Long id, String name) {
        Game game = findGameById(id);
        game.setName(name);
        return game.getId();
    }

    private Game findGameById(Long id){
        return entityManager.find(Game.class, id);
    }
}
