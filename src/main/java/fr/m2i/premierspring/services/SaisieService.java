package fr.m2i.premierspring.services;

import fr.m2i.premierspring.enums.OperationType;
import fr.m2i.premierspring.models.DataModel;
import fr.m2i.premierspring.models.DataModel2;
import fr.m2i.premierspring.utils.Affichage;
import fr.m2i.premierspring.utils.SaisieConsole;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
public class SaisieService {


    @Autowired
    CalculatriceService calculatriceService;


    public SaisieService(){

    }

    public void menu(){

        SaisieConsole saisieConsole = new SaisieConsole();
        Affichage.formatLigne("choissez votre operation");
        Affichage.formatLigne(" 1 --- addition");
        Affichage.formatLigne(" 2 --- soustraction");
        Affichage.formatLigne(" 3 --- division");
        Affichage.formatLigne(" 4 --- multiplication");
        Affichage.formatLigne(" 5 --- puissance");
        Integer operation = saisieConsole.entier();

        Affichage.formatLigne("Veuillez saisir votre premier nombre");
        Double a =  saisieConsole.monDouble();
        Affichage.formatLigne("Veuillez saisir votre premier nombre");
        Double b =  saisieConsole.monDouble();

        DataModel result = calculatriceService.calculate(new DataModel(operation,a,b,null));

        Affichage.formatLigne("Le resultat de votre "+operation+ " est "+result.getResult());


    }

    public void menu2(){

        SaisieConsole saisieConsole = new SaisieConsole();
        Affichage.formatLigne("Entrez votre operation");
        try{
            DataModel2 dataModel2 = convertStringToDatamodel(saisieConsole.text());

            DataModel2 result = calculatriceService.calculate2(dataModel2);

            Affichage.formatLigne(result.getResult().toString());
        }catch (Exception e){
            Affichage.formatLigne("operation non reconnue");
        }



    }


    public DataModel2 convertStringToDatamodel(String operation){
        DataModel2 model = new DataModel2();
        try {
            String[] tab = operation.split(" ");
            model.setA(Double.parseDouble(tab[0]));
            model.setB(Double.parseDouble(tab[2]));
            model.setOperation(OperationType.fromString(tab[1]));
        }
        catch (Exception e){
            throw new IllegalArgumentException("saisie incorrect");
        }

        return model;
    }





}
