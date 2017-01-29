public class TravelLaptopBuilder implements LaptopBuilder {
    private Laptop laptop;

    public TravelLaptopBuilder() {
        this.laptop = new Laptop();
    }

    @Override
    public void showLaptopType() {
        laptop.setLaptopType("Travel Laptop");
    }

    @Override
    public void buildLaptopGraphics() {
        laptop.setLaptopGraphics("Intel HD 730");
    }

    @Override
    public void buildLaptopProcessor() {
        laptop.setLaptopProcessor("i3 7-th Gen");
    }

    @Override
    public void buildLaptopScreen() {
        laptop.setLaptopScreen("13");
    }

    @Override
    public void buildLaptopWeight() {
        laptop.setLaptopWeight("0.9");
    }

    public Laptop getLaptop() {
        return this.laptop;
    }
}
