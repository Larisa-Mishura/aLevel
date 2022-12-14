package com.mishura;

import com.mishura.action.Actions;
import com.mishura.model.Car;
import com.mishura.model.PassengerCar;
import com.mishura.model.Type;
import com.mishura.repository.CarArrayRepository;
import com.mishura.service.CarService;
import com.mishura.util.AlgorithmUtil;
import com.mishura.util.UserInput;
import org.apache.commons.lang3.StringUtils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args){
        final CarService carService = CarService.getInstance();
        carService.create(3, Type.CAR);
        carService.create(3, Type.TRUCK);
        carService.printAll();
        Car[] cars = carService.getAll();
        Car car1 = cars[1];
        Car car2 = cars[2];

        System.out.println(AlgorithmUtil.binarySearch(cars, car1));
        System.out.println(AlgorithmUtil.binarySearch(cars, car2));


        final Actions[] values = Actions.values();
        final String[] names = mapActionToName(values);

        while (true){
            final int userChoise = UserInput.menu(names);
            values[userChoise].execute();
        }
    }

    private static String[] mapActionToName(final Actions[] values){
        String[] names = new String[values.length];
        for (int i = 0; i < values.length; i++) {
            names[i] = values[i].getName();
        }
        return names;
    }
}
