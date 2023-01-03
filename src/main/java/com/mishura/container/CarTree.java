package com.mishura.container;

import com.mishura.model.Car;
import lombok.Getter;
import lombok.Setter;

import java.util.Comparator;

@Getter
public class CarTree <T extends Car>{
    private TreeNode<T> root;
    private int size;
    Comparator<Car> comparator;
    int sum;

    public CarTree(Comparator<Car> comparator) {
        this.comparator = comparator;
        this.root = null;
        this.size = 0;
    }

    public int size() {
        return this.size;
    }

    public T find(int count) {
        TreeNode<T> current = root;
        while (current.car.getCount() != count){
            if (current.car.getCount() > count){
                current = current.leftChild;
            } else {
                current = current.rightChild;
            }
            if (current == null){
                return null;
            }
        }
        return current.car;
    }

    public void add(T car) {
        TreeNode<T> newNode = new TreeNode<>(car);
        if (root == null) {
            root = newNode;
        } else {
            TreeNode<T> current = root;
            TreeNode<T> parent;
            while(true) {
                parent = current;
                if (comparator.compare(car, current.car) < 0){
                    current = current.leftChild;
                    if (current == null) {
                        parent.leftChild = newNode;
                        return;
                    }
                } else {
                    current = current.rightChild;
                    if (current == null) {
                        parent.rightChild = newNode;
                        return;
                    }
                }
            }
        }
        size++;
    }

    public int leftBranch() { // Підрахунок загального count всіх машин всередині колекції
        sum = 0;
        return root.car.getCount() + countOfLocalRoot(root.leftChild);
    }

    public int rightBranch() { // Підрахунок загального count всіх машин всередині колекції
        sum = 0;
        return root.car.getCount() + countOfLocalRoot(root.rightChild);
    }

    public int countOfLocalRoot(TreeNode<T> localRoot){ // Підрахунок загального count всіх машин всередині колекції
        if(localRoot != null){
            countOfLocalRoot(localRoot.leftChild);
            sum += localRoot.car.getCount();
            countOfLocalRoot(localRoot.rightChild);
        }
        return sum;
    }

    @Getter
    @Setter
    class TreeNode<T> {
        private final T car;
        TreeNode<T> leftChild;
        TreeNode<T> rightChild;

        public TreeNode(T car) {
            this.car = car;
        }
    }
}
