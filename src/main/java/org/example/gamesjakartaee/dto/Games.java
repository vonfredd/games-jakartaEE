package org.example.gamesjakartaee.dto;

import java.time.LocalDateTime;
import java.util.List;

public record Games(List<GameDTO> gameDTOS, LocalDateTime updated){}
