package org.example.gamesjakartaee.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.PositiveOrZero;
import org.example.gamesjakartaee.entity.Game;

public record GameDTO(@NotBlank String title, @PositiveOrZero int releaseYear) {
    public static GameDTO map (Game game){
        return new GameDTO(game.getTitle(), game.getReleaseYear());
    }

    public static Game map (GameDTO gameDTO){
        var game = new Game();
        game.setTitle(gameDTO.title);
        game.setReleaseYear(gameDTO.releaseYear);
        return game;
    }
}
