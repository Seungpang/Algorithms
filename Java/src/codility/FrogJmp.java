package codility;

public class FrogJmp {

    public static void main(String[] args) {
        final FrogJmp frogJmp = new FrogJmp();
        System.out.println(frogJmp.solution(10, 85, 30)); //3
    }

    public int solution(int X, int Y, int D) {
        return (int) Math.ceil((Y - X) / (double) D);
    }
}
