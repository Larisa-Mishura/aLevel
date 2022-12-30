package com.mishura;

import com.mishura.container.CarList;
import com.mishura.container.GenericContainer;
import com.mishura.model.Car;
import com.mishura.model.Type;
import com.mishura.service.CarService;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.Iterator;
import java.util.Optional;

public class Main {
    public static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args){
        final CarService carService = CarService.getInstance();
        /*carService.create(3, Type.CAR);
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
        return names;*/
        /*Car truck = carService.create(Type.TRUCK);
        GenericContainer <? extends Car > containerTruck = new GenericContainer<>(truck);
        containerTruck.print();
        containerTruck.increaseCount();
        containerTruck.print();
        containerTruck.increaseCount(Optional.ofNullable(null));
        containerTruck.print();

        Car passengerCar = carService.create(Type.CAR);
        GenericContainer<? extends Car > containerCar = new GenericContainer<>(passengerCar);
        containerCar.print();
        containerCar.increaseCount();
        containerCar.print();
        containerCar.increaseCount(Optional.of(50));
        containerCar.print();
        containerCar.increaseCount(Optional.of(50.7));
        containerCar.print();*/

        CarList<Car> carList = new CarList<>();
        for(int i = 0; i < 3; i++){
            Car car = carService.createRandomTypeCar();
            carList.insertLast(car);
            System.out.println(car);
        }
        System.out.println(carList.size());

        System.out.println("Додавання на початок списку:");
        carList.insertFirst(carService.createRandomTypeCar());
        carList.forEach(System.out::println);
        System.out.println(carList.size());


        System.out.println("Додавання в кінець списку:");
        carList.insertLast(carService.createRandomTypeCar());
        carList.forEach(System.out::println);
        System.out.println(carList.size());

        System.out.println("Пошук номера позиції за значенням:");
        Car car = carService.createRandomTypeCar();
        System.out.println(car);
        System.out.println(carList.findKey(car));

        System.out.println("Вставка значення за номером позиції:");
        car.setCount(51);
        carList.insert(car, 3);
        carList.forEach(System.out::println);
        System.out.println(carList.findKey(car));

        System.out.println("Видалення значення за номером :");
        carList.deleteKey(4);
        carList.deleteKey(0);
        carList.deleteKey(carList.size()-1);
        carList.forEach(System.out::println);
        System.out.println(carList.size());

        System.out.println("Підрахунок загального count всіх машин всередині колекції: " + carList.totalAmount());
    }
}
