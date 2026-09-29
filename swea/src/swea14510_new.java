import java.io.*;
import java.util.*;


public class swea14510_new {
	
	
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/swea14510/Sample_input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine());
		
		for (int tc = 1; tc <= T; tc++) {
			StringBuilder sb = new StringBuilder();
			
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
            
            for (int tree: trees) {
            	int diff = max-tree;
            	one += diff%2;
            	two += diff/2;
            }
            
            while (two-1 > one) { 
            	two--;
            	one += 2;
            }

            int answer = 0;
            if (one > two) answer += (one*2 -1);
            else answer += two*2;
         
			
			
			sb.append("#").append(tc).append(" ").append(answer);
			System.out.println(sb);
		}
		
	}
}
