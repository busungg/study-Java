import java.text.*;
import java.util.*;

//형식화 클래스
public class FormatEx1 {
    public static void main(String[] args) throws ParseException {
        double number = 1234567.89765;
        String[] pattern = {
            "0",
            "#",
            "0.0",
            "#.#",
            "#,###.#######",
            "##,###.#######",
            "0000000000.000",
            "##########.###",
            "#.#-",
            "-#.#",
            "#,###.##",
            "#,####.##",
            "#E0",
            "0E0",
            "##E0",
            "####E0",
            "0000E0",
        };

        for(int i = 0; i < pattern.length; i++) {
            DecimalFormat df = new DecimalFormat(pattern[i]);
            System.out.printf("%19s : %s\n", pattern[i], df.format(number));
        }

        //SimpleDateFormat
        Calendar calendar1 = Calendar.getInstance();
        Date date = calendar1.getTime();

        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd E a h:mm:ss");
        System.out.println(dateFormat.format(date));

        SimpleDateFormat dateFormat2 = new SimpleDateFormat("yyyy-mm-dd");
        String dateStr = "2999-01-01";
        Date date2 = dateFormat2.parse(dateStr);

        System.out.println(date2);
    }
}
