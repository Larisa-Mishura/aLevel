package com.mishura;

import com.mishura.container.CarComparator;
import com.mishura.container.CarList;
import com.mishura.container.CarTree;
import com.mishura.container.GenericContainer;
import com.mishura.model.Car;
import com.mishura.model.Color;
import com.mishura.model.Engine;
import com.mishura.model.Type;
import com.mishura.service.CarService;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.SQLOutput;
import java.util.*;
import java.util.stream.Collectors;

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

       /* System.out.println("------");

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

*/
        /*CarComparator comparator = new CarComparator();
        CarTree<Car> tree = new CarTree<>(comparator);
        Random random = new Random();
        for(int i = 0; i < 12; i++) {
            Car carToAdd = carService.createRandomTypeCar();
            carToAdd.setCount(random.nextInt(10) + 1);
            System.out.println(carToAdd.toString());
            tree.add(carToAdd);
        }
        System.out.println("Сума count усіх елементів правої гілки - " + tree.leftBranch());
        System.out.println("Сума count усіх елементів лівої гілки - " + tree.rightBranch());

        System.out.println("~".repeat(25));*/

        /*List<Car> list = new ArrayList<>();
        for(int i = 0; i < 12; i++) {
            Car carToAdd = carService.createRandomTypeCar();
            if( i % 2 == 0) {
                carToAdd.setManufacturer("Xxxxxx");
            }
            System.out.println(carToAdd.toString());
            list.add(carToAdd);
        }
        Map<String, Integer> map = carService.toManufacturerMap(list);
        System.out.println(map.toString());

        System.out.println("~".repeat(25));

        for(int i = 0; i < 12; i++) {
            if( i % 5 == 0) {
                list.get(i).getEngine().setPower(1000);;
            } else if( i % 3 == 0) {
                list.get(i).getEngine().setPower(1100);;
            } else {
                list.get(i).getEngine().setPower(1200);;
            }
        }
        Map<Integer, ArrayList<Car>> mapEnginePower = carService.toEnginePowerMap(list);
        System.out.println(mapEnginePower.toString());*/

        List<Car> list = new ArrayList<>();
        for(int i = 0; i < 12; i++) {
            Car carToAdd = carService.createRandomTypeCar();
            if( i % 5 == 0) {
                carToAdd.setPrice(2_000_000);
                carToAdd.setManufacturer("AAAAA");
            } else if( i % 3 == 0) {
                carToAdd.setPrice(2_500_000);
                carToAdd.setCount(3);
                list.add(carToAdd);
                carToAdd.setManufacturer("BBBBB");
            } else {
                carToAdd.setPrice(1_500_000);
                carToAdd.setManufacturer("CCCCC");
            }
            list.add(carToAdd);
        }

        list.forEach(car -> {
            System.out.print(car.getId() + "   ");
            carService.print(car);
        });

        System.out.println("Знайти машини дорожчі за ціну Х і показати їхнього виробника:");
        carService.findManafacturerByPrice(list, 2_000_000);

        System.out.println("Порахувати суму машин через reduce:");
        System.out.println(carService.countSum(list));

        System.out.println("Відсортувати машини за виробником, прибрати дублікати, перетворити на Map, де ключ - це id машини, а значення - це її тип (зберігаючи порядок):");
        Map<String, Type> map = carService.mapToMap(list);
        //map.forEach(key -> System.out.println(key), value -> );
        for (String key : map.keySet()){
            System.out.print(key + "  ");
            System.out.println(map.get(key));
        }

        System.out.println("Отримати статистику за ціною всіх машин:");
        carService.statistic(list);

        System.out.println("Написати реалізацію предиката, який перевіряє, " +
                "що в переданій колекції в усіх машин є ціна, вища за число Х");
        carService.priceCheck(list, 1_500_000);
        carService.priceCheck(list, 1_400_000);

        System.out.println("Написати реалізацію Function, яка приймає Map<String, Object> і створює конкретну машину на підставі полів Map");
        Map<String, Object> mapFields = new HashMap<>();
        mapFields.put("manufacturer", "Aaaaa");
        mapFields.put("engine", new Engine("7XXJ - 511"));
        mapFields.put("color", Color.GREEN);
        mapFields.put("count", 5);
        mapFields.put("price", 2_000_000);
        mapFields.put("type", Type.CAR);
        Car car = carService.mapToObject.apply(mapFields);
        carService.print(car);

        System.out.println("Дістає машини, сортує за кольорами, виводить інформацію на консоль, " +
                "фільтрує за ціною, збирає в Map, де ключ - це колір, а значення - к-ть машин");
        List<Car> list1 = new ArrayList<>();
        for(int i = 0; i < 3; i++) {
            Car carToAdd = carService.createRandomTypeCar();
            carService.print(carToAdd);
            list1.add(carToAdd);
        }
        List<Car> list2 = new ArrayList<>();
        for(int i = 0; i < 3; i++) {
            Car carToAdd = carService.createRandomTypeCar();
            carService.print(carToAdd);
            list2.add(carToAdd);
        }
        List<Car> list3 = new ArrayList<>();
        for(int i = 0; i < 3; i++) {
            Car carToAdd = carService.createRandomTypeCar();
            carService.print(carToAdd);
            list3.add(carToAdd);
        }

        List<List<Car>> bigList = new ArrayList<>();
        bigList.add(list1);
        bigList.add(list2);
        bigList.add(list3);

        Map<Color, Integer> mapFromLists = carService.innerList(bigList, 2_000_000);
        System.out.println(mapFromLists);
    }
}
