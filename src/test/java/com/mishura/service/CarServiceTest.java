package com.mishura.service;

import com.mishura.model.Car;
import com.mishura.model.Engine;
import com.mishura.repository.CarArrayRepository;
import com.mishura.util.RandomGenerator;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.mockito.ArgumentMatchers.any;

class CarServiceTest {

    private CarService target;
    private CarArrayRepository repository;
    private RandomGenerator randomGenerator;

    @BeforeEach
    void setUp(){
        repository = Mockito.mock(CarArrayRepository.class);
        target = new CarService(repository);
    }

    @Test
    void createTest() {
        final Car car = target.create();
        Assertions.assertNotNull(car);
        Assertions.assertNotEquals(0, car.getPrice());
    }

    @Test
    void printAllTest(){
        Assertions.assertDoesNotThrow(()-> target.printAll());
    }

    @Test
    void printTest(){
        final Car car = new Car();
        Assertions.assertDoesNotThrow(()-> target.print(car));
    }

    @Test
    void checkCountZeroTest(){
        final Car car = Mockito.mock(Car.class);
        Mockito.when(car.getCount()).thenReturn(0);
        Assertions.assertDoesNotThrow(()-> target.check(car));
    }

    @Test
    void checkCountOneTest(){
        final Car car = Mockito.mock(Car.class);
        Mockito.when(car.getCount()).thenReturn(1);
        Mockito.when(car.getEngine()).thenReturn(new Engine());
        Assertions.assertDoesNotThrow(()-> target.check(car));
    }

    @Test
    void checkEngineNullTest(){
        final Car car = Mockito.mock(Car.class);
        Mockito.when(car.getCount()).thenReturn(1);
        Mockito.when(car.getEngine()).thenReturn(null);
        Assertions.assertDoesNotThrow(()-> target.check(car));
    }

    @Test
    void findIDIncorrectNullID(){
        String id = null;
        final Car car = target.find(id);
        Assertions.assertNull(car);
    }

    @Test
    void findIDIncorrectEmptyID(){
        String id = "";
        final Car car = target.find(id);
        Assertions.assertNull(car);
    }

    @Test
    void findNotFound(){
        String id = "123";
        Mockito.when(repository.getByIG("123")).thenReturn(null);
        final Car car = target.find(id);
        Assertions.assertNull(car);
    }

    @Test
    void find(){
        final Car expected = new Car();
        String id = "123";
        Mockito.when(repository.getByIG("123")).thenReturn(expected);
        final Car actual = target.find(id);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    void deleteIdNull(){
        target.delete(null);
        Mockito.verify(repository, Mockito.never()).delete(Mockito.anyString());
    }

    @Test
    void deleteIdEmpty(){
        target.delete("");
        Mockito.verify(repository, Mockito.never()).delete(Mockito.anyString());
    }

    @Test
    void delete(){
        final String id = "123";
        target.delete(id);
        Mockito.verify(repository).delete(id);
    }

    @Test
    void insertIndex0(){
        final Car car = new Car();
        target.insert(0, car);
        Mockito.verify(repository).insert(0, car);
    }

    @Test
    void insertIndex100(){
        final Car car = new Car();
        target.insert(100, car);
        Mockito.verify(repository).insert(100, car);
    }

    // for create(RandomGenerator randomGenerator):
    @Test
    void createFiveCarsTest(){
        randomGenerator = Mockito.mock(RandomGenerator.class);
        Mockito.when(randomGenerator.generateRandomInt()).thenReturn(5);
        final int expected = 5;
        final int actual = target.create(randomGenerator);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    void createZeroCarsTest(){
        randomGenerator = Mockito.mock(RandomGenerator.class);
        Mockito.when(randomGenerator.generateRandomInt()).thenReturn(0);
        final int expected = -1;
        final int actual = target.create(randomGenerator);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    void createNegativeCountCarsTest(){
        randomGenerator = Mockito.mock(RandomGenerator.class);
        Mockito.when(randomGenerator.generateRandomInt()).thenReturn(-3);
        final int expected = -1;
        final int actual = target.create(randomGenerator);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    void createAndSaveTest(){
        randomGenerator = Mockito.mock(RandomGenerator.class);
        Mockito.when(randomGenerator.generateRandomInt()).thenReturn(3);
        int i = target.create(randomGenerator);
        Mockito.verify(repository, Mockito.times(i)).save(any(Car.class));
    }
}