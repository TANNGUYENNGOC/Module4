package com.example.service.impl;

import com.example.service.IConvertService;
import org.springframework.stereotype.Service;

@Service
public class ConvertService implements IConvertService {
    @Override
    public double convertVND(double usd) {
        return usd*23000;
    }

    @Override
    public double convertUSD(double vnd) {
        return vnd/23000;
    }
}
