import java.util.*;
import java.util.stream.Collectors;

public class test2 {
    public static void main(String[] args) {
        int[][] needs = {{1, 0, 0}, {1, 1, 0}, {1, 1, 0}, {1, 0, 1}, {1, 1, 0}, {0, 1, 1}};
        int r = 2;
        test2 sol = new test2();
        System.out.println(sol.solution(needs, 2));
    }

    static int answer = 0, r;

    public int solution(int[][] needs, int r) {

        this.r = r;

        //DFS로 로봇 구매가 가능한 전체 경우의 수를 고려하여 검증
        Set availRobot = new HashSet<Integer>();
        dfs(needs, availRobot, 0, 0);
        System.out.println(availRobot);
        return answer;

    }



    private void dfs(int[][] needs, Set availRobot, int depth, int sumRobot) {

        if(depth >= needs[0].length) return;

        if(sumRobot == r) {
            int makeProductCount = 0;
            for(int i=0; i<needs.length; ++i) {
                makeProductCount++;
                for(int j=0; j<needs[i].length; ++j) {
                    if(needs[i][j]==1 && !availRobot.contains(j)) {
                        makeProductCount--;
                        break;
                    }
                }
            }

            if(makeProductCount > answer) {
                answer = makeProductCount;
            }
            System.out.println(makeProductCount);
            System.out.println("count===================");
            return;
        }

        availRobot.add(depth);
        dfs(needs, availRobot, depth+1, sumRobot+1);
        System.out.println(availRobot);
        System.out.println("===================");
        availRobot.remove(depth);
        dfs(needs, availRobot, depth+1, sumRobot);
    }
}

