import java.io.*;
import java.util.*;

public class swea14510_d2_나무높이 {

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int T = Integer.parseInt(br.readLine());

        for (int tc = 1; tc <= T; tc++) {

            int N = Integer.parseInt(br.readLine());
            int[] trees = new int[N];
            st = new StringTokenizer(br.readLine());
            int max = 0;

            for (int i = 0; i < N; i++) {
                trees[i] = Integer.parseInt(st.nextToken());
                max = Math.max(max, trees[i]);
            }

            int one = 0;
            int two = 0;

            for (int tree : trees) {
                int diff = max - tree;
                one += diff % 2;
                two += diff / 2;
            }

            int answer = Integer.MAX_VALUE;

            // +2 하나를 +1 두 개로 바꾸는 모든 경우
            for (int change = 0; change <= two; change++) {
                int curOne = one + change * 2;
                int curTwo = two - change;
                int days = Math.max(
                        curOne * 2 - 1,
                        curTwo * 2
                );
                answer = Math.min(answer, days);
            }

            if (one == 0 && two == 0) {
                answer = 0;
            }

            System.out.println("#" + tc + " " + answer);
        }
    }
}