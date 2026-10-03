package com.realstate.RS.collections;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PropertyCollectionDemo {

    public static void main(String[] args) {

        // Generic List
        List<String> properties = new ArrayList<>();

        properties.add("2 BHK Flat - Noida");
        properties.add("1 BHK Studio - Noida");
        properties.add("5 BHK Apartment - Kathmandu");

        System.out.println("===== PROPERTY LIST =====");

        for (String property : properties) {
            System.out.println(property);
        }

        // Generic Map
        Map<Long, String> propertyMap = new HashMap<>();

        propertyMap.put(1L, "2 BHK Flat");
        propertyMap.put(2L, "1 BHK Studio");
        propertyMap.put(3L, "5 BHK Apartment");

        System.out.println("\n===== PROPERTY MAP =====");

        for (Map.Entry<Long, String> entry : propertyMap.entrySet()) {
            System.out.println(
                    "ID: " + entry.getKey()
                    + " | Property: " + entry.getValue()
            );
        }
    }
}