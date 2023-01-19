package ch9;

import java.util.*;
import static java.util.Objects.*;
import static java.lang.System.*;

/**
 * Object
 */
public class Object {

    public static void main(String[] args) {
        String[][] str2D = new String[][]{{"aaa", "bbb"}, {"AAA", "BBB"}};
        String[][] str2D_2 = new String[][]{{"aaa", "bbb"}, {"AAA", "BBB"}};

        out.print("str2D = {");
        for(String[] tmp : str2D) {
            out.print(Arrays.toString(tmp));
        }
        out.println("}");

        out.print("str2D_2 = {");
        for(String[] tmp : str2D_2) {
            out.print(Arrays.toString(tmp));
        }
        out.println("}");

        out.println("equals(str2d, str2d_2)=" + Objects.equals(str2D, str2D_2));
        out.println("deepEquals(str2d, str2d_2)=" + Objects.deepEquals(str2D, str2D_2));
        out.println("isNull(null)="+isNull(null));
        out.println("nonNull(null)="+nonNull(null));
        out.println("hashCode(null)="+Objects.hashCode(null));
        out.println("toString(null)="+Objects.toString(null));
        out.println("toString(null, \"\")="+Objects.toString(null, ""));

        Comparator c = String.CASE_INSENSITIVE_ORDER;
        out.println("compare(\"aa\", \"bb\")="+compare("aa", "bb", c));
        out.println("compare(\"aa\", \"bb\")="+compare("bb", "aa", c));
        out.println("compare(\"aa\", \"bb\")="+compare("ab", "AB", c));
    }
    
}