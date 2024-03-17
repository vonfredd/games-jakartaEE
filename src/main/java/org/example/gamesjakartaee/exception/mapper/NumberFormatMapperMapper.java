package org.example.gamesjakartaee.exception.mapper;

import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.ext.Provider;
import org.example.gamesjakartaee.exception.NumberFormatException;
import org.jboss.logging.Logger;

@Provider
public class NumberFormatMapperMapper implements jakarta.ws.rs.ext.ExceptionMapper<NumberFormatException>{
    private static final Logger logger = Logger.getLogger(NumberFormatMapperMapper.class);

    @Override
    public Response toResponse(NumberFormatException exception) {
        logger.info(exception);
        return Response.status(Response.Status.BAD_REQUEST).entity(exception.getMessage()).build();
    }
}
