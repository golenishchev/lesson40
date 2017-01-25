package com.example.lesson40;

public class Laptop implements LaptopPlan {
    private String laptopType;
    private String laptopGraphics;
    private String laptopProcessor;
    private String laptopScreen;
    private String laptopWeight;

    @Override
    public void setLaptopType(String type) {
        laptopType = type;
    }

    public String getLaptopType() {
        return laptopType;
    }

    @Override
    public void setLaptopGraphics(String graphics) {
        laptopGraphics = graphics;
    }

    public String getLaptopGraphics() {
        return laptopGraphics;
    }

    @Override
    public void setLaptopProcessor(String processor) {
        laptopProcessor = processor;
    }

    public String getLaptopProcessor() {
        return laptopProcessor;
    }

    @Override
    public void setLaptopScreen(String screen) {
        laptopScreen = screen;
    }

    public String getLaptopScreen() {
        return laptopScreen;
    }

    @Override
    public void setLaptopWeight(String weight) {
        laptopWeight = weight;
    }

    public String getLaptopWeight() {
        return laptopWeight;
    }
}
