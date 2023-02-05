# 지네릭스란?

### 1. 정의

1. 다양한 타입의 객체들을 다루는 메서드나 컬렉션 클래스에 컴파일 시의 타입체크(compile-time type check)를 해주는 기능

### 2. 사용 목적

1. 객체의 타입을 컴파일 시에 체크하여 객체의 타입 안정성을 높이고 형변환의 번거러움을 줄이기 위함
   - 타입 안정성을 높이는 것
     - 의도하지 않은 타입의 객체가 저장되는 것을 막고, 저장된 객체를 꺼내올 때 원래의 타입과 다른 타입으로 잘못 형변환되어 발생할 수 있는 오류를 줄여준 다는 뜻

### 3. 장점

1. 타입 안정성을 제공한다.
2. 타입체크와 형변환을 생략할 수 있으므로 코드가 간결해 진다.

### 4. 결론

1. 객체의 타입을 미리 명시해줌으로써 번거러운 형변환을 줄여준다.

# 지네릭스의 용어

```
    class Box<T> {}
```

1. Box<T> 지네릭 클래스, T의 Box 또는 T Box라고 읽는다.
2. T 타입 변수 또는 타입 매개변수.(T는 타입 문자)
3. Box 원시 타입(raw type)

# 지네릭스의 제한

1. 모든 객체에 대해 동일하게 동작해야하는 static 멤버에 타입 변수 T를 사용할 수 없다.  
   T는 인스턴스변수로 간주되기 때문이다. static 멤버는 인스턴스변수를 참조할 수 없다.
2. 지네릭 타입의 배열을 생성하는 것도 허용되지 않는다. 지네릭 배열 타입의 참조변수를 선선하는 것은 가능하지만.
   new T[10]과 같이 배열을 생성하는 것은 안된다는 뜻이다.
   지네릭 배열을 생성할 수 없는 것은 new 연산자 때문인데, 이 연산자는 컴파일 시점에 타입 T가 뭔지 정확히 알아야 한다.
   그런데 위의 코드에 정의된 Box<T> 클래스를 컴파일 하는 시점에서는 T가 어떤 타입이 될지 전혀 알 수 없다. instanceof 연산자도 new 연산자와 같은 이유로 T를 피연산자로 사용할 수 없다.

# 제한된 지네릭 클래스

타입 매개변수 T에 지정할 수 있는 타입의 종류를 제한할 수 있는 방법이 존재한다.

```
    FruitBox<Toy> fruitBox = new FruitBox<Toy>();
    fruitBox.add(new Toy()); //과일상자에 장난감을 담을 수 있다.
```

다음과 같이 지네릭 타입에 'extends'를 사용하면, 특정 타입의 자손들만 대입할 수 있게 제한할 수 있다.

```
    class FruitBox<T extends Fruit> { //Fruit 자손만 타입으로 지정 가능
        ArrayList<T> list = new ArrayList<T>();
    }

    //인터페이스를 구현해야 한다는 제약이 필요하다면 이때도 extends를 사용한다.
    interface Eatable {}
    class FoodBox<T extends Eatable> {...}

    //클래스 Fruit의 자손이면서 Eatable 인터페이스도 구현해야한다면 아래와 같이 '&' 기호로 연결한다.
    class FruitBox<T extends Fruit & Eatable> {...}
```

# 와일드 카드

매개변수에 과일박스를 대입하면 주스를 만들어서 반환하는 Juicer라는 클래스가 있고,
이 글래스에는 과일을 주스로 만들어서 반환하는 makeJuice()라는 static 메서드가 다음과 같이 정의되어 있다고 가정하자

```
    class Juicer {
        static Juice makeJuice(FruitBox<Fruit> box) { //static 메서드에는 타입 매개변수 T를 매개변수에 사용할 수 없으므로 위와 같이 타입 매개변수 대신, 특정 타입을 지정했다.
            ...
        }
    }

    FruitBox<Fruit> fruitBox = new FruitBox<Fruit>();
    FruitBox<Apple> appleBox = new FruitBox<Apple>();

    Juicer.makeJuice(fruitBox) //성공
    Juicer.makeJuice(appleBox) //실패

```

