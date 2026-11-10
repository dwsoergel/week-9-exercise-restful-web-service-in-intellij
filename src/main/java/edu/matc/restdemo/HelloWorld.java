package edu.matc.restdemo;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

@Path("/hello")
public class HelloWorld {
    // The Java method will process HTTP GET requests
    @GET
    // The Java method will produce content identified by the MIME Media type "text/plain"
    @Produces("text/plain")
    public Response getMessage() {
        // Return a simple message
        String output = "Hello World";
        return Response.status(200).entity(output).build();
    }

    @GET
    @Path("/{name}")
    @Produces("text/plain")
    public Response getMessageWithParameter(@PathParam("name") String name) {
        String output = "Hello " + name;
        return Response.status(200).entity(output).build();
    }

    @GET
    @Path("/html/{name}")
    @Produces("text/html")
    public Response getHtmlMessage(@PathParam("name") String name) {
        String output = "<h1>Hello " + name + "</h1>";
        return Response.status(200).entity(output).build();
    }

    @GET
    @Path("/json/{name}")
    @Produces("application/json")
    public Response getJsonMessage(@PathParam("name") String name) {
        String output = "{\"message\": \"Hello " + name + "\"}";
        return Response.status(200).entity(output).build();
    }
}