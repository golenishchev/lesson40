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
        laptop.setLaptopGraphics(Main.getWhatGPU());
    }

    @Override
    public void buildLaptopProcessor() {
        laptop.setLaptopProcessor(Main.getWhatCPU());
    }

    @Override
    public void buildLaptopScreen() {
        laptop.setLaptopScreen(Main.getWhatScreen());
    }

    @Override
    public void buildLaptopWeight() {
        laptop.setLaptopWeight(Main.getWhatWeight());
    }

    public Laptop getLaptop() {
        return this.laptop;
    }
}
