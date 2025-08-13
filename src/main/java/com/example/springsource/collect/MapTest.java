package com.example.springsource.collect;

import java.util.HashMap;
import java.util.Map;

public class MapTest {
    public static void main(String[] args) {
        HashMap<String, String> map = new HashMap<>();
        for (int i = 0; i < 10; i++){
            map.put("key"+i,"value"+i);
        }
    }
}
