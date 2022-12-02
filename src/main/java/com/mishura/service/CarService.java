package com.mishura.service;

import com.mishura.model.Car;
import com.mishura.model.Color;
import com.mishura.model.Engine;
import com.mishura.repository.CarArrayRepository;
import com.mishura.util.RandomGenerator;

import java.util.Arrays;
import java.util.Random;

public class CarService {
    private final CarArrayRepository carArrayRepository;
    private final RandomGenerator randomGenerator = new RandomGenerator();

    private Random random = new Random();

    public CarService(final CarArrayRepository carArrayRepository) {
        this.carArrayRepository = carArrayRepository;
    }

    public Car create() {
        final String manufacturer = randomString(9);
        final Color color = getRandomColor();
        final Engine engine = new Engine(randomString(4));
        final Car car = new Car(manufacturer, engine, color);
        carArrayRepository.save(car);
        return car;
    }

    public void create(final int count){
        for (int i = 0; i < count; i++) {
            create();
        }
    }

    public int create(RandomGenerator randomGenerator){
        int count = randomGenerator.generateRandomInt();
        if((count < 1) || (count > 10)) {
            count = -1;
        }
        for (int i = 0; i < count; i++) {
            Car car = create();
            print(car);
        }
        return count;
    }

    private Color getRandomColor(){
        final Color[] colors = Color.values();
        final int randomIndex = random.nextInt(colors.length);
        return colors[randomIndex];
    }

    private String randomString(int length) {
        String chars = "ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
        Random random = new Random();
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < length; i++) {
            int number = random.nextInt(chars.length());
            char ch = chars.charAt(number);
            builder.append(ch);
        }
        return builder.toString();
    }

    public void print(Car car) {
        System.out.printf("{ Manufacture: %-12s\tEngine: %-12s\tColor: %-8s\tCount %-4d\tPrice: %-9d}\n",
                car.getManufacturer(),
                car.getEngine(),
                car.getColor(),
                car.getCount(),
                car.getPrice());
    }

    public void check(Car car) {
        print(car);
        if ((car == null) || (car.getCount() < 1)) {
            System.out.println("  -  машини нема в наявності.");
            return;
        } else if ((car.getEngine() == null) || (car.getEngine().getPower() < 200)) {
            System.out.println("  -  потужність двигуна менше 200.");
            return;
        }
        System.out.println("  -  машина повністю готова до продажу.");
    }

    public void printAll(){
        final Car[] all = carArrayRepository.getAll();
        System.out.println(Arrays.toString(all));
    }

    public Car[] getAll(){
        return carArrayRepository.getAll();
    }

    public Car find(final String id){
        if ((id == null) || id.isEmpty()){
            return null;
        }
        return carArrayRepository.getByIG(id);
    }

    public void delete(final String id){
        if ((id == null) || id.isEmpty()){
            return;
        }
        carArrayRepository.delete(id);
    }

    public void insert(final int index, final Car car){
        if(car == null){
            return;
        }
        carArrayRepository.insert(index, car);
    }

    public void changeRandomColor(final String id){
        if ((id == null) || id.isEmpty()){
            return;
        }
        final Car car = find(id);
        findAndChangeRandomColor(car);
    }

    private void findAndChangeRandomColor(final Car car){
        final Color color = car.getColor();
        Color randomColor;
        do {
            randomColor = getRandomColor();
        } while (randomColor == color);
        carArrayRepository.updateColor(car.getId(), randomColor);
    }
}