이렇게 지네릭 타입을 FruitBox<Fruit>으로 고정해 놓으면 위의 코드에서 알 수 있듯이
FuritBox<Apple> 타입의 객체는 makeJuice()의 매개변수가 될 수 없으므로, 다음과 같이 여러 가지 타입의 매개변수를 갖는 makeJuice()를 만들 수밖에 없다.

```
    static Juice makeJuice(FruitBox<Fruit> box) {...}
    static Juice makeJuice(FruitBox<Apple> box) {...}
```

그러나 위와 같이 오버로딩하면, 컴파일 에러가 발생한다. **_지네릭 타입이 다른 것만으로는 오버로딩이 성립하지 않기 때문이다._**
지네릭 타입은 컴파일러가 컴파일할 때만 사용하고 제거해버린다. 그래서 위의 두 메서드는 오버로딩이 아니라 메서드 중복 정의이다.
이럴때 사용하기 위해 고안된 것이 와일드 카드이다.

### 1. 와일드 카드 종류

1. \<? extends T> 와일드 카드의 상한 제한, T와 그 자손들만 가능
2. \<? super T> 와일드 카드의 하한제한, T와 그 조상들만 가능
3. \<?> 제한 없음, 모든타입이 가능 <? extends Object> 와 동일
   ```
       static Juice makeJuice(FruitBox<? extends Fruit> box) {...}
   ```

# 지네릭 메서드

메서드 선언부에 지네릭 타입이 선언된 메서드를 지네릭 메서드라 한다.

```
    static <T> void sort(List<T> list, Comparator<? super T> c)
```

지네릭 클래스에 정의된 타입 매개변수와 지네릭 메서드에 정의된 타입 매개변수는 전혀 별개의 것이다.
같은 타입 문자 T를 사용해도 같은 것이 아니라는 것에 주의해야 한다.

```
    class FruitBox<T> {
        ...
        static <T> void sort(List<T> list, Comparator<? super T> c) {
            ...
        }
    }
```

**_위의 코드에서 지네릭 클래스 FruitBox에 선언된 타입 매개변수 T와 지네릭 메서드 sort()에 선언된 타입 매개변수 T는 타입 문자만 같을 뿐 서로 다른 것이다._**  
그리고 sort()가 static메서드라는것에 주목하자. 앞서 설명한 것처럼, static멤버에는 타입 매개변수를 사용할 수 없지만, 이처럼 메서드에 지네릭 타입을 선언하고 사용하는 것은 가능하다.

메서드에 선언된 지네릭 타입은 지역 변수를 선언한 것과 같다고 생각하면 이해하기 쉬운데, 이 타입 매개변수는 메서드 내에서만 지역적으로 사용될 것이므로 메서드가 static이건 아니건 상관이 없다.

```
    static Juice makeJuice(FruitBox<? extends Fruit> box) {...}

    // 아래와 같이 변경 가능
    static <T extends Fruit> Juice makeJuice(FruitBox<T> box) {...}

    //이 메서드 호출할 때는 아래와 같이 타입 변수에 타입을 대입해야한다.
    FruitBox<Fruit> fruitBox = new FruitBox<Fruit>();
    FruitBox<Apple> appleBox = new FruitBox<Apple>();

    Juicer.<Fruit>makeJuice(fruitBox);
    Juicer.<Apple>makeJuice(appleBox);

    //그러나 대부분의 경우 컴파일러가 타입을 추정할 수 있기 때문에 생략해도 된다.
    //위의 코드에서도 fruitBox와 appleBox의 선언부를 통해 대입된 타입을 컴파일러가 추정할 수 있다.

    Juicer.makeJuice(fruitBox);
    Juicer.makeJuice(appleBox);
```

지네릭 메서드는 매개변수의 타입이 복잡할 때도 유용하다.

```
    public static void printAll(ArrayList<? extends Product> list,
                                ArrayList<? extends Product> list) {
        ...
    }

    //아래와 같이 변경할 수 있다.
    public static <T extends Product> void printAll(ArrayList<T> list,
                                ArrayList<T> list) {
        ...
    }
```

# 지네릭 타입의 형변환
