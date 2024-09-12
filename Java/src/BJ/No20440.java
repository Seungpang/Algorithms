package BJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

public class No20440 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        List<Integer> timePoints = new ArrayList<>();
        List<int[]> mosquitos = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int TE = Integer.parseInt(st.nextToken());
            int TX = Integer.parseInt(st.nextToken());
            timePoints.add(TE);
            timePoints.add(TX);
            mosquitos.add(new int[]{TE, TX});
        }

        timePoints.sort(null);
        Map<Integer, Integer> compressed = new HashMap<>();
        for (int i = 0; i < timePoints.size(); i++) {
            compressed.put(timePoints.get(i), i);
        }

        int[] count = new int[timePoints.size() + 1];

        for (int[] mosquito : mosquitos) {
            int start = compressed.get(mosquito[0]);
            int end = compressed.get(mosquito[1]);
            count[start]++;
            count[end]--;
        }

        int maxCount = 0;
        int maxStart = 0;
        int maxEnd = 0;
        int currentCount = 0;
        boolean maxStartFound = false;

        for (int i = 0; i < count.length - 1; i++) {
            currentCount += count[i];
            if (currentCount > maxCount) {
                maxCount = currentCount;
                maxStart = i;
                maxEnd = i + 1;
                maxStartFound = true;
            } else if (currentCount == maxCount && maxStartFound) {
                maxEnd = i + 1;
            } else if (currentCount < maxCount) {
                maxStartFound = false;
            }
        }

        System.out.println(maxCount);
        System.out.println(timePoints.get(maxStart) + " " + timePoints.get(maxEnd));
    }
}
