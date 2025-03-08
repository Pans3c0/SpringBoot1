package org.educastur.samuelepv59.demo1.controllers;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import org.educastur.samuelepv59.demo1.models.Bootcampers;
import org.educastur.samuelepv59.demo1.services.BootcampersService;
import org.springframework.stereotype.Component;

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
}
