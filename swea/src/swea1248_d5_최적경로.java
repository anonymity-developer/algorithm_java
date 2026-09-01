import java.io.*;
import java.util.*;

public class swea1248_d5_최적경로 {

    static int N;
    static int[][] customers;
    static boolean[] visited;
    static int companyX, companyY;
    static int homeX, homeY;
    static int answer;
    static int getDistance(int x1, int y1, int x2, int y2) {
        return Math.abs(x1 - x2) + Math.abs(y1 - y2);
    }

    static void dfs(int depth, int x, int y, int dist) {
        if (dist >= answer) {
            return;
        }
        if (depth == N) {
            dist += getDistance(x, y, homeX, homeY);
            answer = Math.min(answer, dist);
            return;
        }

        for (int i = 0; i < N; i++) {
            if (visited[i]) {
                continue;
            }
            visited[i] = true;
            int nextDist = dist +
                    getDistance(x, y, customers[i][0], customers[i][1]);
            dfs(
                    depth + 1,
                    customers[i][0],
                    customers[i][1],
                    nextDist
            );
            visited[i] = false;
        }
    }

    public static void main(String[] args) throws Exception {
    	
//    	System.setIn(new FileInputStream("res/swea1248/input.txt"));

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int T = Integer.parseInt(br.readLine());

        for (int tc = 1; tc <= T; tc++) {
            N = Integer.parseInt(br.readLine());
            st = new StringTokenizer(br.readLine());
            companyX = Integer.parseInt(st.nextToken());
            companyY = Integer.parseInt(st.nextToken());
            homeX = Integer.parseInt(st.nextToken());
            homeY = Integer.parseInt(st.nextToken());
            customers = new int[N][2];

            for (int i = 0; i < N; i++) {
                customers[i][0] = Integer.parseInt(st.nextToken());
                customers[i][1] = Integer.parseInt(st.nextToken());
            }
            visited = new boolean[N];
            answer = Integer.MAX_VALUE;
            dfs(0, companyX, companyY, 0);
            System.out.println("#" + tc + " " + answer);
        }
    }
}
