package fr.m2i.premierspring;

import fr.m2i.premierspring.models.DataModel;
import fr.m2i.premierspring.services.CalculatriceService;
import fr.m2i.premierspring.services.CoucouService;
import fr.m2i.premierspring.services.SaisieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class PremierSpringApplication implements CommandLineRunner {


    @Autowired
    CoucouService coucouService;

//    @Autowired
//    CalculatriceService calculatriceService;
    @Autowired
    SaisieService saisieService;

    public static void main(String[] args) {
        SpringApplication.run(PremierSpringApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        coucouService.direCoucou();


//        while(true){
////            saisieService.menu();
//            saisieService.menu2();
//        }

    }

    //ancienne ecriture des commandLineRunner
//    @Bean
//    public CommandLineRunner run() {
//        return (args) -> {
//
//        };
//    }


}
