package fr.m2i.premierspring.services;

import fr.m2i.premierspring.models.CoucouModel;
import org.springframework.stereotype.Component;

@Component
public class CoucouService {

    public void direCoucou(){
        System.out.println(new CoucouModel().getCoucou());
    }
}
