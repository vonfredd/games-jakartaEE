package org.example.gamesjakartaee.dto;

import org.example.gamesjakartaee.entity.Game;

public record GameDTO(String name, int releaseDate) {
    public static GameDTO map (Game game){
        return new GameDTO(game.getName(), game.getReleaseDate());
    }

    public static Game map (GameDTO gameDTO){
        var game = new Game();
        game.setName(gameDTO.name);
        game.setReleaseDate(gameDTO.releaseDate);
        return game;
    }
}
