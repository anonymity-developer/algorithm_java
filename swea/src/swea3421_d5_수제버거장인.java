import java.io.*;
import java.util.*;

public class swea3421_d5_수제버거장인 {

    static int N;
    static int[][] bannedList;
    static boolean[] selected;
    static int answer;
	
    public static void main(String[] args) throws Exception {

//        System.setIn(new FileInputStream("res/문제명/input.txt"));

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        for (int tc = 1; tc <= T; tc++) {
        	
            st = new StringTokenizer(br.readLine());
        	N = Integer.parseInt(st.nextToken()); // 재료 수 
        	int M = Integer.parseInt(st.nextToken()); // 금지 짝 개수

            bannedList = new int[N][N];
            selected = new boolean[N];
            answer = 0;
        	
            for (int i = 0; i < M; i++) {
                st = new StringTokenizer(br.readLine());

                int a = Integer.parseInt(st.nextToken()) - 1;
                int b = Integer.parseInt(st.nextToken()) - 1;

                bannedList[a][b] = 1;
                bannedList[b][a] = 1;
        	}
        	
        	dfs(0);
        	
            sb.append("#").append(tc).append(" ").append(answer).append("\n");
        }
        
        System.out.print(sb);
    }
    
    static void dfs(int idx) {

        // 모든 재료를 선택할지 말지
        if (idx == N) {
            answer++;
            return;
        }

        // 1. 현재 재료를 선택하지 않는 경우
        dfs(idx + 1);

        // 2. 현재 재료를 선택하는 경우
        boolean possible = true;

        for (int i = 0; i < N; i++) {
            if (selected[i] && bannedList[idx][i] == 1) {
                possible = false;
                break;
            }
        }

        if (possible) {
            selected[idx] = true;
            dfs(idx + 1);
            selected[idx] = false;
        }
    }
}

