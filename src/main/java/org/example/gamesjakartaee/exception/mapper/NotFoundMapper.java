package org.example.gamesjakartaee.exception.mapper;

import jakarta.ws.rs.NotFoundException;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.ext.Provider;
import org.jboss.logging.Logger;

@Provider
public class NotFoundMapper implements jakarta.ws.rs.ext.ExceptionMapper<NotFoundException> {
    private static final Logger logger = Logger.getLogger(NotFoundMapper.class);

    @Override
    public Response toResponse(NotFoundException exception) {
        logger.info(exception);
        return Response.status(Response.Status.NOT_FOUND).entity(exception.getMessage()).build();
    }
}
