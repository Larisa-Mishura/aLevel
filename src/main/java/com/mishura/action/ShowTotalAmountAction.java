package com.mishura.action;

public class ShowTotalAmountAction implements Action{
    @Override
    public void execute() {
        System.out.println(CAR_SERVICE.getAll().length);
    }
}
