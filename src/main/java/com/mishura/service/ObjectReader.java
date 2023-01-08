package com.mishura.service;

import com.mishura.model.*;
import org.apache.commons.lang3.EnumUtils;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ObjectReader {

    private InputStream getResourceAsStream(String filename) {
        final ClassLoader contextClassLoader = Thread.currentThread().getContextClassLoader();
        final InputStream resourceAsStream = contextClassLoader.getResourceAsStream(filename);
        return resourceAsStream;
    }


    private String textFromFile(InputStream inputStream) throws IOException {
        BufferedInputStream reader = new BufferedInputStream(inputStream);
        String result = "";
        int i;
        while ((i = reader.read()) != -1){
            result = result + (char) i;
        }
        inputStream.close();
        return result;
    }

    private Map<String, String> fieldsToMap(String text) throws IOException {
        Map<String, String> map = new HashMap<>();
        String[] fields = text.split("\n");
        Pattern pattern = Pattern.compile("(\\w|-)+");
        Matcher matcher;
        String key = null;
        String value = null;
        for (String s : fields) {
            matcher = pattern.matcher(s);
            if (matcher.find()) {
                key = matcher.group();
            }
            if (matcher.find()) {
                value = matcher.group();
                map.put(key, value);
            }
        }
        return map;
    }

    private PassengerCar carFromMap(Map<String, String> map) throws IOException {
        PassengerCar car = new PassengerCar(map.get("id"));
        car.setManufacturer(map.get("manufacturer"));
        car.setEngine(new Engine(map.get("engine")));
        car.setColor(EnumUtils.getEnum(Color.class, map.get("color")));
        car.setCount(Integer.parseInt(map.get("count")));
        car.setPrice(Integer.parseInt(map.get("price")));
        car.setPassengerCount(Integer.parseInt(map.get("passengerCount")));
        return car;
    }

    public Car carFromResourceFile(String filename) throws IOException {
        String text = textFromFile(getResourceAsStream(filename));
        Map<String, String> map = fieldsToMap(text);
        PassengerCar car = carFromMap(map);
        return car;
    }
}

