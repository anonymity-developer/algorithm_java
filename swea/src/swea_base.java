import java.io.*;
import java.util.*;

class Soltion {

    public static void main(String[] args) throws Exception {

        System.setIn(new FileInputStream("res/문제명/input.txt"));

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        for (int tc = 1; tc <= T; tc++) {
        	
            // 풀이
        	int answer = 0;
            sb.append("#").append(tc).append(" ").append(answer).append("\n");
        }
        System.out.print(sb);
    }
}

public class swea_base{
}