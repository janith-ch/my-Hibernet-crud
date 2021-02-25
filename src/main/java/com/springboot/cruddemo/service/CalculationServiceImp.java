package com.springboot.cruddemo.service;

import com.springboot.cruddemo.dao.CalcDao;
import com.springboot.cruddemo.entity.Calculation;
import com.springboot.cruddemo.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.*;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

//import java.net.http.HttpHeaders;
import java.util.List;
import java.util.Objects;
import java.util.Random;

@Component
public class CalculationServiceImp implements CalculationService {

    @Autowired
    private CalcDao calcDao;

    @Override
    public Calculation Calculate(Calculation calc) {
        int x;
            x = calc.getNumber01() + calc.getNumber02();
            return calcDao.calculate(calc ,x);
    }

    @Override
    public Calculation getOneItem(int id) {

        return calcDao.getOneItem(id);
    }


   // @Scheduled(fixedDelay = 3000l)
   public List<Employee> exchangeRestTemplate() {


       RestTemplate restTemplate = new RestTemplate();
       String baseUrl = "http://localhost:8043//employees";

       HttpHeaders headers = new HttpHeaders();
       headers.setContentType(MediaType.APPLICATION_JSON);

       HttpEntity<Object> requestEntity = new HttpEntity<>(headers);
       ResponseEntity<List<Employee>> responseEntity =  restTemplate.exchange(
               baseUrl + "/",
               HttpMethod.GET,
               requestEntity,
               new ParameterizedTypeReference<List<Employee>>() {}
       );
       HttpStatus httpStatus = responseEntity.getStatusCode();
       List<Employee> test = responseEntity.getBody();
       System.out.println("status code :" + httpStatus);
       for(Employee t : test){
           System.out.println(t);
       }
       return test;

   }
}
