import java.util.Scanner;
public class Main {
    static final String[] arrayValidNumbers =  {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10",
                                                "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX", "X",
                                                "XX", "XXX", "XL", "L", "LX", "LXX", "LXXX", "XC"};
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] arrayInputString = sc.nextLine().split(" ");
        System.out.println(calc(arrayInputString));
    }
    static String calc(String[] arrayInput) {
        if(arrayInput.length < 3)
            throw new RuntimeException("Строка не является математической операцией.");
        if(arrayInput.length != 3)
            throw new RuntimeException("Формат математической операции не удовлетворяет заданию.");
        int firstArab = -1, secondArab = -1, firstRome = -1, secondRome = -1, num1 = 0, num2 = 0;
        for (int i = 0; i < arrayValidNumbers.length; i++) {
            if(arrayValidNumbers[i].equals(arrayInput[0]) && i > 10 && i < 21)
                firstRome = num1 = i - 10;
            else if (arrayValidNumbers[i].equals(arrayInput[0]) && i <= 11)
                firstArab = num1 = i;
            if(arrayValidNumbers[i].equals(arrayInput[2]) && i > 10 && i < 21)
                secondRome = num2 = i - 10;
            else if (arrayValidNumbers[i].equals(arrayInput[2]) && i <= 11)
                secondArab = num2 = i;
        }
        if((firstArab != -1 && secondRome != -1) || (firstRome != -1 && secondArab != -1))
            throw new RuntimeException("Используются одновременно разные системы счисления.");
        if(((firstRome == -1 || secondRome == -1) && (firstArab == -1 && secondArab == -1)) || ((firstArab == -1 || secondArab == -1) && (firstRome == -1 && secondRome == -1)))
            throw new RuntimeException("Введены некорректные данные.");
        if (num2 == 0 && arrayInput[1].equals("/"))
            throw new RuntimeException("Пифагор и Фридрих Гаусс уже выехали за тобой!");

        int result = switch (arrayInput[1]) {
            case "/" -> (num1 / num2);
            case "*" -> (num1 * num2);
            case "-" -> (num1 - num2);
            case "+" -> (num1 + num2);
            default -> throw new RuntimeException("Строка не является математической операцией.");
        };
        if(firstRome != -1 && result < 0)
            throw new RuntimeException("В римской системе нет нуля и отрицательных чисел.");
        if (firstRome != -1) {
            String resultStr = "";
            if (result == 100)
                return "C";
            if (((result % 100) / 10) != 0)
                resultStr = arrayValidNumbers[((result % 100) / 10) + 19];
            if ((result % 10) != 0)
                resultStr += arrayValidNumbers[(result % 10) + 10];
            return resultStr;
        }
        return Integer.toString(result);
    }
}