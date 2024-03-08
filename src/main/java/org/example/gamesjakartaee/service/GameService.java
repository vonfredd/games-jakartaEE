package org.example.gamesjakartaee.service;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import org.example.gamesjakartaee.dto.GameDTO;
import org.example.gamesjakartaee.entity.Game;
import org.example.gamesjakartaee.repository.GameRepository;

import java.util.List;

@ApplicationScoped
public class GameService {
    GameRepository gameRepository;

    public GameService() {

    }

    @Inject
    public GameService(GameRepository gameRepository) {
        this.gameRepository = gameRepository;
    }

    public List<GameDTO> findAll() {
        return gameRepository.findAll();
    }

    public Long insertGame(GameDTO gameDTO) {
        return gameRepository.insertGame(GameDTO.map(gameDTO));
    }

    public void updateGame(Long id, String name) {
        Game game = gameRepository.findGameById(id);
        game.setName(name);
        gameRepository.updateGame(game);
    }

    public Game findById(Long id) {
        return gameRepository.findGameById(id);
    }
}
