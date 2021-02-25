package com.springboot.cruddemo.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.stereotype.Component;

import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
@Component
@Table(name = "sum")
public class Calculation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "number_01")
    private int number01;
    @Column(name = "number_02")
    private int number02;
    @Column(name = "sum")
    private int sum;

}
