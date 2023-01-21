import java.text.*;
import java.util.*;

class ChoiceFormatEx1 {
    public static void main(String[] args) {
        double[] limits = {60,70,80,90};
        String[] grades = {"D", "C", "B", "A"};

        int[] scores = new int[10];
        Random rand = new Random();
        for(int i = 0; i < scores.length; i++) {
            scores[i] = rand.nextInt(100);
        }

        ChoiceFormat choiceFormat = new ChoiceFormat(limits, grades);
        for(int i = 0; i < scores.length; i++) {
            System.out.printf("%d : %s \n", scores[i], choiceFormat.format(scores[i]));
        }

        // 경계값은 double형으로 반드시 모두 오름차순으로 정렬되어 있어야 하며, 
        // 치환 될 문자열의 개수는 경계값에 의해 정의된 범위의 개수와 일치해야 한다.
        // 그렇지 안흐면 IllegalArgumentException이 발생한다.

    }
}