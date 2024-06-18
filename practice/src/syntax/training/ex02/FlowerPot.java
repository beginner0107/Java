package syntax.training.ex02;

public class FlowerPot {

    private boolean alive = true;
    private int minDailyWaterInMl;
    private int dailyWaterReceived = 0;

    public FlowerPot(int minDailyWaterInMl) {
        this.minDailyWaterInMl = minDailyWaterInMl;
    }

    public boolean isAlive() {
        return alive;
    }

    public int getMinDailyWaterInMl() {
        return minDailyWaterInMl;
    }

    public void addWater(WaterSpray spray) {
        int water = spray.getRemainingWaterInMl();
        spray.spray();
        water -= spray.getRemainingWaterInMl();

        dailyWaterReceived += water;
    }

    public void liveAnotherDay() {
        if (dailyWaterReceived < minDailyWaterInMl) {
            alive = false;
        }
        dailyWaterReceived = 0;
    }
}
