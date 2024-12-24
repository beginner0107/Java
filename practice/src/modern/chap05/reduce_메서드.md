# reduce 메서드
## reduce 메서드의 장점과 병렬화
- reduce를 이용해서 합계의 차이는 무엇?
- 내부 구현으로 병렬로 실행할 수 있다는 점
- 가변 누적자 패턴 (mutable accumulator pattern)
```java
int sum = numbers.parallelStream().reduce(0, Integer::sum);
```
- 병렬로 실행하려면 대가를 지불해야 함
  - reduce에 넘겨준 람다의 상태가 바뀌지 않아야 함
  - 연산이 어떤 순서로 실행되더라도 결과가 바뀌지 않는 구조

## 스트림 연산: 상태 없음과 상태 있음
- 컬렉션으로 스트림을 만드는 stream 메서드를 parallelStream 로 바꾸는 것만으로도 병렬성을 얻을 수 있음
- map, filter 등은 입력 스트림에서 각 요소를 받아 0 또는 결과를 출력 스트림으로 보냄
  - 이들은 내부 상태를 갖지 않는 연산(stateless operation)
- reduce, sum, max 같은 연산은 결과를 누적할 내부 상태가 필요
  - int, double을 내부 상태로 사용
  - 스트림에서 처리하는 요소 수와 관계없이 내부 상태의 크기는 한정(bounded) 되어 있음
- sorted, distinct
  - 스트림의 요소를 정렬하거나 중복을 중복을 제거하려면 과거의 이력을 알고 있어야 함
  - 어떤요소를 출력 스트림으로 추가하려면 **모든 요소가 버퍼에 추가되어 있어야 함**
- 데이터 스트림의 크기가 크거나 무한이라면 문제가 생길 수 있음
- 이러한 연산을 **내부 상태를 갖는 연산 (stateful operation)**
