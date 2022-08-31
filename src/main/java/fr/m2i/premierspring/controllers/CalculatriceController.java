package fr.m2i.premierspring.controllers;


import fr.m2i.premierspring.models.DataModel;
import fr.m2i.premierspring.services.CalculatriceService;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

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
            value="/result2"
    )
    public DataModel getResult2(
            @RequestParam("a")Double a,
            @RequestParam("b")Double b,
            @RequestParam("operation")Integer operation
            ){
        return calculatriceService.calculate(new DataModel(operation,a,b));
    }

    @GetMapping(
            value="/result3/{a}/{b}/{operation}"
    )
    public DataModel getResult3(
            @PathVariable("a")Double a,
            @PathVariable("b")Double b,
            @PathVariable("operation")Integer operation
    ){
        return calculatriceService.calculate(new DataModel(operation,a,b));
    }

}
