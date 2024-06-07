# OOP의 특성
- 캡슐화(encapsulation)
- 상속(inheritance)
- 다형성(polymorphism)
- (데이터)추상화(abstraction)
- 연관(association)
- 컴포지션(composition)
- 집합(aggregation)

## 캡슐화
- 데이터와 그 데이터에 작용하는 메서드를 하나로 묶음
  - ex) 이름, 성별, 나이
- 정보 숨기기(data hiding)
  - 개체 안에 있는 데이터를 외부로부터 보호
    - 전부 혹은 일부
    - 외부: 다른 클래스에 속한 개체들

## 상속
- 이미 존재하는 개체를 기반으로 확장된 개체를 만드는 방법
  - 클래스라고 불림
- 확장된 개체
  - 기존의 개체에 속한 데이터와 동작을 모두 물려 받음
  - 다른 데이터나 동작을 추가할 수 있음

- 실용적인 용도
  - 코드 중복을 막음

## 다형성
- 같은 지시를 내렸는데 다른 종류의 개체가 동작을 달리 하는 것
- 어떤 함수 구현이 실행될지는 실행 중에 결정
  - 늦은 바인딩(late binding)이라고 함
- 일반적인 함수 호출은 이른 바인딩(early binding)
  - 컴파일 중에 결정됨
- 다형성의 혜택을 받으려면 상속 관계가 필요
  - 부모 개체에서 함수 시그내처를 선언
  - 자식 개체에서 그 함수를 다르게 구현(오버라이딩, overriding)
- 실용적인 용도
  - 다른 종류의 개체를 편하게 저장 및 처리 가능
```java
// 부모 클래스 Animal
class Animal {
  public void sound() {
    System.out.println("Some sound");
  }
}

// 자식 클래스 Bird
class Bird extends Animal {
  @Override
  public void sound() {
    System.out.println("Chirp");
  }
}

// 자식 클래스 Cat
class Cat extends Animal {
  @Override
  public void sound() {
    System.out.println("Meow");
  }
}

// 자식 클래스 Dog
class Dog extends Animal {
  @Override
  public void sound() {
    System.out.println("Bark");
  }
}

public class Main {
  public static void main(String[] args) {
    Animal[] pets = {new Bird(), new Cat(), new Dog()};

    // 각 객체의 sound 메소드 호출
    for (Animal pet : pets) {
      pet.sound();
    }
  }
}
```

## (데이터)추상화
- 데이터 추상화
  - 개체 사용 시 그 안에 정확히 어떤 데이터가 있는지 알 필요 없음
  - 개체 안에 있는 데이터에 직접 접근 불가
    - 그 대신 개체의 함수를 통해 접근
  - 캡슐화는 데이터 추상화를 이루는 방법 중 하나
- 추상화
  - 다형성을 통한 추상화
  - 추상 클래스(abstract class)나 인터페이스(interface)를 사용하는 추상화

## 연관
- 어떤 개체가 제공하는 기능을 다른 개체가 이용하는 관계
- 상속과 비교해서 설명
  - 상속은 자식 개체가 부모 개체의 모든 것을 내포하는 관계
  - 연관은 한 개체가 다른 개체를 참조하는 관계
  - 실세계에서 개체들이 상호작용하는 모습은 보통 연관과 비슷함
- 세부적으로 다시 집합과 컴포지션으로 나누기도 함

### 컴포지션
- 합성, 조합, 조립, 구성 등 다양한 번역어가 존재
- 여러 개의 부품(그 자체로 개체)을 조립해서 새 개체를 만드는 방법
- 예: 자동차를 구성하는 부품
- 집합과의 차이
  - 부품 그 자체로는 존재 의의가 없음
  - 조립품이 소멸할 때 부품도 같이 소멸

### 집합
- 여러 개체를 모아 다른 개체를 만들지만 별도로 존재 가능
- 예: A 대학에 등록한 학생들
- 컴포지션과의 차이
  - 각 개체들이 따로따로 살아남을 수 있음
  - 예: A대학이 문을 닫아도 학생들은 여전히 다른 대학에 등록 가능
