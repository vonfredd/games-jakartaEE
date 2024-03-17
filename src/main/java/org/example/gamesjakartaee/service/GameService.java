package org.example.gamesjakartaee.service;


import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.ws.rs.NotFoundException;
import jakarta.ws.rs.WebApplicationException;
import jakarta.ws.rs.core.Response;
import org.example.gamesjakartaee.dto.GameDTO;
import org.example.gamesjakartaee.dto.Games;
import org.example.gamesjakartaee.entity.Game;
import org.example.gamesjakartaee.exception.NumberFormatException;
import org.example.gamesjakartaee.repository.GameRepository;

import java.time.LocalDateTime;
import java.util.Optional;
import java.util.function.Consumer;

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

    public GameDTO one(Long id) {
        Optional<Game> game = gameRepository.findById(id);
        if (game.isPresent()) {
            return GameDTO.map(game.get());
        } else
            throw new NotFoundException();
    }

    public void add(GameDTO gameDTO) {
        if (gameDTO == null)
            throw new WebApplicationException(404);
        gameRepository.add(GameDTO.map(gameDTO));
    }

    public Response update(Long id, GameDTO updateData) {

        Optional<Game> optionalGame = gameRepository.findById(id);

        if (optionalGame.isPresent()) {
            Game game = optionalGame.get();
            checkOnNull(game::setTitle, updateData.title());
            checkOnNull(game::setReleaseYear, updateData.releaseYear());
            gameRepository.update(game);
            return Response.ok().build();
        } else
            return Response.status(Response.Status.NOT_FOUND).build();
    }

    private <T> void checkOnNull(Consumer<T> consumer, T value) {
        if (value != null) consumer.accept(value);
    }

    public void remove(String id) {
        try {
            Long gameId = Long.parseLong(id);
            gameRepository.remove(gameId);
        } catch (java.lang.NumberFormatException e) {
            throw new NumberFormatException("Wrong numeric format of ID!");
        }
    }
}
