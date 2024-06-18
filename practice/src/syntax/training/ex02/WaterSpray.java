package syntax.training.ex02;

/**
 * 분무기 객체
 */
public class WaterSpray {
    private static final int CAPACITY = 200;

    private int remainingWaterInMl; // 현재 남아있는 물의 양

    public WaterSpray(int remainingWaterInMl) {
        this.remainingWaterInMl = remainingWaterInMl;
    }

    public void spray() {
        this.remainingWaterInMl -= Math.min(this.remainingWaterInMl, 5);
    }

    public int getRemainingWaterInMl() {
        return remainingWaterInMl;
    }
    public void addWater(int amountInMl) {
        this.remainingWaterInMl += amountInMl;
        this.remainingWaterInMl = Math.min(remainingWaterInMl, amountInMl);
    }

    public void fillUp() {
        this.remainingWaterInMl = CAPACITY;
    }
}
