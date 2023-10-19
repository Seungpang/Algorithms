package BJ;
// 생태학

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.DecimalFormat;
import java.util.Map;
import java.util.TreeMap;

public class No4358 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Map<String, Integer> treeCounts = new TreeMap<>();
        int totalTreeCount = 0;

        String treeName = br.readLine();
        while (true) {
            treeCounts.put(treeName, treeCounts.getOrDefault(treeName, 0) + 1);
            totalTreeCount++;

            treeName = br.readLine();
            if (treeName == null || treeName.length() == 0) {
                break;
            }
        }

        DecimalFormat df = new DecimalFormat("0.0000");
        for (Map.Entry<String, Integer> entry : treeCounts.entrySet()) {
            double percentage = (double) entry.getValue() / totalTreeCount * 100;
            System.out.println(entry.getKey() + " " + df.format(percentage));
        }
    }
}
