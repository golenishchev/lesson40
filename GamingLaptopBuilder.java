package com.example.lesson40;

public class GamingLaptopBuilder implements LaptopBuilder {
    private Laptop laptop;

    public GamingLaptopBuilder() {
        this.laptop = new Laptop();
    }

    @Override
    public void showLaptopType() {
        laptop.setLaptopType("Gaming Laptop");
    }

    @Override
    public void buildLaptopGraphics() {
        laptop.setLaptopGraphics("GTX 100500");
    }

    @Override
    public void buildLaptopProcessor() {
        laptop.setLaptopProcessor("i9001");
    }

    @Override
    public void buildLaptopScreen() {
        laptop.setLaptopScreen("120");
    }

    @Override
    public void buildLaptopWeight() {
        laptop.setLaptopWeight("40");
    }

    public Laptop getLaptop() {
        return this.laptop;
    }
}
