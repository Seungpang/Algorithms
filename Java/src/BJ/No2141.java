package BJ;
// 우체국

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class No2141 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        List<Village> villages = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int a = Integer.parseInt(st.nextToken());
            villages.add(new Village(x, a));
        }

        Collections.sort(villages);

        long totalPopulation = 0;
        for (Village village : villages) {
            totalPopulation += village.population;
        }

        long medianPopulation = (totalPopulation + 1) / 2;

        long cumulativePopulation = 0;
        for (Village village : villages) {
            cumulativePopulation += village.population;
            if (cumulativePopulation >= medianPopulation) {
                System.out.println(village.position);
                break;
            }
        }
    }

    static class Village implements Comparable<Village> {
        int position;
        int population;

        Village(int position, int population) {
            this.position = position;
            this.population = population;
        }

        @Override
        public int compareTo(Village other) {
            return Integer.compare(this.position, other.position);
        }
    }
}
