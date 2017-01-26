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
        laptop.setLaptopGraphics(ComputerStore.getWhatGPU());
    }

    @Override
    public void buildLaptopProcessor() {
        laptop.setLaptopProcessor(ComputerStore.getWhatCPU());
    }

    @Override
    public void buildLaptopScreen() {
        laptop.setLaptopScreen(ComputerStore.getWhatScreen());
    }

    @Override
    public void buildLaptopWeight() {
        laptop.setLaptopWeight(ComputerStore.getWhatWeight());
    }

    public Laptop getLaptop() {
        return this.laptop;
    }
}
