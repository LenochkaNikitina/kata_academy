import java.util.Scanner;
public class Main {
    public static void main(String[] args) throws Exception {
        Scanner input = new Scanner(System.in);
        System.out.println("Введите выражение");
        String expression = input.nextLine();
        calc(expression);
    }
    public static String calc(String expression) throws Exception {
        int len = expression.length();
        char sign = ' ';
        int ind =20, ind1 = 0;
        int number =0, number1 = 0, result = 0;
        for(int i = 0; i < len; i++){
            char temp = expression.charAt(i);
            if (temp == '/' || temp =='+' || temp == '*' || temp =='-'){
                sign = temp;
                ind = i;
                break;
            }
            else {
                throw new Exception("Нет такой арифметической операции.");
            }
        }
        String[] romanic = {"I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX", "X", "XI", "XII", "XIII", "XIV", "XV", "XVI", "XVII", "XVIII", "XIX", "XX", "XXI", "XXII", "XIII", "XXIV", "XXV", "XXVI", "XXVII", "XXVIII", "XXIX", "XXX", "XXXI", "XXXII", "XXXIII", "XXXIV", "XXXV", "XXXVI", "XXXVII", "XXXVIII", "XXXIX", "XL", "XLI", "XLII", "XLIII", "XLIV", "XLV", "XLVI", "XLVII", "XLVIII", "XLIX", "L", "LI", "LII", "LIII", "LIV", "LV", "LVI", "LVII", "LVIII", "LIX", "LX", "VXI", "LXII", "LXIII", "LXIV", "LXV", "LXVI", "LXVII", "LXVIII", "LXVIX", "LXX", "LXXI", "LXXII", "LXXIII", "LXXIV", "LXXV", "LXXVI", "LXXVII", "LXXVIII", "LXXIX", "LXXX", "LXXXI", "LXXXII", "LXXXIII", "LXXXIV", "LXXXV", "LXXXVI", "LXXXVII", "LXXXVIII", "LXXXIX", "XC", "XCI", "XCII", "XCIII", "XCIV", "XCV", "XCVI", "XCVII", "XCVIII", "XCIX", "C"};
        String roman1 = "", roman2 = "";
        boolean isRoman1 = false, isRoman2 = false;
        for(int i = 0; i<ind; i++){
            char temp = expression.charAt(i);
            if (temp <='9' && temp >'0') {
                number = Character.digit(temp, 10);
                if(i < len - 1 && expression.charAt(i+1) >= '0' && expression.charAt(i+1) <='9'){
                    number = number * 10 + Character.digit(expression.charAt(i+1), 10);
                    ind1 = i+2;
                    break;
                }
            }else if (temp == 'I' || temp == 'V' || temp == 'X'){
                roman1 = roman1 + temp;
                isRoman1 = true;
            }
        }

        if((number < 1 || number > 10 || (expression.charAt(ind1) < '9' && expression.charAt(ind1) > '0')) && !isRoman1){
            throw new Exception("Число должно быть от 1 до 10");
        }
        for(int i = ind+1; i<len; i++) {
            char temp = expression.charAt(i);
            if (temp <= '9' && temp > '0') {
                number1 = Character.digit(temp, 10);
                if (i < len - 1 && expression.charAt(i + 1) >= '0' && expression.charAt(i+1) <='9') {
                    number1 = number1 * 10 + Character.digit(expression.charAt(i+1), 10);
                    ind1 = i+2;
                    break;
                }
            } else if (temp == 'I' || temp == 'V' || temp == 'X') {
                roman2 = roman2 + temp;
                isRoman2 = true;
            }
        }
        if((number1 < 1 || number1 > 10 || (expression.charAt(ind1) < '9' && expression.charAt(ind1) > '0')) && !isRoman2){
            throw new Exception("Число должно быть от 1 до 10.");
        }
        for (int i=0; i<10; i++){
            if (roman1.equals(romanic[i])){
                number = i+1;
                break;
            }
        }
        for (int i=0; i<10; i++){
            if (roman2.equals(romanic[i])){
                number1 = i+1;
                break;
            }
        }
        switch (sign){
            case '+':
                result = (number+number1);
                break;
            case '-':
                result = (number-number1);
                break;
            case '/':
                result = (number/number1);
                break;
            case '*':
                result = (number*number1);
                break;
        }
        if(isRoman1 && !isRoman2 || !isRoman1 && isRoman2){
            throw new Exception("Оба числа должны быть в одной системе счисления.");
        }
        if (result < 0 && isRoman1){
            throw new Exception("В римской системе счисления нет отрицательных чисел.");
        }
        if(!isRoman1 && !isRoman2) {
            System.out.println(result);
        }
        else{
            System.out.println(romanic[result-1]);
        }
        return "OK";
    }
}