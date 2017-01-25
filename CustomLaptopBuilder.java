package com.example.lesson40;

public class CustomLaptopBuilder implements LaptopBuilder {
    private Laptop laptop;

    public CustomLaptopBuilder() {
        this.laptop = new Laptop();
    }

    @Override
    public void showLaptopType() {
        laptop.setLaptopType("Custom Laptop");
    }

    @Override
    public void buildLaptopGraphics() {
        laptop.setLaptopGraphics("");
    }

    @Override
    public void buildLaptopProcessor() {
        laptop.setLaptopProcessor("");
    }

    @Override
    public void buildLaptopScreen() {
        laptop.setLaptopScreen("");
    }

    @Override
    public void buildLaptopWeight() {
        laptop.setLaptopWeight("");
    }

    public Laptop getLaptop() {
        return this.laptop;
    }
}
