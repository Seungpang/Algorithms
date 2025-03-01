package BJ;
// 디지털 티비

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class No2816 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String[] channels = new String[n];
        for (int i = 0; i < n; i++) {
            channels[i] = br.readLine();
        }

        StringBuilder sb = new StringBuilder();
        int pointer = 0;

        while (!channels[pointer].equals("KBS1")) {
            pointer++;
            sb.append("1");
        }

        while (pointer > 0) {
            String temp = channels[pointer];
            channels[pointer] = channels[pointer - 1];
            channels[pointer - 1] = temp;
            pointer--;
            sb.append("4");
        }

        if (channels[1].equals("KBS2")) {
            System.out.println(sb);
            return;
        }

        pointer = 0;
        while (!channels[pointer].equals("KBS2")) {
            pointer++;
            sb.append("1");
        }

        while (pointer > 1) {
            String temp = channels[pointer];
            channels[pointer] = channels[pointer - 1];
            channels[pointer - 1] = temp;
            pointer--;
            sb.append("4");
        }

        System.out.println(sb);
    }
}
