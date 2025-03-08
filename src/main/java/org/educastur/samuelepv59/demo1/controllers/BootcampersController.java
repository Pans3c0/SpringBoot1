package org.educastur.samuelepv59.demo1.controllers;

import jakarta.ws.rs.*;
import jakarta.ws.rs.core.Response;
import org.educastur.samuelepv59.demo1.models.Bootcampers;
import org.educastur.samuelepv59.demo1.services.BootcampersService;
import org.springframework.stereotype.Component;

import java.net.URI;
import java.util.ArrayList;

@Component
@Path("/")
public class BootcampersController {
    private BootcampersService bootcampersService;

    public BootcampersController(BootcampersService bootcampersService){
        this.bootcampersService = bootcampersService;

        this.bootcampersService.add(new Bootcampers("47540602Q","Pacheco","689113710","samupachebq@gmail.com"));

    }

    @GET
    @Path("/bootcampers")
    @Produces("aplication/json")
    public ArrayList<Bootcampers> listaTodos(){
        return bootcampersService.getAll();
    }

    @GET
    @Path("bootcampers/{nombre}")
    @Produces("aplication/json")
    public Bootcampers listarUno(@PathParam("nombre") String nombre){
        return bootcampersService.get(nombre);
    }

    @POST
    @Path("/bootcampers")
    @Produces("aplication/json")
    @Consumes("aplication/json")
    public Response introducirBootcamper(Bootcampers bootcampers){
        bootcampersService.add(bootcampers);

        return Response.created(URI.create("/bootcampers/"+bootcampers.getNombre())).build();
    }
}
