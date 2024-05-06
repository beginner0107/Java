package reflection.exercises.graph_example;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.SortedMap;

// 기존 코드
public class Main2 {
    public static void main(String[] args) {
        BestGamesFinder bestGamesFinder = new BestGamesFinder();

        Set<String> games = bestGamesFinder.getAllGames();

        Map<String, Float> gameToRating = bestGamesFinder.getGameToRating(games);
        Map<String, Float> gameToPrice = bestGamesFinder.getGameToPrice(games);

        SortedMap<Double, String> scoreToGame = bestGamesFinder.scoreGames(gameToRating, gameToPrice);

        List<String> bestGamesInDescendingOrder = bestGamesFinder.getTopGames(scoreToGame);

        System.out.println(bestGamesInDescendingOrder);
    }
}
