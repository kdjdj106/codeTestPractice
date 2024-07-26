package org.beakJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Test1780 {
    static int n;
    static int[][] board;
    static int n1 = 0, n2 =0, n3 =0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());

        board = new int[n][n];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        dfs(0, 0, n);
        System.out.println(n1);
        System.out.println(n2);
        System.out.println(n3);

    }
    static void dfs(int x, int y, int size){
        if (check(x, y, size)){
           if (board[x][y] == -1) n1++;
           else if (board[x][y] == 0) n2++;
           else if (board[x][y] == 1) n3++;
           return;
        }

        int nSize = size/3;

        // 위쪽 1/3
        dfs(x, y, nSize);
        dfs(x, y+nSize, nSize);
        dfs(x, y + nSize*2, nSize);
        // 가운데
        dfs(x+nSize, y, nSize);
        dfs(x+nSize, y+nSize, nSize);
        dfs(x+nSize, y + nSize*2, nSize);
        // 밑쪽 1/3
        dfs(x+nSize*2, y, nSize);
        dfs(x+nSize*2, y+nSize, nSize);
        dfs(x+nSize*2, y + nSize*2, nSize);
    }
    static boolean check(int nx, int ny, int size){
        int a = board[nx][ny];
        for (int i = nx; i < nx + size; i++) {
            for (int j = ny; j < ny + size; j++) {
                if (a != board[i][j]) return false;
            }
        }
        return true;
    }
}
