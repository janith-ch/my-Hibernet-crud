package com.springboot.cruddemo.rest;

import com.springboot.cruddemo.entity.Calculation;
import com.springboot.cruddemo.service.CalculationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

import java.util.Random;
@RestController
@RequestMapping("/")
public class CalController {

    @Autowired
    private CalculationService calculationService;
    @PutMapping("/calc")
    public Calculation Calc(@RequestBody Calculation calc){
        calc.setId(0);

        return calculationService.Calculate(calc);
    }



    @GetMapping("/one/{id}")
    public Calculation getOneItem(@PathVariable int id){
        return calculationService.getOneItem(id);
    }

}
