import java.util.Arrays;
import java.util.Locale;

public class RomanToDecimal {


    public int romanToDecimal(String input){
        int sum = 0;
        int lastnumber = 0;
        for(int i = input.length()-1; i >= 0; i--){
            char ele = input.toLowerCase().charAt(i);
            switch (ele) {
                case 'i':
                    sum = charToDecimal(1,lastnumber,sum);
                    lastnumber = 1;
                    break;
                case 'v':
                    sum = charToDecimal(5,lastnumber,sum);
                    lastnumber = 5;
                    break;
                case 'x':
                    sum = charToDecimal(10,lastnumber,sum);
                    lastnumber = 10;
                    break;
                case 'l':
                    sum = charToDecimal(50,lastnumber,sum);
                    lastnumber = 50;
                    break;
                case 'c':
                    sum = charToDecimal(100,lastnumber,sum);
                    lastnumber = 100;
                    break;
                case 'd':
                    sum = charToDecimal(500,lastnumber,sum);
                    lastnumber = 500;
                    break;
                case 'm':
                    sum = charToDecimal(1000,lastnumber,sum);
                    lastnumber = 1000;
                    break;
            }
        }
        return sum;
    }

    private int charToDecimal(int value, int lastnumber, int sum) {
        return lastnumber > value ? sum-value : sum+value;
    }


}
