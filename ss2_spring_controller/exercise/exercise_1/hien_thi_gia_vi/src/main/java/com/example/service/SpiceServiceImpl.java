package com.example.service;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class SpiceServiceImpl implements ISpiceService{
    @Override
    public List<String> showSpiceList(String lettuce,String tomato,String mastard,String sprouts) {
        List<String> spiceList = new ArrayList<>();
        if(lettuce!=null){
            spiceList.add(lettuce);
        }
        if(tomato!=null){
            spiceList.add(tomato);
        }
        if (mastard!=null){
            spiceList.add(mastard);
        }
        if(sprouts!=null){
            spiceList.add(sprouts);
        }
        return spiceList;
    }
}
