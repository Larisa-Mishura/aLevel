package com.mishura.action;

import com.mishura.service.CarService;

public interface Action {
    CarService CAR_SERVICE = CarService.getInstance();
    void execute();
}
