# 자바 접근제어자(Modifier)
## What are Java Modifier
- 클래스, 생성자, 메서드 또는 필드에 추가된 키워드
- 기능을 추가하거나 대상의 의미를 변경합니다.
- 수정자는 두 그룹으로 나뉩니다.
    - 액세스 수정자(Access Modifiers)
    - 비-액세스 수정자(Non-Access Modifiers)

### Access Modifiers
```java
public class Product {
    private int price;
    
    Product(int price) {this.price = price;}
    
    protected int getPrice() {return price;}
}
```
### Constructor Modifiers
```java
public class Product {
    public Product(int price, String name, int size){}
    private Product(int price, String name);
    protected Product(int price){}
    Product(){}
}
```

### Class Non-Access Modifiers
```java
public class Product {
    
}
```
- Abstract - 클래스를 추상 클래스로 만듭니다.
- Final - 클래스 구현을 마무리하여 상속할 수 없게 하는 final 제어자
- Static - 내부 클래스를 외부 클래스 없이 인스턴스화할 수 있게 만듭니다.
- Interface - 클래스를 인터페이스로 표시합니다.

### Method Non-Access Modifiers
```java
public synchronized int someMethod(String s){}
```
- Abstract - 메서드를 추상적으로 만듭니다.
- Final - 메서드 구현을 마무리하여 상속할 수 없게 하는 final 제어자
- Static - 메서드를 클래스 수준의 메서드로 만듭니다.
- Interface - 한 번에 하나의 스레드에서 메서드에 액세스할 수 있습니다.
- Native - 다른 프로그래밍 언어로 구현됨

### Field Non-Access Modifiers
```java
public class Product {
    private final int price;
}
```
- Final - 메서드 구현을 마무리하여 상속할 수 없게 하는 final 제어자
- Static - 메서드를 클래스 수준의 메서드로 만듭니다.
- Transient - 필드를 직렬화하지 않도록 표시합니다.
- Volatile - Makes reads/writes to long/double atomic, 데이터 경합을 방지합니다.

## 리플렉션을 사용하여 Modifier 를 검색하고 분석하는 방법
### Modifiers Discovery with getModifiers()
- Class.getModifiers() - 클래스 수정자를 리턴합니다.
- Constructor.getModifiers() - 생성자 수정자를 리턴합니다.
- Method.getModifiers() - 메서드 수정자를 리턴합니다.
- Field.getModifiers() - 필드 수정자 리턴
- Modifiers 는 정수 값으로 패킹됩니다.

### 비트맵 인코딩 Modifiers
- 수정자는 비트맵으로 인코딩됩니다.
- 각 수정자는 단일 비트를 나타냅니다.
- Example
```text
PUBLIC = 1.         Binary representation - .... 0000 0001
STATIC = 8.         Binary representation - .... 0000 1000

PUBLIC | STATIC = 9. Binary representation - .... 0000 1001
```
### Modifier Helper Class
- 이러한 비트맵 작업을 돕기 위해 Reflection에는 모든 수정자(modifier)에 대한 비트 마스크가 포함된 수정자(modifier) 클래스가 함께 제공됩니다.
- 예시:
```java
int modifiers = Product.class.getModifiers();

if ((modifiers & Modifier.ABSTRACT) != 0) {
    System.out.println("Product is an abstract class");
}
```

### Modifier Helper Class Bitmask Methods
- Modifier 클래스는 이러한 비트마스크 연산을 수행하는 정적 헬퍼 메서드도 제공합니다.
- 다음과 같은 메서드
    - boolean Modifier.isPublic(int modifiers)
    - boolean Modifier.isFinal(int modifiers)
    - boolean Modifier.isStatic(int modifiers)
    - ...

## Modifier 클래스 사용 예시
```java
public class Main {

    public static void main(String[] args) throws ClassNotFoundException {
//        printClassModifiers(Serializable.class);
//        printMethodsModifiers(Auction.class.getDeclaredMethods());
        printFieldsModifiers(Auction.class.getDeclaredFields());
    }

    public static void printFieldsModifiers(Field[] fields) {
        for (Field field : fields) {
            int modifier = field.getModifiers();

            System.out.printf("Field \"%s\" access modifier is %s%n", field.getName(), getAccessModifierName(modifier));

            if (Modifier.isVolatile(modifier)) {
                System.out.println("The field is volatile");
            }

            if (Modifier.isFinal(modifier)){
                System.out.println("The field is final");
            }

            if (Modifier.isTransient(modifier)){
                System.out.println("The field is transient and will not be serialized");
            }
            System.out.println();
        }
    }

    public static void printMethodsModifiers(Method[] methods) {
        for (Method method : methods) {
            int modifier = method.getModifiers();

            System.out.println(String.format("%s() access modifier is %s", method.getName(), getAccessModifierName(modifier)));

            if (Modifier.isSynchronized(modifier)) {
                System.out.println("The method is synchronized");
            } else {
                System.out.println("The method is not synchronized");
            }
            System.out.println();
        }
    }

    public static void printClassModifiers(Class<?> clazz) {
        int modifier = clazz.getModifiers();

        System.out.printf("Class %s access modifier is %s%n", clazz.getSimpleName(), getAccessModifierName(modifier));

        if (Modifier.isAbstract(modifier)) {
            System.out.println("The class is abstract");
        }

        if (Modifier.isInterface(modifier)) {
            System.out.println("The class is an interface");
        }

        if (Modifier.isStatic(modifier)) {
            System.out.println("The class is static");
        }
    }

    private static String getAccessModifierName(int modifier) {
        if (Modifier.isPublic(modifier)) {
            return "public";
        } else if (Modifier.isPrivate(modifier)) {
            return "private";
        } else if (Modifier.isProtected(modifier)) {
            return "protected";
        } else {
            return "package-private";
        }
    }

    public static void runAction() {
        Auction auction = new Auction();
        auction.startAuction();

        Bid bid1 = Bid.builder()
                .setBidderName("Company1")
                .setPrice(10)
                .build();
        auction.addBid(bid1);

        Bid bid2 = Bid.builder()
                .setBidderName("Company2")
                .setPrice(12)
                .build();
        auction.addBid(bid2);

        auction.stopAuction();

        System.out.println(auction.getAllBids());
        System.out.println("Highest bid : " + auction.getHighestBid().get());
    }
}

```
