package BJ;
//시뮬레이션 구현
//LCD Test

import java.util.Scanner;

public class No2290 {

    static final int[][] num = {
        {1, 1, 1, 0, 1, 1, 1},
        {0, 0, 1, 0, 0, 1, 0},
        {1, 0, 1, 1, 1, 0, 1},
        {1, 0, 1, 1, 0, 1, 1},
        {0, 1, 1, 1, 0, 1, 0},
        {1, 1, 0, 1, 0, 1, 1},
        {1, 1, 0, 1, 1, 1, 1},
        {1, 0, 1, 0, 0, 1, 0},
        {1, 1, 1, 1, 1, 1, 1},
        {1, 1, 1, 1, 0, 1, 1}
    };

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int s = 2;
        String n = "1234567890";
//        int s = sc.nextInt();
//        String n = sc.next();
        int m = n.length();
        for (int i=0; i<5; i++) {
            if (i==0 || i==2 || i==4) {
                for (int j=0; j<m; j++) {
                    int now = n.charAt(j) - '0';
                    if (j != 0) {
                        System.out.print(" ");
                    }
                    System.out.print(" ");
                    if ((i==0 && num[now][0] == 1) || (i==2 && num[now][3] == 1) || (i==4 && num[now][6] == 1)) {
                        for (int k=0; k<s; k++) {
                            System.out.print("-");
                        }
                    } else {
                        for (int k=0; k<s; k++) {
                            System.out.print(" ");
                        }
                    }
                    System.out.print(" ");
                }
                System.out.println();
            } else {
                for (int l=0; l<s; l++) {
                    for (int j=0; j<m; j++) {
                        int now = n.charAt(j) - '0';
                        if (j != 0) {
                            System.out.print(" ");
                        }
                        if ((i==1 && num[now][1] == 1) || (i==3 && num[now][4] == 1)) {
                            System.out.print("|");
                        } else {
                            System.out.print(" ");
                        }
                        for (int k=0; k<s; k++) {
                            System.out.print(" ");
                        }
                        if ((i==1 && num[now][2] == 1) || (i==3 && num[now][5] == 1)) {
                            System.out.print("|");
                        } else {
                            System.out.print(" ");
                        }
                    }
                    System.out.println();
                }
            }
        }
    }
}
