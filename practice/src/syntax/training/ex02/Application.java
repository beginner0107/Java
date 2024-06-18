package syntax.training.ex02;

public class Application {
    public static void main(String[] args) {
        WaterSpray waterSpray = new WaterSpray(100);
        waterSpray.fillUp();

        FlowerPot pot = new FlowerPot(5);

        int water = waterSpray.getRemainingWaterInMl();
        waterSpray.spray();
        water -= waterSpray.getRemainingWaterInMl();

        //pot.addWater(water);

        System.out.printf("pot alive? %s", pot.isAlive());
    }
}
