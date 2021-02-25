package com.springboot.cruddemo.dao;

import com.springboot.cruddemo.entity.Calculation;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;


@Service
public interface CalcDao {

    public Calculation calculate(Calculation calc,int x);
    public Calculation getOneItem(int id);
}
