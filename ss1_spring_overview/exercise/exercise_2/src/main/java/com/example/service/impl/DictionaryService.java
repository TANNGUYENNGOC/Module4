package com.example.service.impl;

import com.example.service.IDictionaryService;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class DictionaryService implements IDictionaryService {
    private static Map<String,String> dictionaryMap = new HashMap<String, String>();
    static {
        dictionaryMap.put("hello","chào bé LÊ VĂN ĐẠT");
        dictionaryMap.put("Yasuo","Kẻ bất dung thứ");
        dictionaryMap.put("Zed","chúa tể bóng tối");
        dictionaryMap.put("Javan IV","Hoàng tử Demacia");
    }
    @Override
    public String searchDictionary(String inputSearch) {
        String result = dictionaryMap.get(inputSearch);
        return result == null ? "không có kết quả" : result;
    }
}
