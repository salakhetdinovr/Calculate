import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Calculate2 {

    public static void main(String[] args) throws Exception {

        Scanner sc = new Scanner(System.in);
        System.out.println("Введите пример:");
        calc(sc.nextLine());

    }

    public static String calc(String input) throws Exception{

        String[] symbols = input.split(" ");
        if (symbols.length < 3) {
            throw new Exception("строка не является математической операцией");
        }
        if (symbols.length > 3) {
            throw new Exception("формат математической операции не удовлетворяет заданию - два операнда и один оператор (+, -, /, *)");
        }

        ArrayList<String> list = new ArrayList<>();
        list.add("I");
        list.add("II");
        list.add("III");
        list.add("IV");
        list.add("V");
        list.add("VI");
        list.add("VII");
        list.add("VIII");
        list.add("IX");
        list.add("X");

        String[] roman = {"I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX", "X", "XI", "XII", "XIII", "XIV",
                "XV", "XVI", "XVII", "XVIII", "XIX", "XX", "XXI", "XXII", "XXIII", "XXIV", "XXV", "XXVI", "XXVII",
                "XXVIII", "XXIX", "XXX", "XXXI", "XXXII", "XXXIII", "XXXIV", "XXXV", "XXXVI", "XXXVII", "XXXVIII",
                "XXXIX", "XL", "XLI", "XLII", "XLIII", "XLIV", "XLV", "XLVI", "XLVII", "XLVIII", "XLIX", "L", "LI",
                "LII", "LIII", "LIV", "LV", "LVI", "LVII", "LVIII", "LIX", "LX", "LXI", "LXII", "LXIII", "LXIV",
                "LXV", "LXVI", "LXVII", "LXVIII", "LXIX", "LXX", "LXXI", "LXXII", "LXXIII", "LXXIV", "LXXV",
                "LXXVI", "LXXVII", "LXXVIII", "LXXIX", "LXXX", "LXXXI", "LXXXII", "LXXXIII", "LXXXIV", "LXXXV",
                "LXXXVI", "LXXXVII", "LXXXVIII", "LXXXIX", "XC", "XCI", "XCII", "XCIII", "XCIV", "XCV", "XCVI",
                "XCVII", "XCVIII", "XCIX", "C"};

        String[] arabian = {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10"};

        int sum;
        int x = 0;
        int y = 0;
        String str;
        int sum2;

        try {
            int index0 = list.indexOf(symbols[0]);
            int index2 = list.indexOf(symbols[2]);
            if (symbols[0].equals(list.get(index0)) && symbols[2].equals(list.get(index2))) {
                for (int i = 0; i < roman.length; i++) {
                    if (symbols[0].equals(roman[i])) {
                        x = Arrays.asList(roman).indexOf(roman[i]) + 1;
                    }
                    for (int t = 0; t < roman.length; t++) {
                        if (symbols[2].equals(roman[t])) {
                            y = Arrays.asList(roman).indexOf(roman[t]) + 1;
                        }
                        if (symbols[0].equals(roman[i]) && symbols[2].equals(roman[t]) && symbols[1].equals("+")) {
                            sum2 = x + y;
                            str = roman[sum2 - 1];
                            System.out.println(str);
                            break;
                        } else if (symbols[0].equals(roman[i]) && symbols[2].equals(roman[t]) && symbols[1].equals("-")) {
                            try {
                                sum2 = x - y;
                                str = roman[sum2 - 1];
                                System.out.println(str);
                            }catch (IndexOutOfBoundsException m){
                                throw new Exception("в римской системе нет отрицательных чисел");
                            }
                            break;
                        } else if (symbols[0].equals(roman[i]) && symbols[2].equals(roman[t]) && symbols[1].equals("*")) {
                            sum2 = x * y;
                            str = roman[sum2 - 1];
                            System.out.println(str);
                            break;
                        } else if (symbols[0].equals(roman[i]) && symbols[2].equals(roman[t]) && symbols[1].equals("/")) {
                            sum2 = x / y;
                            str = roman[sum2 - 1];
                            System.out.println(str);
                            break;
                        }
                    }
                }
            }
        } catch (IndexOutOfBoundsException n) {
            try{
                int a = Integer.parseInt(symbols[0]);
                int b = Integer.parseInt(symbols[2]);
                if ((a >= 1 && a <= 10) && (b >= 1 && b <= 10)) {
                    for (int j = 0; j < arabian.length; j++) {
                        if (symbols[0].equals(arabian[j])) {
                            x = Arrays.asList(arabian).indexOf(arabian[j]) + 1;
                            for (int q = 0; q < arabian.length; q++) {
                                if (symbols[2].equals(arabian[q])) {
                                    y = Arrays.asList(arabian).indexOf(arabian[q]) + 1;
                                }
                                if (symbols[0].equals(arabian[j]) && symbols[2].equals(arabian[q]) && symbols[1].equals("+")) {
                                    sum = x + y;
                                    System.out.println(sum);
                                    break;
                                } else if (symbols[0].equals(arabian[j]) && symbols[2].equals(arabian[q]) && symbols[1].equals("-")) {
                                    sum = x - y;
                                    System.out.println(sum);
                                    break;
                                } else if (symbols[0].equals(arabian[j]) && symbols[2].equals(arabian[q]) && symbols[1].equals("*")) {
                                    sum = x * y;
                                    System.out.println(sum);
                                    break;
                                } else if (symbols[0].equals(arabian[j]) && symbols[2].equals(arabian[q]) && symbols[1].equals("/")) {
                                    sum = x / y;
                                    System.out.println(sum);
                                    break;
                                }
                            }
                        }
                    }
                }
            }catch (NumberFormatException v){
                throw new Exception("используются одновременно разные системы счисления");
            }
        }
        return input;
    }
}