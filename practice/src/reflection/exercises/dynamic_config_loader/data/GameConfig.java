package reflection.exercises.dynamic_config_loader.data;

import java.util.Random;

public class GameConfig {
    private static final int releaseYear = 2000;
    private String gameName;
    private double price;

    public int getReleaseYear() {
        return this.releaseYear;
    }

    public String getGameName() {
        return this.gameName;
    }

    public double getPrice() {
        return this.price;
    }

    @Override
    public String toString() {
        return "GameConfig{" +
                "releaseYear=" + releaseYear +
                ", gameName='" + gameName + '\'' +
                ", price=" + price +
                '}';
    }
}
