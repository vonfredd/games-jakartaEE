package org.example.gamesjakartaee.resource;

import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.ws.rs.NotFoundException;
import jakarta.ws.rs.WebApplicationException;
import jakarta.ws.rs.core.MediaType;
import org.example.gamesjakartaee.service.GameService;
import org.jboss.resteasy.mock.MockDispatcherFactory;
import org.jboss.resteasy.mock.MockHttpRequest;
import org.jboss.resteasy.mock.MockHttpResponse;
import org.jboss.resteasy.spi.Dispatcher;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.net.URISyntaxException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class GameResourceTest {

    @Mock
    GameService gameService;
    ObjectMapper objectMapper;
    Dispatcher dispatcher;

    @BeforeEach
    public void setup(){
        objectMapper = new ObjectMapper();
        dispatcher = MockDispatcherFactory.createDispatcher();
        var resource = new GameResource(gameService);
        dispatcher.getRegistry().addSingletonResource(resource);
    }

    @Test
    @DisplayName("Return response 201 when saved a new entity")
    void returnResponse201WhenSavedANewEntity() throws URISyntaxException {
        MockHttpRequest request = MockHttpRequest.post("/games");
        request.contentType(MediaType.APPLICATION_JSON);
        request.content("{\"title\":\"Assassin's Creed Valhalla\",\"releaseYear\":2020}".getBytes());
        MockHttpResponse response = new MockHttpResponse();
        dispatcher.invoke(request, response);
        assertEquals(201 , response.getStatus());
    }

    @Test
    @DisplayName("Return response 400 when catching WebApplicationException")
    void returnResponse400WhenCatchingWebApplicationException() throws URISyntaxException {
        doThrow(WebApplicationException.class).when(gameService).add(any());
        MockHttpRequest request = MockHttpRequest.post("/games");
        request.contentType(MediaType.APPLICATION_JSON);
        request.content("{\"title\":\"Assassin's Creed Valhalla\",\"releaseYear\":2020}".getBytes());
        MockHttpResponse response = new MockHttpResponse();
        dispatcher.invoke(request, response);
        assertEquals(400 , response.getStatus());
    }

    @Test
    @DisplayName("Return responsecode 404 when deleting non existing entity")
    void returnResponsecode404WhenDeletingNonExistingEntity() throws URISyntaxException {
        MockHttpRequest request = MockHttpRequest.delete("/games/1");
        doThrow(NotFoundException.class).when(gameService).remove("1");
        MockHttpResponse response = new MockHttpResponse();
        dispatcher.invoke(request,response);
        assertEquals(404,response.getStatus());

    }
}