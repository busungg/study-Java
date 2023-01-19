import java.util.*;

class twoComplement {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("정수를 하나 입력해주세요. >");
        String input = scanner.nextLine();

        String binaryString = Integer.toBinaryString(Integer.parseInt(input));

        System.out.println("입력내용 : " + input);
        System.out.println("2진수 입력내용 : " + binaryString + " " + binaryString.length());

        int idx = 0;
        char[] oneComplementArray = new char[binaryString.length()];
        for(char binaryChar : binaryString.toCharArray()) {
            if(binaryChar == '1') {
                oneComplementArray[idx] = '0';
            } else {
                oneComplementArray[idx] = '1';
            }

            idx++;
        }

        System.out.print("1의 보수 : ");
        for(char binaryChar : oneComplementArray) {
            System.out.print(binaryChar);
        }
        System.out.print('\n');
        
        String twoComplementStr = null;
        char[] twoComplementArray = new char[binaryString.length()];
        for(int i = oneComplementArray.length() - 1; i >= 0; i--) {
            if(oneComplementArray[i] + 1 == 2) {
                oneComplementArray[i] = '0';
            } else {
                oneComplementArray[i] = '1';
            }
        }
    }

    public static String twoComplement(char[] oneComplementArray) {
        
    }
}