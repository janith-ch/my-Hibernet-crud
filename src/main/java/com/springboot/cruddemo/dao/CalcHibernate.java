package com.springboot.cruddemo.dao;

import com.springboot.cruddemo.entity.Calculation;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;

@Repository
@Component
public class CalcHibernate implements CalcDao {
    @Autowired
    private EntityManager entityManager;

    @Override
    public Calculation calculate(Calculation calc, int x) {


        Session currentSession = entityManager.unwrap(Session.class);
        calc.setSum(x);
        //   calc.setId(0);
        currentSession.saveOrUpdate(calc);
        return calc;

    }

    @Override
    @Transactional
    public Calculation getOneItem(int id) {
        Session currentSession = entityManager.unwrap(Session.class);
        Calculation calculation = currentSession.get(Calculation.class, id);

        return calculation;
    }
}
