package org.example.gamesjakartaee.resource;

import jakarta.inject.Inject;
import jakarta.validation.Valid;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.example.gamesjakartaee.dto.GameDTO;
import org.example.gamesjakartaee.dto.Games;
import org.example.gamesjakartaee.service.GameService;

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
    public GameDTO one(@PathParam("id") Long id) {
        return gameService.one(id);
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response create(@Valid GameDTO gameDTO) {
        try {
            gameService.add(gameDTO);
        } catch (WebApplicationException e) {
            return Response.status(400).build();
        }
        return Response.status(201).build();
    }

    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces({MediaType.APPLICATION_JSON})
    public Response update(Long id, @Valid GameDTO updateInfo) {
        return gameService.update(id, updateInfo);
    }

    @DELETE
    @Path("{id}")
    public Response remove(@PathParam("id") String id) {
            gameService.remove(id);
            return Response.ok().build();
    }
}