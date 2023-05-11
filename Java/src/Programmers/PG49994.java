package Programmers;
// 방문 길이
public class PG49994 {

    public static void main(String[] args) {
        final PG49994 a = new PG49994();
        System.out.println(a.solution("ULURRDLLU"));//7
    }

    int[][] dd = {{0, -1}, {-1, 0}, {1, 0}, {0 ,1}};

    public int solution(String dirs) {
        int answer = 0;
        boolean[][][] visited = new boolean[11][11][4];
        int x = 5;
        int y = 5;
        for (int i=0; i<dirs.length(); i++) {
            int dir = 0;
            if (dirs.charAt(i) == 'L') {
                dir = 0;
            } else if(dirs.charAt(i) == 'U') {
                dir = 1;
            } else if (dirs.charAt(i) == 'D') {
                dir = 2;
            } else {
                dir = 3;
            }

            int nx = x + dd[dir][0];
            int ny = y + dd[dir][1];
            if(nx<0||nx >=11||ny<0||ny>=11)continue;

            if (!visited[x][y][dir] && !visited[nx][ny][3-dir]) {
                visited[x][y][dir] = true;
                visited[nx][ny][3-dir] = true;
                answer++;
            }
            x = nx;
            y = ny;
        }
        return answer;
    }
}
