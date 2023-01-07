package com.mishura.service;

import com.mishura.model.*;
import org.apache.commons.lang3.EnumUtils;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ObjectReader {

    public String textFromFile(String filename) throws IOException {
        final ClassLoader contextClassLoader = Thread.currentThread().getContextClassLoader();
        final InputStream resourceAsStream = contextClassLoader.getResourceAsStream(filename); //"xml/car.xml");
        BufferedInputStream reader = new BufferedInputStream(resourceAsStream);
        String result = "";
        int i;
        while ((i = reader.read()) != -1){
            result = result + (char) i;
        }
        resourceAsStream.close();
        return result;
    }

    public Map<String, String> fieldsToMap(String text) throws IOException {
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

    public Car carFromFile(String filename) throws IOException {
        String text = textFromFile(filename); //"car.xml");
        Map<String, String> map = fieldsToMap(text);
        PassengerCar car = new PassengerCar(map.get("id"));
        car.setManufacturer(map.get("manufacturer"));
        car.setEngine(new Engine(map.get("engine")));
        car.setColor(EnumUtils.getEnum(Color.class, map.get("color")));
        car.setCount(Integer.parseInt(map.get("count")));
        car.setPrice(Integer.parseInt(map.get("price")));
        car.setPassengerCount(Integer.parseInt(map.get("passengerCount")));
        return car;
    }
}

