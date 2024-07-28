package org.beakJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Test17090 {
    static int n, m;
    static int answer = 0;
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};
    static char[][] board;
    static boolean[][] visit;
    static boolean[][] dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        board = new char[n][m];
        visit = new boolean[n][m];
        dp = new boolean[n][m];
        for (int i = 0; i < n; i++) {
            String str = br.readLine();
            for (int j = 0; j < m; j++) {
                board[i][j] = str.charAt(j);
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                dfs(i, j);
            }
        }
    }
    static void dfs(int x, int y){

        if (0>x|| 0>y ||y>=m ||x>=n){
            answer++;
            return;
        }


        if (visit[y][x])return;
        visit[x][y] = true;
        char ch = board[x][y];
        if (ch == 'U'){
            dfs(x -1, y);
        }
        else if (ch == 'R'){
            dfs(x, y+1);
        }
        else if (ch == 'D'){
            dfs(x + 1, y);
        }
        else if (ch == 'L'){
            dfs(x, y-1);
        }

    }
}
// todo 아직 완료 못함 다시 고민!