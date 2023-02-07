package ch15.code;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.SequenceInputStream;
import java.util.Arrays;
import java.util.Vector;

public class SequenceInputStreamEx {
    public static void main(String[] args) {
        byte[] arr1 = {0,1,2};
        byte[] arr2 = {3,4,5};
        byte[] arr3 = {6,7,8};
        byte[] arr4 = {9,10,11};
        byte[] outSrc = null;

        Vector<ByteArrayInputStream> v = new Vector<ByteArrayInputStream>();
        v.add(new ByteArrayInputStream(arr1));
        v.add(new ByteArrayInputStream(arr2));
        v.add(new ByteArrayInputStream(arr3));
        v.add(new ByteArrayInputStream(arr4));

        SequenceInputStream input = new SequenceInputStream(v.elements());
        ByteArrayOutputStream output = new ByteArrayOutputStream();

        int data = 0;
        try {
            while((data = input.read()) != -1) {
                output.write(data); //void Write(int b)
            }
        } catch(IOException ex) {}

        outSrc = output.toByteArray();
        System.out.println(Arrays.toString(outSrc));
    }
}
