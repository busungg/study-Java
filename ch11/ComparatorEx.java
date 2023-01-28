package ch11;

import java.util.Arrays;
import java.util.Comparator;

public class ComparatorEx {
    public static void main(String[] args) {
        String [] strArr = {"cat", "Dog", "lion", "tiger"};

        Arrays.sort(strArr);
        System.out.println(Arrays.toString(strArr));

        Arrays.sort(strArr, String.CASE_INSENSITIVE_ORDER);
        System.out.println(Arrays.toString(strArr));

        Arrays.sort(strArr, new Descending());
        System.out.println(Arrays.toString(strArr));
    }
}

class Descending implements Comparator {

    @Override
    public int compare(Object o1, Object o2) {
        // TODO Auto-generated method stub
        if(o1 instanceof Comparable && o2 instanceof Comparable) {
                Comparable c1 = (Comparable)o1;
                Comparable c2 = (Comparable)o2;
                return c1.compareTo(o2) * -1;
        }

        return -1;
    }

}