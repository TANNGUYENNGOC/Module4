package com.example.service.impl;

import com.example.service.ICalculatorService;
import org.springframework.stereotype.Service;

@Service
public class CalculatorService implements ICalculatorService {

    @Override
    public double calculator(double a, double b, String math) {
        if (math.equals("addition")){
            return a+b;
        } else if(math.equals("subtraction")){
            return a-b;
        } else if(math.equals("multiplication")){
            return a*b;
        } else {
            return a/b;
        }
    }
}
