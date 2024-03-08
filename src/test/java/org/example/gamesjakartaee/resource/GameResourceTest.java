package org.example.gamesjakartaee.resource;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.example.gamesjakartaee.dto.Games;
import org.example.gamesjakartaee.service.GameService;
import org.jboss.resteasy.mock.MockDispatcherFactory;
import org.jboss.resteasy.mock.MockHttpRequest;
import org.jboss.resteasy.mock.MockHttpResponse;
import org.jboss.resteasy.spi.Dispatcher;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.io.UnsupportedEncodingException;
import java.net.URISyntaxException;
import java.time.LocalDateTime;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

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
    public void personsReturnsWithStatus200() throws URISyntaxException, UnsupportedEncodingException {
        when(gameService.all()).thenReturn(new Games(List.of(), LocalDateTime.now()));

        MockHttpRequest request = MockHttpRequest.get("/games");
        MockHttpResponse response = new MockHttpResponse();
        dispatcher.invoke(request,response);

        assertEquals(200, response.getStatus());
        assertEquals("{\"gameDTOS\":[],\"updated\"}", response.getContentAsString());
    }
}