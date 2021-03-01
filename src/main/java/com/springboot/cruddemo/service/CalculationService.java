package com.springboot.cruddemo.service;

import com.springboot.cruddemo.entity.Calculation;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;


@Service
public interface CalculationService {

    public Calculation Calculate(Calculation calc);

    public Calculation getOneItem(int id);
}
