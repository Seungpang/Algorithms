package BJ;
// 이 구역의 승자는 누구야?!

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class No20154 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String K = sc.nextLine();
        int[] alpha = {3, 2, 1, 2, 3, 3, 3, 3, 1, 1, 3, 1, 3, 3, 1, 2, 2, 2, 1, 2, 1, 1, 2, 2, 2, 1};

        List<Integer> numbers = new ArrayList<>();
        for (char c : K.toCharArray()) {
            numbers.add(alpha[c - 'A']);
        }

        while (numbers.size() > 1) {
            List<Integer> temp = new ArrayList<>();
            for (int i = 0; i < numbers.size() - 1; i += 2) {
                temp.add((numbers.get(i) + numbers.get(i + 1)) % 10);
            }
            if (numbers.size() % 2 != 0) {
                temp.add(numbers.get(numbers.size() - 1));
            }
            numbers = temp;
        }

        if (numbers.get(0) % 2 == 1) {
            System.out.println("I'm a winner!");
        } else {
            System.out.println("You're the winner?");
        }
    }
}
