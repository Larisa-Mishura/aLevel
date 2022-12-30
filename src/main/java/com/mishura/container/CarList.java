package com.mishura.container;

import com.mishura.model.Car;
import lombok.Getter;

import java.util.Iterator;

@Getter
public class CarList<T extends Car> implements Iterable<T> {
    private Node<T> first;
    private Node<T> last;
    private int size;
    private CarIterator<T> iterator;

    public CarList() {
        this.first = null;
        this.last = null;
        this.size = 0;
    }

    public int size() {
        return this.size;
    }

    public boolean isEmpty() {
        return first == null;
    }

    public void insertFirst(T car) { // Додавання на початок списку
        Node<T> newNode = new Node<>(car);
        if (isEmpty()) {
            last = newNode;
        } else {
            first.previous = newNode;
            newNode.next = first;
        }
        first = newNode;
        size++;
    }

    public void insertLast(T car) { // Додавання в кінець списку
        Node<T> newNode = new Node<>(car);
        if (isEmpty()) {
            first = newNode;
        } else {
            last.next = newNode;
            newNode.previous = last;
        }
        last = newNode;
        size++;
    }

    public int findKey(T car) { // Пошук номера позиції за значенням
        int position = 0;
        Node current = first;
        while (current != null) {
            if (current.car.equals(car)) {
                return position;
            } else {
                current = current.next;
                position++;
            }
        }
        return -1;
    }

    public void insert(T car, int position) { // Вставка значення за номером позиції
        if (position >= size) {
            System.out.println("Tne number of position is bigger than size of list.");
            return;
        }
        Node<T> newNode = new Node<>(car);
        Node prev = findNode(position - 1);
        newNode.next = prev.next;
        newNode.previous = prev;
        prev.next = newNode;
        newNode.next.previous = newNode;
        size++;
    }

    public Node<T> findNode(int position) throws NullPointerException{
        if (position >= size) {
            throw new NullPointerException();
        } else {
            int index = 0;
            Node current = first;
            while (index != position) {
                current = current.next;
                index++;
            }
            return current;
        }
    }


    public void deleteKey(int position) { // Видалення значення за номером
        if (isEmpty() || position > (size - 1)) {
            System.out.println("Tne number of position is bigger than size of list.");
            return;
        }
        if (position == 0) {
            deleteFirst();
        } else if (position == size - 1) {
            deleteLast();
        } else {
            Node<T> nodeToDelete = findNode(position);
            nodeToDelete.previous.next = nodeToDelete.next;
            nodeToDelete.next.previous = nodeToDelete.previous;
            size--;
        }
    }

    public void deleteFirst() { // Видалення першого значення
        first = first.next;
        first.previous = null;
        size--;
    }

    public void deleteLast() { // Видалення останнього значення
        last = last.previous;
        last.next = null;
        size--;
    }

    public int totalAmount() { // Підрахунок загального count всіх машин всередині колекції
        int totalAmount = 0;
        for (Car car : this){
            totalAmount += car.getCount();
        }
        return totalAmount;
    }

    @Override
    public Iterator<T> iterator() {
        return new CarIterator<T>(this);
    }

    @Getter
    class Node<T> {
        T car;
        Node<T> next;
        Node<T> previous;

        public Node(T car) {
            this.car = car;
        }

        public Node(T car, Node<T> next, Node<T> previous) {
            this.car = car;
            this.next = next;
            this.previous = previous;
        }

        public void displayNode() {
            System.out.println(this.car.toString());
        }
    }
}