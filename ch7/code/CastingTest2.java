package ch7.code;

class Car {
    String color;
    int door;

    void drive(){
        System.out.println("drive");
    }

    void stop(){
        System.out.println("stop");
    }
}

class FireEngine extends Car {
    void water() {
        System.out.println("water");
    }
}

public class CastingTest2 {
    public static void main(String args[]) {
        Car car = new Car();
        Car car2 = null;
        FireEngine fe = null;

        car.drive();
        fe = (FireEngine) car;
        //참조변수 car가 참조하고 있는 인스턴스가 Car타입의 인스턴스여서 조상타입의 인스턴스를 자손타입의 참조변수로 참조하는 것은 허용되지 않는다.
        fe.drive();
        car2 = fe;
        car2.drive();
    }
}