package syntax.training.ex02;

public class Application2 {
    public static void main(String[] args) {
        WaterSpray waterSpray = new WaterSpray(100);
        waterSpray.fillUp();

        FlowerPot pot = new FlowerPot(10);

        for (int i = 0; i < 2; ++i) {
            int water = waterSpray.getRemainingWaterInMl();
            waterSpray.spray();
            water -= waterSpray.getRemainingWaterInMl();

            //pot.addWater(water);
        }

        System.out.printf("pot alive? %s", pot.isAlive());
    }
}
