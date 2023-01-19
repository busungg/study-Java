package ch9;

import java.util.regex.*;;

public class RegularEx1 {
    public static void main(String[] args) {
        String[] data = {"bat", "baby", "bonus", "cA", "ca", "co","c.", "c0","car","combat","count","date","disc"};
        
        //정규식을 매개변수로 Pattern 클래스의 static 메서드인 Pattern compile을 호출하여 Pattern 인스턴스를 얻는다.
        Pattern p = Pattern.compile("c[a-z]*"); //c로 시작하는 소문자 영단어
        
        for(int i = 0; i < data.length; i++) {
            //정규식으로 비교할 대상을 매개변수로 Pattern 클래스의 Matcher matcher(CharSequence input)를 호출해서 Matcher 인스턴스를 얻는다.
            Matcher m = p.matcher(data[i]);
            //Matcher 인스턴스에 boolean matches()를 호출해서 정규식에 부합하는지 확인한다.
            if(m.matches()){
                System.out.print(data[i] + ",");
            }
        }
    }
}
