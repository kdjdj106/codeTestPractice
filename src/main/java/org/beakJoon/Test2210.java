package org.beakJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

/*
문제
5×5 크기의 숫자판이 있다. 각각의 칸에는 숫자(digit, 0부터 9까지)가 적혀 있다. 이 숫자판의 임의의 위치에서 시작해서, 인접해 있는 네 방향으로 다섯 번 이동하면서, 각 칸에 적혀있는 숫자를 차례로 붙이면 6자리의 수가 된다. 이동을 할 때에는 한 번 거쳤던 칸을 다시 거쳐도 되며, 0으로 시작하는 000123과 같은 수로 만들 수 있다.

숫자판이 주어졌을 때, 만들 수 있는 서로 다른 여섯 자리의 수들의 개수를 구하는 프로그램을 작성하시오.

입력
다섯 개의 줄에 다섯 개의 정수로 숫자판이 주어진다.

출력
첫째 줄에 만들 수 있는 수들의 개수를 출력한다.

예제 입력 1
1 1 1 1 1
1 1 1 1 1
1 1 1 1 1
1 1 1 2 1
1 1 1 1 1
예제 출력 1
15
* */
public class Test2210 {
    static int[][] board;
    static boolean[][] visit;
    static int[] dy = {1, 0, -1, 0};
    static int[] dx = {0, 1, 0, -1};
    static HashSet<String> set;
    static int[] answer;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        board = new int[5][5];
        visit = new boolean[5][5];
        answer = new int[6];
        for (int i = 0; i < 5; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 5; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        set = new HashSet<>();
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                dfs(i, j, 0);
            }
        }
        System.out.println(set.size());
    }
    static void dfs(int x, int y, int L){
        if (L == 6){
            String str = "";
            for (int j : answer) str += Integer.toString(j);
            set.add(str);
        }else {
            answer[L] = board[x][y];
            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                if (nx >= 0 && nx <5 && ny >= 0 && ny <5 ){
                    dfs(nx, ny, L+1);
                }
            }
        }
    }
}
