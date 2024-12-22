package modern.chap03;

import java.util.List;
import java.util.function.BiPredicate;
import java.util.function.Predicate;
import java.util.function.ToIntFunction;

/**
 * 다음 람다 표현식과 일치하는 메서드 참조를 구현하시오
 */
public class Quiz_3_6 {
    public static void main(String[] args) {
        ToIntFunction<String> stringToInt = (String s) -> Integer.parseInt(s);
        BiPredicate<List<String>, String> conatins = (list, element) -> list.contains(element);
        Quiz_3_6 instanceClass = new Quiz_3_6();
        Predicate<String> startsWithNumber = (String string) -> instanceClass.startsWithNumber(string);

        ToIntFunction<String> stringToInt2 = Integer::parseInt;
        BiPredicate<List<String>, String> contains2 = List::contains;
        Predicate<String> startsWithNumber2 = instanceClass::startsWithNumber;
    }

    public boolean startsWithNumber(String string) {
        return Character.isDigit(string.charAt(0));
    }
}
