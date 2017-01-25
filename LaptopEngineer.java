package com.example.lesson40;

public class LaptopEngineer {
    private LaptopBuilder laptopBuilder;

    public LaptopEngineer(LaptopBuilder laptopBuilder) {
        this.laptopBuilder = laptopBuilder;
    }

    public Laptop getLaptop() {
        return this.laptopBuilder.getLaptop();
    }

    public void makeLaptop() {
        this.laptopBuilder.showLaptopType();
        this.laptopBuilder.buildLaptopGraphics();
        this.laptopBuilder.buildLaptopProcessor();
        this.laptopBuilder.buildLaptopScreen();
        this.laptopBuilder.buildLaptopWeight();
    }
}
