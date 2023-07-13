package com.openbootcamp.demo.controllers;

import com.openbootcamp.demo.models.Test;
import com.openbootcamp.demo.services.TestService;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.Response;
import org.springframework.stereotype.Component;

import java.net.URI;
import java.util.List;

@Component
@Path("/")
public class TestController {
    private final TestService testService;

    public TestController(TestService testService) {
        this.testService = testService; // Esto funciona debido a la inyección de dependencias de Spring
        // El funcionamiento se basa en la inyección de dependencias,
        // donde el contenedor IoC proporciona automáticamente una instancia de TestService al constructor del controlador.
        // Esto te permite acceder a los métodos de TestService en el controlador después de la asignación.
    }

    @GET
    @Path("/test")
    @Produces("application/json")
    public List<Test> showAll() {
        return testService.getAll();
    }

    @GET
    @Path("/test/{name}")
    @Produces("application/json")
    public Test listOne(@PathParam("name") String name) {
        return testService.get(name);
    }

    @POST
    @Path("/test")
    @Produces("application/json")
    @Consumes("application/json")
    public Response insertTest(Test test) {
        testService.add(test);

        return Response.created(
                URI.create("/test/" + test.getName())
        ).build();
    }
}
