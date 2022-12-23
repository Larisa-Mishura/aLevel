package com.mishura.container;

import com.mishura.model.Car;

public class CarList<T extends Car> {
    private Node<T> first;
    private Node<T> last;
    private int size;

    public CarList() {
        this.first = null;
        this.last = null;
        this.size = 0;
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
        while (current != null){
            if (current.car.equals(car)){
                return position;
            } else {
                current = current.next;
                position ++;
            }
        }
        return -1;
    }

    public void insert(T car, int position) { // Вставка значення за номером позиції
        Node<T> newNode = new Node<>(car);
        if (isEmpty()) {
            insertFirst(car);
        } else {
            Node current = findNode(position - 1);
            current.next.previous = newNode;
            newNode.next = current.next;
            newNode.previous = current;
            current.next = newNode;
        }
        size++;
    }

    public Node<T> findNode(int position) {
        if (position > size) {
            System.out.println("Tne number of position is bigger than size of list.");
            return last;
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
        if (isEmpty() || position > (size - 1)){
            System.out.println("Tne number of position is bigger than size of list.");
            return;
        }
        if (position == 0){
            deleteFirst();
        } else if (position == size-1){
            deleteLast();
        } else{
            Node<T> nodeToDelete = findNode(position);
            nodeToDelete.previous.next = nodeToDelete.next;
            nodeToDelete.next.previous = nodeToDelete.previous;
        }
        size--;
    }

    public void deleteFirst() { // Видалення першого значення
        first = first.next;
        first.previous = null;

    }

    public void deleteLast() { // Видалення останнього значення
        last.previous = last;
        last.previous = null;
    }

    public void iteratorListCar() { // Можна обійти всю колекцію через foreach
        System.out.println("List (first --> last");
        Node<T> current = first;
        while (current != null){
            System.out.println(current.car.toString());
            current = current.next;
        }
    }

    public int totalAmount() { // Підрахунок загального count всіх машин всередині колекції
        int totalAmount = 0;
        return totalAmount;
    }

    private static class Node<T> {
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
