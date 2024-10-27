import java.util.Scanner;

public class Main {
    static final String[] arrayValidNumbers = {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10",
                                                "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX", "X",
                                                "XX", "XXX", "XL", "L", "LX", "LXX", "LXXX", "XC", "C"};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] arrayInputString = sc.nextLine().split(" ");
        System.out.println(calc(arrayInputString));
        }

        static String calc(String[] arrayInput) {
        if(arrayInput.length != 3)
            throw new RuntimeException("Формат математической операции не удовлетворяет заданию.");
        String firstNumberStr = null, secondNumberStr = null;
        int firstNumberInt = -1, secondNumberInt = -1, firstStrToNum = -1, secondStrToNum = -1;
            for (int i = 0; i < arrayValidNumbers.length; i++) {
                if(arrayValidNumbers[i].equals(arrayInput[0]) && i > 10 && i < 21)
                    firstNumberStr = Integer.toString(firstStrToNum = i - 10);
                else if (arrayValidNumbers[i].equals(arrayInput[0]) && i <= 11)
                    firstNumberInt = i;
                if(arrayValidNumbers[i].equals(arrayInput[2]) && i > 10 && i < 21)
                    secondNumberStr = Integer.toString(secondStrToNum = i - 10);
                else if (arrayValidNumbers[i].equals(arrayInput[2]) && i <= 11)
                    secondNumberInt = i;
            }
            if((firstNumberInt != -1 && secondNumberStr != null) || (firstNumberStr != null && secondNumberInt != -1))
                throw new RuntimeException("Используются одновременно разные системы счисления.");
            if(((firstNumberStr == null || secondNumberStr == null) && (firstNumberInt == -1 && secondNumberInt == -1)) || ((firstNumberInt == -1 || secondNumberInt == -1) && (firstNumberStr == null && secondNumberStr == null)))
                throw new RuntimeException("Введены некорректные данные.");

            System.out.println(firstStrToNum + " " + secondStrToNum);
        return "ERROR";

    }
}
