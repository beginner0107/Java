package reflection.exercises.json_writer.quiz;

// 객체의 크기에 대한 측정값은
// SizeOf(accountSummary) = {header} + {reference} + SizeOf{firstName} +SizeOf{lastName} + SizeOf{age} + SizeOf{salary} =
// 12 + 4 + (12 + 4 + 4) + (12 + 4 + 5) + 2 + 4 = 63
public class Main {
    public static void main(String[] args) throws IllegalAccessException {
        AccountSummary accountSummary = new AccountSummary("John", "Smith", (short) 20, 100_000);
        ObjectSizeCalculator objectSizeCalculator = new ObjectSizeCalculator();
        System.out.println(objectSizeCalculator.sizeOfObject(accountSummary));
    }
}
