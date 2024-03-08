package org.example.gamesjakartaee.resource;

import jakarta.inject.Inject;
import jakarta.validation.Valid;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.example.gamesjakartaee.dto.GameDTO;
import org.example.gamesjakartaee.entity.Game;
import org.example.gamesjakartaee.service.GameService;

import java.net.URI;
import java.util.List;

@Path("/games")
public class GameResource {

    @Inject
    private GameService gameService;

    public GameResource() {
    }

    @Inject
    public GameResource(GameService gameService) {
        this.gameService = gameService;
    }


    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<GameDTO> findAll() {
        return gameService.findAll();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("{id}")
    public Game one(@PathParam("id") Long id) {
        return gameService.findById(id);
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response create(@Valid GameDTO gameDTO) {
        Long id = gameService.insertGame(gameDTO);
        return Response.created(URI.create("http://localhost:8080/api/games/" + id)).build();
    }

    @PUT
    @Path("/{id}")
    public Response update(@PathParam("id") Long id, String name){
        gameService.updateGame(id,name);
        return Response.ok().build();

    }
}