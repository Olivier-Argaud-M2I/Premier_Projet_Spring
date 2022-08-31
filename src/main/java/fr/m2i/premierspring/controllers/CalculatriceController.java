package fr.m2i.premierspring.controllers;


import fr.m2i.premierspring.enums.OperationType;
import fr.m2i.premierspring.models.DataModel;
import fr.m2i.premierspring.models.DataModel2;
import fr.m2i.premierspring.services.CalculatriceService;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/cal")
public class CalculatriceController {

    @Autowired
    CalculatriceService calculatriceService;


    @PostMapping(
            value = "/result",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public DataModel getResult(@RequestBody DataModel dataModel){
        return calculatriceService.calculate(dataModel);
    }


    @GetMapping(
            value="/result2",
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public DataModel getResult2(
            @RequestParam("a")Double a,
            @RequestParam("b")Double b,
            @RequestParam("operation")Integer operation
            ){
        return calculatriceService.calculate(new DataModel(operation,a,b));
    }

    @GetMapping(
            value="/result3/{a}/{b}/{operation}",
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public DataModel getResult3(
            @PathVariable("a")Double a,
            @PathVariable("b")Double b,
            @PathVariable("operation")Integer operation
    ){
        return calculatriceService.calculate(new DataModel(operation,a,b));
    }



    @PostMapping(
            value = "/result4",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public List<DataModel> getResult4(@RequestBody List<DataModel> dataModels){
        List<DataModel>modelList = new ArrayList<>();
        for (DataModel dataModel:dataModels) {
            modelList.add(calculatriceService.calculate(dataModel));
        }
        return modelList;
    }

    @PostMapping(
            value = "/result5",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.TEXT_PLAIN_VALUE
    )
    public String getResult5(@RequestBody List<DataModel2> dataModels){
        StringBuilder result = new StringBuilder();
        result.append("les resultats sont : ");
        for (DataModel2 dataModel:dataModels) {
            DataModel2 reponse = calculatriceService.calculate2(dataModel);
            result.append(reponse.getResult());
            result.append(" // ");
        }
        return result.toString();
    }

    @PostMapping(
            value = "/result6",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public List<DataModel2> getResult6(@RequestBody List<DataModel2> dataModels){
        List<DataModel2>modelList = new ArrayList<>();
        for (DataModel2 dataModel:dataModels) {
            modelList.add(calculatriceService.calculate2(dataModel));
        }
        return modelList;
    }
}
