package com.mishura.container;

import com.mishura.model.Car;
import java.util.Iterator;

class CarIterator<T extends Car> implements Iterator<T> {
    private CarList<T>.Node<T> current;
    private CarList<T>.Node<T> next;
    private CarList<T> ourCarList;

    public CarIterator(CarList<T> carList) {
        this.ourCarList = carList;
        current = null;
        next = ourCarList.getFirst();
    }

    @Override
    public boolean hasNext() {
        return next != null;
    }

    @Override
    public T next() {
        current = next;
        next = next.next;
        return current.getCar();
    }
}
