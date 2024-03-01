package org.example.gamesjakartaee.resource;

import jakarta.inject.Inject;
import jakarta.validation.Valid;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.example.gamesjakartaee.dto.GameDTO;
import org.example.gamesjakartaee.dto.Games;
import org.example.gamesjakartaee.entity.Game;
import org.example.gamesjakartaee.service.GameService;

import java.net.URI;
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
    public GameDTO one(@PathParam("id") UUID id) {
        return gameService.one(id);
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response create(@Valid GameDTO gameDTO) {
        gameService.add(gameDTO);
        return Response.status(201).build();
    }

    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces({MediaType.APPLICATION_JSON})
    public Response update(UUID id, GameDTO updateInfo) {
        gameService.update(id, updateInfo);
        return Response.ok().build();
    }
}