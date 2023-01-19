package ch9;

import java.util.*;

public class StringTokenizerEx1 {
    public static void main(String[] args) {
        String source = "100,200,300,400";
        StringTokenizer st = new StringTokenizer(source,",");

        while(st.hasMoreTokens()){
            System.out.println(st.nextToken());
        }

        source = "x=100*(200+300)/2";
        //구분자로 여러 문자들을 지정한 것을 눈여겨보자
        //StringTokenizer는 단 한 문자의 구분자만 사용할 수 있기 때문에 "+-*/=()"
        //전체가 하나의 구분자가 아니라 각각의 문자가 모두 구분자라는 것에 주의해야한다.
        st = new StringTokenizer(source, "+-*/=()", false);
        while(st.hasMoreTokens()){
            System.out.println(st.nextToken());
        }
    }
}
