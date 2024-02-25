package org.example.gamesjakartaee.resource;

import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.example.gamesjakartaee.dto.GameDTO;
import org.example.gamesjakartaee.repository.GameRepository;

import java.net.URI;
import java.util.List;

@Path("/games")
public class GameResource {

    private GameRepository gameRepository;

    public GameResource() {
    }

    @Inject
    public GameResource(GameRepository gameRepository) {
        this.gameRepository = gameRepository;
    }


    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<GameDTO> findAll() {
        return gameRepository.findAll();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("{id}")
    public GameDTO one(@PathParam("id") String id) {
        return new GameDTO("Mario Kart", 1992);
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response create(GameDTO gameDTO) {
        //save to database
        Long id = gameRepository.insertGame(gameDTO);
        return Response.created(
                        //Ask jakarta application server for hostname and url path
                        URI.create("http://localhost:8080/games-jakartaEE-1.0-SNAPSHOT/api/games/" + id.toString()))
                .build();
    }
}