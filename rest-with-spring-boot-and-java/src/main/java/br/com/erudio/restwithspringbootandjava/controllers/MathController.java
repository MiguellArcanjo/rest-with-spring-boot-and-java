package br.com.erudio.restwithspringbootandjava.controllers;

import br.com.erudio.restwithspringbootandjava.exceptions.UnsupportedMathOperationExeception;
import org.springframework.web.bind.annotation.*;
import java.util.concurrent.atomic.AtomicLong;
import br.com.erudio.restwithspringbootandjava.convert.Validation;

@RestController
public class MathController {
    private final AtomicLong counter = new AtomicLong();

    @RequestMapping(value = "/sum/{num1}/{num2}", method = RequestMethod.GET)
    public Double sum(@PathVariable(value = "num1") String num1, @PathVariable(value = "num2") String num2) throws Exception{

        if (!Validation.isNumeric(num1) || !Validation.isNumeric(num2)) {
            throw new UnsupportedMathOperationExeception("Please set a numeric value!");
        }
        return Validation.convertToDouble(num1) + Validation.convertToDouble(num2);
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
