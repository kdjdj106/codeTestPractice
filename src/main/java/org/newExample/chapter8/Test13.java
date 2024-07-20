package org.newExample.chapter8;

import java.util.Scanner;

public class Test13 {
    static int n;
    static int answer =0;
    static int[][] board;
    static int[] dy = {1, 0, -1, 0, 1, 1, -1, -1};
    static int[] dx = {0, -1, 0, 1, 1, -1, -1, 1};
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        board = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] = sc.nextInt();
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == 1) {answer++; DFS(i, j);}
            }
        }
        System.out.println(answer);
    }
    public static void DFS(int x, int y){
        for (int i = 0; i < dx.length; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if (nx >=0 && nx < n && ny >= 0 && ny < n && board[nx][ny] == 1){
                board[nx][ny] = 0;
                DFS(nx, ny);
            }
        }
    }
}
