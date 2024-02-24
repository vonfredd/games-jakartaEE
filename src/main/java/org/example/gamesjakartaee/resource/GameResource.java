package org.example.gamesjakartaee.resource;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import org.example.gamesjakartaee.dto.GameDTO;

@Path("/games")
public class GameResource {
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public GameDTO hello() {
        return new GameDTO("God of war",2005);
    }
}