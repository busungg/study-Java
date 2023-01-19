package ch9;

import java.util.*;

public class RandomEx1 {
    public static void main(String[] args) {
        Random rand = new Random(1); //같은 종자값 사용시 같은 값을 같은 순서로 얻는것 확인 가능
                                            // 같은 종자값 사용 시 시스템이나 실행시간 등에 관계없이 항상 같은 값을 같은 순서로 반환할 것을 보장한다.
        Random rand2 = new Random(1);

        System.out.println("= rand =");
        for(int i = 0; i < 5; i++) {
            System.out.println(i + ":" + rand.nextInt());
        }

        System.out.println();
        System.out.println("= rand2 =");
        for(int i = 0; i < 5; i++) {
            System.out.println(i + ":" + rand2.nextInt());
        }
    }
}
