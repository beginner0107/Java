package collections.java;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class Functional {
    // consumer
    @Test
    @DisplayName("consumer")
    public void consumer() {
        Consumer<String> eat = (food) -> {
            System.out.println(food);
        };
        eat.accept("apple");
    }

    // supplier
    @Test
    @DisplayName("supplier")
    public void supplier() {
        Supplier<Integer> salary = () -> 300;
        int result = salary.get();
        assertEquals(300, result);
    }

    // function
    @Test
    @DisplayName("function")
    public void function() {
        Function<BigDecimal, BigDecimal> exchange = (dallar) -> dallar.multiply(BigDecimal.valueOf(1600));
        BigDecimal result = exchange.apply(BigDecimal.valueOf(43.27));
        assertEquals(BigDecimal.valueOf(69232), result);
    }

    // predicate
    @Test
    @DisplayName("predicate")
    public void predicate() {
        Predicate<String> predicate = (name) -> {
            return "jan".equals(name);
        };
        boolean result = predicate.test("jan");
        assertTrue(result);
    }
    
    // 함수형 프로그래밍 응용
    @Test
    @DisplayName("응용")
    public void functionalParams() {
        Function<Integer, Grade> schoolGradeCalculator = (score) -> {
            int gradeNum = score / 10;
            Grade result = switch (gradeNum) {
                case 9 -> Grade.A;
                case 8 -> Grade.B;
                case 7 -> Grade.C;
                case 6 -> Grade.D;
                default -> Grade.F;
            };
            return result;
        };

        Grade gradeResult = getGradeByScore(67, schoolGradeCalculator);
        assertEquals(Grade.D, gradeResult);
    }

    private Grade getGradeByScore(int score, Function<Integer, Grade> calculator) {
        return calculator.apply(score);
    }

    enum Grade {
        A, B, C, D, F
    }
}
