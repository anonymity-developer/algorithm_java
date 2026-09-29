
import java.io.*;
import java.util.*;

public class swea5648_d9_원자소멸시뮬레이션 {
	

    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {1, -1, 0, 0};
    static int[][] map = new int[4001][4001];

    static class Atom {
        int x, y, d, e;

        Atom(int x, int y, int d, int e) {
            this.x = x;
            this.y = y;
            this.d = d;
            this.e = e;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for (int tc = 1; tc <= T; tc++) {
            int N = Integer.parseInt(br.readLine());
            List<Atom> atoms = new ArrayList<>();

            for (int i = 0; i < N; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());

                int x = Integer.parseInt(st.nextToken()) * 2 + 2000;
                int y = Integer.parseInt(st.nextToken()) * 2 + 2000;
                int d = Integer.parseInt(st.nextToken());
                int e = Integer.parseInt(st.nextToken());

                atoms.add(new Atom(x, y, d, e));
            }

            int answer = 0;

            while (!atoms.isEmpty()) {

                // 1. 모든 원자 이동 + 해당 위치에 에너지 누적
                for (Atom a : atoms) {
                    a.x += dx[a.d];
                    a.y += dy[a.d];

                    if (check(a.x, a.y))
                        map[a.x][a.y] += a.e;
                }

                List<Atom> next = new ArrayList<>();

                // 2. 충돌 검사
                for (Atom a : atoms) {
                    if (!check(a.x, a.y)) continue;

                    if (map[a.x][a.y] == a.e) {
                        // 혼자 있음
                        next.add(a);
                        map[a.x][a.y] = 0;

                    } else if (map[a.x][a.y] > 0) {
                        // 2개 이상 충돌
                        answer += map[a.x][a.y];
                        map[a.x][a.y] = 0;
                    }
                }

                atoms = next;
            }

            System.out.println("#" + tc + " " + answer);
        }
    }

    static boolean check(int x, int y) {
        return x >= 0 && x <= 4000 && y >= 0 && y <= 4000;
    }
}
