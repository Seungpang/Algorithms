package Programmers;

public class PG181187 {

    public static void main(String[] args) {
        final PG181187 pg181187 = new PG181187();
        System.out.println(pg181187.solution(2, 3));
    }

    public long solution(int r1, int r2) {
        long answer = 0;

        long x1 = (long)Math.pow(r1,2);
        long x2 = (long)Math.pow(r2,2);

        //y^2= r^2-x^2
        long side =0;
        for (long i=0; i<=r2; i++){
            long y2 = (long)Math.sqrt(x2-Math.pow(i,2));
            long y1 = (long)Math.sqrt(x1-Math.pow(i,2));

            if(Math.sqrt((x1-Math.pow(i,2)))%1==0){
                System.out.println("x1 = " + x1 + " i = " + i);
                side++;
            }
            System.out.println("y2 = " + y2 + " y1 = " + y1);
            answer+=(y2-y1)*4;
        }

        answer+=side*4-4;


        return answer;
    }
}
