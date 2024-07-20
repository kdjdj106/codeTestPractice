package org.newExample.chapter8;

import java.util.LinkedList;
import java.util.Objects;
import java.util.Queue;
import java.util.Scanner;

public class Test11 {
    static int[][] board = new int[8][8];
    static int[][] dis = new int[8][8];
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        for (int i = 1; i < 8; i++) {
            for (int j = 1; j < 8; j++) {
                board[i][j] = sc.nextInt();
            }
        }
//        dis[1][1] =0;
        BFS(1, 1);

        if (dis[7][7] == 0) System.out.println(-1);
        else System.out.println(dis[7][7]);
    }
    public static void BFS(int x, int y){
        Queue<Point> Q = new LinkedList<>();
        Point point = new Point(x, y);
        Q.offer(point);
        while (!Q.isEmpty()){
            Point tmp = Q.poll();
            for (int i = 0; i < 4; i++) {
                int nx = tmp.x + dx[i];
                int ny = tmp.y + dy[i];


                if (nx>0 && ny >0 && nx < board.length && ny < board.length && board[nx][ny] == 0){
                    board[nx][ny] =1;
                    Q.offer(new Point(nx, ny));
                    dis[nx][ny] = dis[tmp.x][tmp.y] +1;
                }
            }
        }
    }

    public static class Point{
        int x;
        int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
