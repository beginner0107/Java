## 자바 리플렉션이란?
- JVM 기능
- 실행하는 동안 클래스와 객체 정보를 추출할 수 있음(Runtime)
- Reflection API를 통해 사용할 수 있음.
- 왜 정리하는지?
  - 회사 코드에서 객체들의 정보를 읽어 특정 기능을 수행할 때가 있었다.
  - 물론 특정한 상황에서만 쓰이지만 알고 있으면 좋을 것이라는 생각이 들었고
  - 스프링에는 많은 어노테이션을 사용하는데, 리플렉션의 개념이 녹아 있는 것임을 알게 되었다.


### 리플렉션으로 할 수 있는 일
- 리플렉션 API를 사용하면 다음과 같은 유연한 코드를 작성할 수 있습니다.
  - 런타임에 서로 다른 소프트웨어 구성 요소를 연결합니다.
  - 소스 코드를 수정하지 않고도 새로운 프로그램 흐름을 생성합니다.

- 리플렉션을 사용하면 작업 중인 객체나 클래스의 유형에 따라 동적으로 동작을 조정하고 변경하는 범용 알고리즘을 작성할 수 있습니다.

#### More On Reflection
- 런타임에 애플리케이션의 객체와 클래스를 분석할 수 있습니다.
- 매우 강력한
    - 라이브러리
    - 프레임워크
    - 소프트웨어 디자인
- 다른 방법으로는 불가능하다.!


#### 인기있는 자바 리플렉션 활용 사례
- JUnit: 자바 애플리케이션 단위(Unit) 테스트에 필요한 표준 프레임워크
    - JUnit이 없었다면?
```java
public class CarTest {
    public void setUp(){...}
    public void testDrive(){...}
    public void testBrake(){...}
    ...
    public static void main() {
        CarTest carTest = new CarTest();
        carTest.setUp();
        carTest.testDrive();
        carTest.setUp();
        carTest.testBrake();
    }
}
```
- 클래스를 테스트하는 테스트 메서드가 존재한다고 가정
- JUnit이 없으면 main 메서드로 프로그램을 새롭게 만들어야 함.
```java
public class CarTest() {
    @Before
    public void setUp(){..}
    @Test
    public void testDrive(){...}
    @Test
    public void testBrake(){...}
}
```
- 자바 리플렉션으로 테스트 로직에만 집중할 수 있다.
- ```@Before```로 setUp 메서드에 어노테이션을 추가하면 Test메서드 앞에 setUp 메서드를 실행할 수 있음
- ```@Test ``` 어노테이션을 추가하면 JUnit은 새로운 프로그램을 만들고 테스트 클래스를 인스턴스화함

```
Start test program

Create CarTest object

Find setup and test method

Run Tests

Test Report
```

- ```Dependency Injection``` (의존성 주입)
  - ```Spring/Spring Boot```
  - ```Google Guice```
  - 마찬가지로 리플랙션이 존재하지 않았다면?
```java
public class Car{
    public Car() {
        this.engine = new Engine();
        this.driver = createDriver();
    }
    
    ...
    public void driver() {...}
}
```
- Car 클래스의 인스턴스를 만들기 위해서는 생성자에서 직접적인 구현체 인스턴스를 생성해야 한다.

```java
public class Car {
    @Autowired
    private final Engine engine;
    @Autowired
    private final Driver driver;
    ...
    public void driver() {...}
}
```
```java
@Configuration
public class Config {
    @Bean
    public Engine createEngine() {
      ...
    }
    @Bean
    public Driver createDriver() {
      ...
    }
}
```
- Spring에서는 다음과 같은 코드를 볼 수 있다.
- 물론 ```@Autowired```는 스프링에 의존적인 주입 방식이고, 생성자 주입 방식을 많이 사용한다.
- 알 수 있는 점은 어노테이션을 통해 애플리케이션 런타임 시에 의존성 주입 및 연관관계를 맺어주는 작업을 수행한다는 것이다.
- 정확하게는
  1. 애플리케이션 시작
  2. ```@Bean``` 으로 등록한 Engine과 Driver 객체를 스프링 컨테이너에 등록
  3. Spring Framework는 Car 클래스를 찾는다.
  4. ```@Autowired``` 어노테이션이 선언된 클래스들이 존재하는지 스프링 컨테이너에서 찾아 주입해서 Car 객체가 만들어진다.

- JSON ```Serialization/Deserialization```
  - ```Jackson```
  - ```Gson```
  - 사용 예시
```json
{
  "name":"SeungJu",
  "age":25,
  "pets":[
    "dog",
    "cat"
    ]
}
```
```java
public class Person {
    private int age;
    private String name;
    private List<String> pets;
    
    // Getter & Setter
}
```
- 리플렉션으로 Person 클래스의 정보를 가지고 와서 
- Json 문자열에서 넘어온 값들을 넣어줘서 Person 객체로 역직렬화할 수 있다.
- 반대도 가능하다.
```java
String json = "{\"name\":\"SeungJu\", \"age\":25,\"pets\":[\"dog\",\"cat\"]}";
Person person = obejectMapper.readValue(json, Person.class);
// Conversion using Reflection
```

- 로깅 프레임워크
- ORM
- Web Frameworks
- Developer tools
- 등등

## 리플렉션의 문제점
- 목적에 맞지 않게 사용되면 코드를 변경해야하고
- 코드가 늦게 실행되거나
- 어떤 경우에는 실행하면 위험할 수 있다. (강제로 불러와서 쓰는 느낌)
- ```큰 힘에는 큰 책임이 따른다.```
- 자바 언어에 대해 잘 알지 못하면 독으로 작용한다.
- 안전하게 사용하는 방법에 대해 연습하자.!
