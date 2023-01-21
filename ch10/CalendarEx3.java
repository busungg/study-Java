import java.util.*;

class CalendarEx3 {
    public static void main(String[] args) {
        final int[] TIME_UNIT = {3600, 60, 1};
        final String[] TIME_UNIT_NAME = {"시간", "분", "초"};
        
        Calendar time1 = Calendar.getInstance();
        Calendar time2 = Calendar.getInstance();

        time1.set(Calendar.HOUR_OF_DAY, 10);
        time1.set(Calendar.MINUTE, 20);
        time1.set(Calendar.SECOND, 30);

        time2.set(Calendar.HOUR_OF_DAY, 20);
        time2.set(Calendar.MINUTE, 30);
        time2.set(Calendar.SECOND, 10);

        System.out.println(String.format("time1 : %d시 %d분 %d초", 
            time1.get(Calendar.HOUR_OF_DAY), time1.get(Calendar.MINUTE), time1.get(Calendar.SECOND)));

        System.out.println(String.format("time2 : %d시 %d분 %d초", 
            time2.get(Calendar.HOUR_OF_DAY), time2.get(Calendar.MINUTE), time2.get(Calendar.SECOND)));

        long diff = Math.abs(time2.getTimeInMillis() - time1.getTimeInMillis()) / 1000;
        System.out.print(String.format("time1과 time2의 차이는 %d 초 입니다.", diff));

        String tmp = "";
        for(int i = 0; i < TIME_UNIT.length; i++) {
            tmp += diff/TIME_UNIT[i] + TIME_UNIT_NAME[i];
            diff %= TIME_UNIT[i];
        }
        System.out.println("시분초로 변환하면 " + tmp + "입니다.");

        Calendar add1 = Calendar.getInstance();
        add1.set(2015, 7, 31);
        System.out.println(toString(add1));

        add1.add(Calendar.MONTH, 1);
        System.out.println(toString(add1));

        add1.add(Calendar.MONTH, -2);
        System.out.println(toString(add1));
    }

    public static String toString(Calendar date) {
        return String.format("%d년 %d월 %d일", 
            date.get(Calendar.YEAR), date.get(Calendar.MONTH) + 1, date.get(Calendar.DATE));
    }
}