package com.edward.fullsatck;

import jakarta.transaction.Transactional;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.QueryParam;
import jakarta.ws.rs.core.MediaType;
import org.jboss.resteasy.reactive.RestQuery;

@Path("/hello")
public class GreetingResource {

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    @Transactional
    public String hello(@QueryParam("name") String name) {
        Greeting greeting = new Greeting();
        greeting.name = name;
        greeting.persist();
        return "Hi " + name;
    }
}
