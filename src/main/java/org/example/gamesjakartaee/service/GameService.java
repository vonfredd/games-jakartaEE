package org.example.gamesjakartaee.service;


import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.ws.rs.NotFoundException;
import org.example.gamesjakartaee.dto.GameDTO;
import org.example.gamesjakartaee.dto.Games;
import org.example.gamesjakartaee.entity.Game;
import org.example.gamesjakartaee.repository.GameRepository;

import java.time.LocalDateTime;

@ApplicationScoped
public class GameService {

    GameRepository gameRepository;

    public GameService() {
    }

    @Inject
    public GameService(GameRepository gameRepository) {
        this.gameRepository = gameRepository;
    }


    public Games all() {
        return new Games(
                gameRepository.all().stream().map(GameDTO::map).toList(),
                LocalDateTime.now());
    }

    public GameDTO one(long id) {
        var game = gameRepository.findById(id);
        if( game == null)
            throw new NotFoundException("Invalid id " + id);
        return GameDTO.map(game);
    }

    public Game add(GameDTO personDto) {
        //Save to database
        var p = gameRepository.add(GameDTO.map(personDto));
        return p;
    }
}
