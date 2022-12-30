package com.mishura.service;

import com.mishura.container.CarList;
import com.mishura.model.*;
import com.mishura.repository.CarArrayRepository;
import com.mishura.util.RandomGenerator;

import java.util.*;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class CarService {
    private final CarArrayRepository carArrayRepository;

    private Random random = new Random();

    private static CarService instance;

    private CarService(final CarArrayRepository carArrayRepository) {
        this.carArrayRepository = carArrayRepository;
    }

    public static CarService getInstance(){
        if (instance == null){
            instance = new CarService(CarArrayRepository.getInstance());
        }
        return instance;
    }

    public boolean carEquals(Car car1, Car car2){
        if(car1 == car2){
            return true;
        }
        if (car1.getType() != car2.getType()) {
            return false;
        }
        if (car1.hashCode() != car2.hashCode()) {
            return false;
        }
        return car1.getId().equals(car2.getId());
    }

    public <T> List<T> findManafacturerByPrice(Collection<? extends Car> list, int x) {//Знайти машини дорожчі за ціну Х і показати їхнього виробника
        List<T> listResult = new ArrayList<>();
                /*list.stream()
                .map(car -> car.getPrice())
                .filter(price -> price  > x)
                .collect(Collectors.toList());*/
        return listResult;
    }

    public <T> int countSum(Collection<? extends Car> list) {//Порахувати суму машин через reduce
        int count = list
                .stream()
                .map(car -> car.getCount())
                .reduce(0, (subtotal, element) -> subtotal + element);
        return count;
    }

    public Map<String, Integer> mapToMap(Collection<? extends Car> list) {//Відсортувати машини за виробником, прибрати дублікати, перетворити на Map,
                                                           // де ключ - це id машини, а значення - це її тип (зберігаючи порядок)
        List<Car> carList = list.stream()
                .sorted()
        Map<String, Integer> map = new HashMap<>();


        return map;
    }

    public <T> Map<Integer, Integer> statistic(Collection<? extends Car> list) {//statistic Отримати статистику за ціною всіх машин
        Map<Integer, Integer> map = new HashMap<>();
        return map;
    }

    public <T> boolean priceCheck(Collection<? extends Car> list, int x) {//Написати реалізацію предиката, який перевіряє, що в переданій колекції в усіх машин є ціна, вища за число Х
        return false;
    }

    public <T> Car mapToObject(Map<String, Object> map) {//Написати реалізацію Function, яка приймає Map<String, Object> і створює конкретну машину на підставі полів Map
        Car car = createRandomTypeCar();
        return car;
    }

    public Map<Color, Integer> innerList(List<List<Car>> list, int price) {//
        Map<Color, Integer> map = new HashMap<>();
        return map;
        //innerList метод приймає колекцію List<List<Car>>, дістає машини, сортує за кольорами,
        //виводить інформацію на консоль, фільтрує за ціною, збирає в Map, де ключ - це колір, а
        //значення - к-ть машин
    }


    public Map<String, Integer> toManufacturerMap(List<? extends Car> list) {
        Map<String, Integer> map = new HashMap<>();
        for (Car car : list) {
            String manufacturer = car.getManufacturer();
            map.computeIfPresent(manufacturer, (key, value) -> value + car.getCount());
            map.putIfAbsent(manufacturer, car.getCount());
        }
        return map;
    }

    public Map<Integer, ArrayList<Car>> toEnginePowerMap(List<? extends Car> list) {
        Map<Integer, ArrayList<Car>> map = new HashMap<>();
        for (Car car : list) {
            int power = car.getEngine().getPower();
            map.putIfAbsent(power, new ArrayList<>());
            map.get(power).add(car);
        }
        return map;
    }

    public Car create(Type type) {
        final String manufacturer = randomString(9);
        final Color color = getRandomColor();
        final Engine engine = new Engine(randomString(4));
        if (type == Type.CAR) {
            PassengerCar car = new PassengerCar(manufacturer, engine, color);
            car.setPassengerCount(random.nextInt(20));
            carArrayRepository.save(car);
            return car;
        }
        if (type == Type.TRUCK) {
            Truck car = new Truck(manufacturer, engine, color);
            car.setLoadCapacity(random.nextInt(20));
            carArrayRepository.save(car);
            return car;
        }
        throw new IllegalArgumentException();
    }

    public void create(final int count, Type type){
        for (int i = 0; i < count; i++) {
            create(type);
        }
    }

    public int create(RandomGenerator randomGenerator){
        int count = randomGenerator.generateRandomInt();
        if((count < 1) || (count > 10)) {
            count = -1;
        }
        for (int i = 0; i < count; i++) {
            if (random.nextBoolean()) {
                Car car = create(Type.CAR);
                print(car);
            } else {
                Car car = create(Type.TRUCK);
                print(car);
            }
        }
        return count;
    }

    public Car createRandomTypeCar() {
        if (random.nextBoolean()) {
            return create(Type.CAR);
        } else {
            return create(Type.TRUCK);
        }
    }

    public void create(int count) {
        for (int i = 0; i < count; i++) {
            if (random.nextBoolean()) {
                create(Type.CAR);
            } else {
                create(Type.TRUCK);
            }
        }
    }

    private Color getRandomColor() {
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
            System.out.println("  -  невірна потужність двигуна.");
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

    private void findAndChangeRandomColor(final Car car) {
        final Color color = car.getColor();
        Color randomColor;
        do {
            randomColor = getRandomColor();
        } while (randomColor == color);
        carArrayRepository.updateColor(car.getId(), randomColor);
    }

    public void printManufacturerAndCount(final Car car) {
        Optional.ofNullable(car).ifPresent(value -> {
            System.out.printf("Manufacturer: %s, count: %d.\n", value.getManufacturer(), value.getCount());
        });
    }

    public void printColor(final Car car) {
        Car passengerCar = Optional.ofNullable(car).orElse(new PassengerCar(getRandomColor()));
        System.out.println("Color: " + passengerCar.getColor().toString());
    }

    public void checkCount(Car car) {
        Car value = Optional.ofNullable(car)
                .filter(carFilter -> carFilter.getCount() > 10)
                .orElseThrow(() -> new UserInputException());
        System.out.printf("Manufacturer: %s, count: %d.\n", value.getManufacturer(), value.getCount());
    }

    public void printEngineInfo(Car car) {
        Car value = Optional.ofNullable(car).orElseGet(() -> {
            System.out.print("Створено нову машину - ");
            return createRandomTypeCar();
        });
        Optional.of(value.getEngine()).map(c -> System.out.printf("Engine power: %d.\n", c.getPower()));
    }

    public void printInfo(Car car) {
        Optional.ofNullable(car).ifPresentOrElse(
                value -> print(car),
                () -> print(createRandomTypeCar())
        );
    }
}