package modern.chap04;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import static modern.chap04.Dish.*;

public class StreamExample2 {
    public static void main(String[] args) {
        // 컬렉션: for-each 루프를 이용하는 외부 반복
        List<String> names = new ArrayList<>();
        for (Dish dish : menu) {
            names.add(dish.getName());
        }

        // 컬렉션: 내부적으로 숨겨왔던 반복자를 사용한 외부 반복
        List<String> names2 = new ArrayList<>();
        Iterator<Dish> iterator = menu.iterator();
        while(iterator.hasNext()) {
            Dish dish = iterator.next();
            names2.add(dish.getName());
        }

        // 스트림: 내부 반복
        List<String> names3 = menu.stream()
                .map(Dish::getName)
                .toList();
    }
}
