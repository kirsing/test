package passwordgen;

import java.util.Random;
import java.util.Scanner;

public class PasswordGeneratorApplication {
    private static final String SPECIAL_CHARS = "~@#$%^&*()-+=";
    private static final String CAPITALS_LETTERS = "QWERTYUIOPASDFGHJKLZXCVBNM";
    private static final String LOWER_CASE_LETTERS = "qwertyuiopasdfghjklzxcvbnm";
    private static final Scanner scanner = new Scanner(System.in);
    private static final Random random = new Random();


    public static void main(String[] args) {
        System.out.print("Enter length of password which you want to get generated (between 8 and 12): ");
        int length = scanner.nextInt();
       while(true) {
           if (length >= 8 && length <= 12) {
               String password = generatePassword(length);
               System.out.println(password);
               break;
           } else {
               System.out.println("Password length must be between 8 and 12");
               System.out.println("Enter length one more time: ");
               length = scanner.nextInt();
           }
       }
    }

    private static String generatePassword(int length) {
        StringBuilder sb = new StringBuilder();
        int randomCase;
        for (int i = 0; i < length; i++) {
            randomCase = (int) (2 * Math.random());
            switch (randomCase) {
                case 0:
                    sb.append(SPECIAL_CHARS.charAt(random.nextInt(SPECIAL_CHARS.length())));
                case 1:
                    sb.append(CAPITALS_LETTERS.charAt(random.nextInt(CAPITALS_LETTERS.length())));
                case 2:
                    sb.append(LOWER_CASE_LETTERS.charAt(random.nextInt(LOWER_CASE_LETTERS.length())));
            }
        }
        return sb.toString();
    }
}
