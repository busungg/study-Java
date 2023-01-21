import java.text.*;

public class MessageFormatEx1 {
    //데이터를 정해진 양식에 맞게 출력할 수 있도록 도와준다.
    //데이터가 들어갈 자리를 마련해 놓은 양식을 미리 작성하고 프로그램을 이용해서 다수의 데이터를 같은 양식으로 출력할 때 사용하면 좋다.

    public static void main(String[] args) throws ParseException {
        String msg = "Name: {0} \nTel: {1} \nAge:{2} \nBirthday:{3}";
        Object[] arguments = {
            "이자바", "010-1234-1234", "20", "2020-01-01"
        };

        System.out.println(MessageFormat.format(msg, arguments));

        MessageFormat mf = new MessageFormat(msg);
        var objects =  mf.parse("Name: 헤이 \nTel: 010-2222-1111 \nAge:123 \nBirthday:2020-77-12");
        
        for(int i = 0; i < objects.length; i++) {
            System.out.println(objects[i]);
        }
    }
}
