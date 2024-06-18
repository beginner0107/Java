package syntax.training.ex02;

public class FlowerPot {

    private boolean alive = true;
    private int minDailyWaterInMl;

    public FlowerPot(int minDailyWaterInMl) {
        this.minDailyWaterInMl = minDailyWaterInMl;
    }

    public boolean isAlive() {
        return alive;
    }

    public int getMinDailyWaterInMl() {
        return minDailyWaterInMl;
    }

    public void addWater(int amountInMl) {
        if (amountInMl < minDailyWaterInMl) {
            alive = false;
        }
    }
}
