package BJ;
// 춤

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class No4836 {


    static List<Integer> dipIndex;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String dance = "";
        while ((dance = br.readLine()) != null) {
            List<Integer> errors = checkDance(dance);
            printResult(dance, errors);
        }
    }

    static List<Integer> checkDance(String dance) {
        List<Integer> errors = new ArrayList<>();
        boolean hasDip = dance.contains("dip");
        boolean hasTwirl = dance.contains("twirl");
        boolean startsWithJiggle = dance.startsWith("jiggle");
        boolean endsCorrectly = dance.endsWith("clap stomp clap");
        dipIndex = new ArrayList<>();

        String[] parts = dance.split(" ");
        for (int i = 0; i < parts.length; i++) {
            if (parts[i].equals("dip")) {
                if (!((i - 1 >= 0 && parts[i - 1].equals("jiggle")) || (i - 2 > 0 && parts[i - 2].equals("jiggle")) || (i + 1 < parts.length && parts[i + 1].equals("twirl")))) {
                    dipIndex.add(i);
                    errors.add(1);
                }
            }
        }

        if (!endsCorrectly) {
            errors.add(2);
        }

        if (hasTwirl && !dance.contains("hop")) {
            errors.add(3);
        }

        if (startsWithJiggle) {
            errors.add(4);
        }

        if (!hasDip) {
            errors.add(5);
        }

        return errors;
    }

    static void printResult(String dance, List<Integer> errorRules) {
        if (errorRules.isEmpty()) {
            System.out.println("form ok: " + dance);
        } else if (errorRules.size() == 1) {
            int ruleNumber = errorRules.get(0);
            if (ruleNumber == 1) {
                String[] parts = dance.split(" ");
                for (int i = 0; i < parts.length; i++) {
                    for (int idx : dipIndex) {
                        if (i == idx) {
                            parts[i] = "DIP";
                        }
                    }
                }

                dance = "";
                for (String part : parts) {
                    dance += part + " ";
                }
            }
            System.out.println("form error " + ruleNumber + ": " + dance);
        } else {
            StringBuilder sb = new StringBuilder("form errors ");
            String[] parts = dance.split(" ");
            for (int i = 0; i < errorRules.size() - 1; i++) {
                if (errorRules.get(i) == 1) {
                    for (int idx : dipIndex) {
                        parts[idx] = "DIP";
                    }
                }
                if (i == errorRules.size() - 2) {
                    sb.append(errorRules.get(i)).append(" ");
                } else {
                    sb.append(errorRules.get(i)).append(", ");
                }
            }
            dance = "";
            for (String part : parts) {
                dance += part + " ";
            }
            sb.append("and ").append(errorRules.get(errorRules.size() - 1)).append(": ").append(dance);
            System.out.println(sb);
        }
    }
}
