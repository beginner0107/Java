# 함수형 프로그래밍
- 컬렉션과 스트림
  - Stream은 Collection을 대체하려고 만든것이 아니다.
  - 조합해서 잘 쓰면 된다.
- 다섯 형태만 기억하자
  - consumer : input만 있는 형태
  - supplier : output만 있는 형태
  - function : input/output이 모두 있는 형태
  - predict : 참/거짓을 판별하는 형태
  - runner : input/output 이 없는 형태
- 예제코드 : [Functional.java]

# 스트림 연산과 파이프라인
- intermediate operation : return a new stream. They are always lazy
  - stateless : filter, map, flatMap, peek
  - stateful : distinct, sorted, skip, dropWhile
    - short-circuiting, limit, takeWhile
- terminal operation
  - forEach, forEachOrdered, toArray, reduce, collect, toList, min, max, count
  - short-circuiting : anyMatch, allMatch, noneMatch, findFirst, findAny
```java
int sum = widgets.stream()
        .filter(w -> w.getColor() == RED)
        .mapToInt(w -> w.getWeight())
        .sum();
```

# 스트림 유틸 클래스 : Collectors
```java
// Accumulate names into a List
// Accumulate names into a List
List<String> list = people.stream()
        .map(Person::getName)
        .collect(Collectors.toList());

// Accumulate names into a TreeSet
Set<String> set = people.stream()
        .map(Person::getName)
        .collect(Collectors.toCollection(TreeSet::new));

// Convert elements to strings and concatenate them, separated by commas
String joined = things.stream()
        .map(Object::toString)
        .collect(Collectors.joining(", "));

// Compute sum of salaries of employee
int total = employees.stream()
        .collect(Collectors.summingInt(Employee::getSalary));

// Group employees by department
Map<Department, List<Employee>> byDept = employees.stream()
        .collect(Collectors.groupingBy(Employee::getDepartment));

// Compute sum of salaries by department
Map<Department, Integer> totalByDept = employees.stream()
        .collect(Collectors.groupingBy(Employee::getDepartment,                                  Collectors.summingInt(Employee::getSalary)));

// Partition students into passing and failing
Map<Boolean, List<Student>> passingFailing = students.stream()
        .collect(Collectors.partitioningBy(s -> s.getGrade() >= PASS_THRESHOLD));
```
