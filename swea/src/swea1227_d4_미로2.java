import java.io.*;
import java.util.*;

public class swea1227_d4_미로2 {

	static int[] dx = { -1, 0, 1, 0 };
	static int[] dy = { 0, 1, 0, -1 };
	static int startX, startY, find;
	static int[][] map;
	static boolean[][] visited;

	public static void dfs(int x, int y) {

		if (find == 1)
			return;

		visited[x][y] = true;

		for (int i = 0; i < 4; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];
			if (check(nx, ny) && !visited[nx][ny]) {
				if (map[nx][ny] == 3) {
					find = 1;
					return;
				} else if (map[nx][ny] == 0) {
					dfs(nx, ny);
				}
			}
		}
	}

	public static boolean check(int x, int y) {
		return x >= 0 && y >= 0 && x < 100 && y < 100;
	}

	public static void main(String[] args) throws Exception {
//		System.setIn(new FileInputStream("res/swea1227/input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb;

		for (int tc = 1; tc <= 10; tc++) {
			br.readLine(); // tc 번호
			find = 0;
			map = new int[100][100];
			visited = new boolean[100][100];
			for (int i = 0; i < 100; i++) {
				String line = br.readLine(); // 공백없는 문자열
				for (int j = 0; j < 100; j++) {
					int temp = line.charAt(j) - '0';
					// 벽 1, 길 0, 출발점 2, 도착점 3
					if (temp == 2) {
						startX = i;
						startY = j;
					}
					map[i][j] = temp;
				}
			}
			dfs(startX, startY);

			sb = new StringBuilder();
			sb.append("#").append(tc).append(" ").append(find);
			System.out.println(sb);
		}

		br.close();
	}
}


//import java.io.*;
//import java.util.*;
//
//public class swea1227_d4_미로2 {
//
//    static int[] dx = {-1, 0, 1, 0};
//    static int[] dy = {0, 1, 0, -1};
//
//    static int startX, startY, find;
//    static int[][] map;
//    static boolean[][] visited;
//
//    public static void bfs(int x, int y) {
//    		Queue<int[]> q = new ArrayDeque<>();
//    		q.offer(new int[] {x, y});
//    		visited[x][y] = true;
//    		while (!q.isEmpty()) {
//    			int cur[] = q.poll();
//    			for(int i=0; i<4; i++) {
//    				int nx = cur[0] + dx[i];
//    				int ny = cur[1] + dy[i];
//                    if (!check(nx, ny) || visited[nx][ny]) continue;
//                    if (map[nx][ny] == 3) {
//                        find = 1;
//                        return;
//                    }
//                    if (map[nx][ny] == 0) {
//                        visited[nx][ny] = true;
//                        q.offer(new int[]{nx, ny});
//                    }
// 
//    			}
//    		}
//    }
//
//    public static boolean check(int x, int y) {
//        return x >= 0 && y >= 0 && x < 100 && y < 100;
//    }
//
//    public static void main(String[] args) throws Exception {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        StringBuilder sb;
//
//        for (int tc = 1; tc <= 10; tc++) {
//            br.readLine();
//
//            find = 0;
//            map = new int[100][100];
//            visited = new boolean[100][100];
//
//            for (int i = 0; i < 100; i++) {
//                String line = br.readLine();
//                for (int j = 0; j < 100; j++) {
//                    map[i][j] = line.charAt(j) - '0';
//                    if (map[i][j] == 2) {
//                        startX = i;
//                        startY = j;
//                    }
//                }
//            }
//
//            bfs(startX, startY);
//            sb = new StringBuilder();
//			  sb.append("#").append(tc).append(" ").append(find);
//			  System.out.println(sb);
//        }
//    }
//}

