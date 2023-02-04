package ch7.code;

class Car2 {
    String color;
    int door;

    Car2() {
        color = "red";
        door = 4;
    }

    void drive(){
        System.out.println("drive");
    }

    void stop(){
        System.out.println("stop");
    }
}

class FireEngine2 extends Car2 {
    String color;
    int door;

    FireEngine2() {
        color = "blue";
        door = 6;
    }

    void drive(){
        System.out.println("삐용삐용");
    }

    void water() {
        System.out.println("water");
    }
}

public class BindingTest {
    public static void main(String[] args) {
        Car2 car1 = new Car2();
        Car2 car2 = new FireEngine2();
        FireEngine2 car3  = (FireEngine2)car2;

        System.out.printf("color: %s, door: %d\n", car1.color, car1.door);
        car1.drive();
        System.out.printf("color: %s, door: %d\n", car2.color, car2.door);
        car2.drive();
        System.out.printf("color: %s, door: %d\n", car3.color, car3.door);
        car3.drive();
    }
}
