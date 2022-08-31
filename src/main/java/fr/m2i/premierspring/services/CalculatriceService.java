package fr.m2i.premierspring.services;

import fr.m2i.premierspring.enums.OperationType;
import fr.m2i.premierspring.models.DataModel;
import fr.m2i.premierspring.models.DataModel2;
import fr.m2i.premierspring.utils.Calcul;
import org.springframework.stereotype.Component;


@Component
public class CalculatriceService {



    public CalculatriceService() {
    }

    public DataModel calculate(DataModel dataModel){

        switch (dataModel.getOperation()){
            case 1:{
                dataModel.setResult(Calcul.addition(dataModel.getA(),dataModel.getB()));
                break;
            }
            case 2:{
                dataModel.setResult(Calcul.soustraction(dataModel.getA(),dataModel.getB()));
                break;
            }
            case 3:{
                dataModel.setResult(Calcul.division(dataModel.getA(),dataModel.getB()));
                break;
            }
            case 4:{
                dataModel.setResult(Calcul.multiplication(dataModel.getA(),dataModel.getB()));
                break;
            }
            case 5:{
                dataModel.setResult(Calcul.puissance(dataModel.getA(),dataModel.getB()));
                break;
            }
        }

        return dataModel;
    }

    public DataModel2 calculate2(DataModel2 dataModel){

        switch (dataModel.getOperation()){
            case ADDITION:{
                dataModel.setResult(Calcul.addition(dataModel.getA(),dataModel.getB()));
                break;
            }
            case SOUSTRACTION:{
                dataModel.setResult(Calcul.soustraction(dataModel.getA(),dataModel.getB()));
                break;
            }
            case MULTIPLICATION:{
                dataModel.setResult(Calcul.multiplication(dataModel.getA(),dataModel.getB()));
                break;
            }
            case DIVISION:{
                dataModel.setResult(Calcul.division(dataModel.getA(),dataModel.getB()));
                break;
            }
            case PUISSANCE:{
                dataModel.setResult(Calcul.puissance(dataModel.getA(),dataModel.getB()));
                break;
            }
        }

        return dataModel;
    }


}
