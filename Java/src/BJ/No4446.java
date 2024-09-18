package BJ;
// ROT13

import java.util.Scanner;

public class No4446 {

    private static final String VOWELS = "aiyeou";
    private static final String CONSONANTS = "bkxznhdcwgpvjqtsrlmf";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            System.out.println(decodeROT13(line));
        }
    }

    public static String decodeROT13(String input) {
        StringBuilder result = new StringBuilder();

        for (char c : input.toCharArray()) {
            if (Character.isLetter(c)) {
                char decodedChar = decodeChar(c);
                result.append(decodedChar);
            } else {
                result.append(c);
            }
        }

        return result.toString();
    }

    private static char decodeChar(char c) {
        boolean isUpperCase = Character.isUpperCase(c);
        char lowerC = Character.toLowerCase(c);

        int index;
        if ((index = VOWELS.indexOf(lowerC)) != -1) {
            char decoded = VOWELS.charAt((index + 3) % VOWELS.length());
            return isUpperCase ? Character.toUpperCase(decoded) : decoded;
        } else if ((index = CONSONANTS.indexOf(lowerC)) != -1) {
            char decoded = CONSONANTS.charAt((index + 10) % CONSONANTS.length());
            return isUpperCase ? Character.toUpperCase(decoded) : decoded;
        }

        return c;
    }
}
