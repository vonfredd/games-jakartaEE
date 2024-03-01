package org.example.gamesjakartaee.resource;

import jakarta.inject.Inject;
import jakarta.validation.Valid;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.example.gamesjakartaee.dto.GameDTO;
import org.example.gamesjakartaee.dto.Games;
import org.example.gamesjakartaee.repository.GameRepository;
import org.example.gamesjakartaee.service.GameService;

import java.net.URI;
import java.util.List;
import java.util.UUID;

@Path("/games")
public class GameResource {

    private GameService gameService;

    public GameResource() {
    }

    @Inject
    public GameResource(GameService gameService) {
        this.gameService = gameService;
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Games all() {
        return gameService.all();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("{id}")
    public GameDTO one(@PathParam("id") String id) {
        return new GameDTO("Mario Kart", 1992);
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response create(@Valid GameDTO gameDTO) {
        //save to database
        var p = gameService.add(gameDTO);
        return Response.created(
                        //Ask jakarta application server for hostname and url path
                        URI.create("http://localhost:8080/games-jakartaEE-1.0-SNAPSHOT/api/games/"))
                .build();
    }
}