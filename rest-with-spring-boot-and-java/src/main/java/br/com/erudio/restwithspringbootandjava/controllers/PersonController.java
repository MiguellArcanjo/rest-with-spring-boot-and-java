package br.com.erudio.restwithspringbootandjava.controllers;

import br.com.erudio.restwithspringbootandjava.exceptions.UnsupportedMathOperationExeception;
import br.com.erudio.restwithspringbootandjava.model.Person;
import br.com.erudio.restwithspringbootandjava.services.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.awt.*;
import java.util.concurrent.atomic.AtomicLong;
import br.com.erudio.restwithspringbootandjava.convert.Validation;

@RestController
@RequestMapping("/person")
public class PersonController {

    @Autowired
    private PersonService service;
//    private PersonService service = new PersonService();

    @RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public Person findById(@PathVariable(value = "id") String id) throws Exception{

        return service.findById(id);
    }

    @RequestMapping(value = "/subtraction/{num1}/{num2}", method = RequestMethod.GET)
    public Double subtraction(@PathVariable(value = "num1") String num1, @PathVariable(value = "num2") String num2) throws Exception {
        if(!Validation.isNumeric(num1) || !Validation.isNumeric(num2)) {
            throw new UnsupportedMathOperationExeception("Please set a numeric value!");
        }

        return Validation.convertToDouble(num1) - Validation.convertToDouble(num2);
    }

    @RequestMapping(value = "/division/{num1}/{num2}", method = RequestMethod.GET)
    public Double division(@PathVariable(value = "num1") String num1, @PathVariable(value = "num2") String num2) throws Exception {
        if(!Validation.isNumeric(num1) || !Validation.isNumeric(num2)) {
            throw new UnsupportedMathOperationExeception("Please set a numeric value!");
        }

        return Validation.convertToDouble(num1) / Validation.convertToDouble(num2);
    }

    @RequestMapping(value = "/media/{num1}/{num2}", method = RequestMethod.GET)
    public Double media(@PathVariable(value = "num1") String num1, @PathVariable(value = "num2") String num2) throws Exception {
        if(!Validation.isNumeric(num1) || !Validation.isNumeric(num2)) {
            throw new UnsupportedMathOperationExeception("Please set a numeric value!");
        }

        double sum = Validation.convertToDouble(num1) + Validation.convertToDouble(num2);

        return sum / 2;
    }

    @RequestMapping(value = "/multiplication/{num1}/{num2}", method = RequestMethod.GET)
    public Double multiplication(@PathVariable(value = "num1") String num1, @PathVariable(value = "num2") String num2) throws Exception {
        if(!Validation.isNumeric(num1) || !Validation.isNumeric(num2)) {
            throw new UnsupportedMathOperationExeception("Please set a numeric value!");
        }
        return Validation.convertToDouble(num1) * Validation.convertToDouble(num2);
    }

}
