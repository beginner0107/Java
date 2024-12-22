package modern.chap03;

/**
 * 인수가 3개인 생성자 참조를 사용하려면?
 */
public class Quiz_3_7 {
    public static void main(String[] args) {
        TriConsumer<String, Integer, Integer, Player> triConsumer = Player::new;
        Player 박주영 = triConsumer.apply("박주영", 72, 178);
        System.out.println(박주영);
    }
}

@FunctionalInterface
interface TriConsumer<A, B, C, D> {
    D apply(A a, B b, C c);
}

// 선수
class Player {
    private String name;
    private int weight;
    private int height;

    private Player() {}

    public Player(String name, int weight, int height) {
        this.name = name;
        this.weight = weight;
        this.height = height;
    }

    @Override
    public String toString() {
        return "Player{" +
                "name='" + name + '\'' +
                ", weight=" + weight +
                ", height=" + height +
                '}';
    }
}
