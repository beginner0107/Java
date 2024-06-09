# 개체 생성 시 맴버 데이터 초기화
```java
Human adam = new Human();
// adam.name: null
// adam.age: 0
```
- Java는 0에 준하는 값으로 초기화
  - int는 0
  - float은 0.0
  - 참조형은 null

## ```.```  연산자의 다른 의미
- Java: 개체의 멤버에 접근할 때 . 연산자를 사용
  - Java의 모든 개체는 포인터 형(예외: 기본 자료형)
  - 따라서 . 와 ->의 구분이 필요 없음
