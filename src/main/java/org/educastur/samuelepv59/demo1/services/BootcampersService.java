package org.educastur.samuelepv59.demo1.services;

import org.educastur.samuelepv59.demo1.models.Bootcampers;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class BootcampersService {
    private final ArrayList<Bootcampers>bootcampers = new ArrayList<>();

    public ArrayList<Bootcampers>getAll(){
        return bootcampers;
    }

    public void add (Bootcampers bootcamper){
        bootcampers.add(bootcamper);
    }

    public Bootcampers get(String nombre){
        for (Bootcampers b : bootcampers){
            if (b.getNombre().equals(nombre))return b;
        }
        return null;
    }
}
