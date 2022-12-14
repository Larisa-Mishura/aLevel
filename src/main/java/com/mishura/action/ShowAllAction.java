package com.mishura.action;

import com.mishura.service.CarService;

public class ShowAllAction implements Action{
    @Override
    public void execute() {
        CAR_SERVICE.printAll();
    }
}
