import java.io.*;
import java.util.*;

public class swea1767_sample_프로세서연결하기 {

    static int N;
    static int[][] maxi;

    static List<int[]> cores;

    static int maxCore;
    static int minWire;

    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};

    public static void main(String[] args) throws Exception {

        // System.setIn(new FileInputStream("res/swea1767/input.txt"));

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        for (int tc = 1; tc <= T; tc++) {

            N = Integer.parseInt(br.readLine());

            maxi = new int[N][N];
            cores = new ArrayList<>();

            for (int i = 0; i < N; i++) {

                st = new StringTokenizer(br.readLine());

                for (int j = 0; j < N; j++) {

                    maxi[i][j] = Integer.parseInt(st.nextToken());

                    // 가장자리 코어는 이미 연결된 상태이므로 제외
                    if (maxi[i][j] == 1) {
                        if (i != 0 && i != N - 1 && j != 0 && j != N - 1) {
                            cores.add(new int[]{i, j});
                        }
                    }
                }
            }

            maxCore = 0;
            minWire = Integer.MAX_VALUE;

            dfs(0, 0, 0);

            sb.append("#")
              .append(tc)
              .append(" ")
              .append(minWire)
              .append("\n");
        }

        System.out.print(sb);
    }

    static void dfs(int idx, int connected, int wireLength) {

        // 모든 코어 처리 완료
        if (idx == cores.size()) {

            if (connected > maxCore) {
                maxCore = connected;
                minWire = wireLength;
            } else if (connected == maxCore) {
                minWire = Math.min(minWire, wireLength);
            }

            return;
        }

        int r = cores.get(idx)[0];
        int c = cores.get(idx)[1];

        // 4방향 시도
        for (int d = 0; d < 4; d++) {

            if (!canConnect(r, c, d)) {
                continue;
            }

            int len = setWire(r, c, d);

            dfs(idx + 1, connected + 1, wireLength + len);

            removeWire(r, c, d);
        }

        // 현재 코어를 연결하지 않는 경우
        dfs(idx + 1, connected, wireLength);
    }

    static boolean canConnect(int r, int c, int d) {

        int nr = r + dr[d];
        int nc = c + dc[d];

        while (nr >= 0 && nr < N && nc >= 0 && nc < N) {

            // 코어나 기존 전선이 있으면 연결 불가
            if (maxi[nr][nc] != 0) {
                return false;
            }

            nr += dr[d];
            nc += dc[d];
        }

        return true;
    }

    static int setWire(int r, int c, int d) {

        int nr = r + dr[d];
        int nc = c + dc[d];

        int len = 0;

        while (nr >= 0 && nr < N && nc >= 0 && nc < N) {

            maxi[nr][nc] = 2;
            len++;

            nr += dr[d];
            nc += dc[d];
        }

        return len;
    }

    static void removeWire(int r, int c, int d) {

        int nr = r + dr[d];
        int nc = c + dc[d];

        while (nr >= 0 && nr < N && nc >= 0 && nc < N) {

            maxi[nr][nc] = 0;

            nr += dr[d];
            nc += dc[d];
        }
    }
}