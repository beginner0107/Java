package collections.java;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class StreamCollectors {

    @Test
    @DisplayName("toList")
    void toList() {
        List<Person> people = List.of(
                new Person("matthew"),
                new Person("jun"),
                new Person("tiera")
        );
        List<String> names = people.stream()
                .map(p -> p.name)
                .toList();
        assertEquals(3, names.size());
        assertEquals("matthew", names.get(0));
    }

    record Person(String name) {
    }

    @Test
    @DisplayName("joining")
    void joining() {
        List<Object> things = List.of("name", 23, "seoul");
        String joinedString = things.stream()
                .map(Object::toString)
                .collect(Collectors.joining(", "));
        assertEquals("name, 23, seoul", joinedString);
    }

    @Test
    @DisplayName("sumingInt")
    void summingInt() {
        List<Employee> employees = List.of(
                new Employee("matthew", 7600, "sales"),
                new Employee("clock", 4600, "it"),
                new Employee("matthew", 7600, "support"),
                new Employee("john", 3455, "sales"),
                new Employee("drain", 8990, "management"),
                new Employee("cargo", 2400, "it"),
                new Employee("sammy", 4350, "support"),
                new Employee("dean", 5400, "it")
        );

        int total = employees.stream().mapToInt(Employee::salary).sum();
        assertEquals(44395, total);
    }

    record Employee(
            String name, Integer salary, String department) {
    }

    @Test
    @DisplayName("groupingBy")
    void groupingBy() {
        List<Employee> employees = List.of(
                new Employee("matthew", 7600, "sales"),
                new Employee("clock", 4600, "it"),
                new Employee("matthew", 7600, "support"),
                new Employee("john", 3455, "sales"),
                new Employee("drain", 8990, "management"),
                new Employee("cargo", 2400, "it"),
                new Employee("sammy", 4350, "support"),
                new Employee("dean", 5400, "it")
        );

        Map<String, List<Employee>> byDept = employees.stream()
                .collect(Collectors.groupingBy(Employee::department));
        assertEquals(2, byDept.get("sales").size());
    }

    @Test
    @DisplayName("groupingByLikePivot")
    void groupingByLikePivot() {
        List<Employee> employees = List.of(
                new Employee("matthew", 7600, "sales"),
                new Employee("clock", 4600, "it"),
                new Employee("matthew", 7600, "support"),
                new Employee("john", 3455, "sales"),
                new Employee("drain", 8990, "management"),
                new Employee("cargo", 2400, "it"),
                new Employee("sammy", 4350, "support"),
                new Employee("dean", 5400, "it")
        );

        Map<String, Integer> totalByDept = employees.stream()
                .collect(Collectors.groupingBy(Employee::department, Collectors.summingInt(Employee::salary)));
        assertEquals(12400, totalByDept.get("it"));
    }

    @Test
    @DisplayName("partition")
    void partitionBy() {
        List<Student> students = List.of(
                new Student("matthew", 34),
                new Student("clock", 44),
                new Student("john", 91),
                new Student("dean", 73),
                new Student("sammy", 64),
                new Student("dean", 79)
        );

        Map<Boolean, List<Student>> passingFailing = students.stream()
                .collect(Collectors.partitioningBy(s -> s.grade > PASS_THRESHOLD));
        assertEquals(4, passingFailing.get(true).size());
    }
    private static final Integer PASS_THRESHOLD = 60;
    record Student(String name, Integer grade) {}
}
