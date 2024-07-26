package org.beakJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Test14502 {
    public static int n;
    public static int m;
    public static int[] dx = {1, -1, 0, 0};
    public static int[] dy = {0, 0, 1, -1};
    public static int[][] board;
    public static int[][] copyBoard;

    public static Queue<Point> Q = new LinkedList<Point>();
    public static int answer = Integer.MIN_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        board = new int[n][m];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }


        dfs(0);

        System.out.println(answer);
    }

    static void dfs(int L) {
        if(L == 3) {
            bfs();
            return;
        }

        for(int i=0; i<n; i++) {
            for(int j=0; j<m; j++) {
                if(board[i][j] == 0) {
                    board[i][j] = 1;
                    dfs(L+1);
                    board[i][j] = 0;
                }
            }
        }
    }

    public static void bfs() {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (board[i][j] == 2) {
                    Q.offer(new Point(i, j));
                }
            }
        }

        copyBoard = new int[n][m];

        for (int i = 0; i < n; i++) {
            copyBoard[i] = board[i].clone();
        }

        while (!Q.isEmpty()) {
            Point tmp = Q.poll();

            for (int i = 0; i < 4; i++) {
                int nx = tmp.x + dx[i];
                int ny = tmp.y + dy[i];

                if (0 <= nx && nx < n && 0 <= ny && ny < m) {
                    if (copyBoard[nx][ny] == 0) {
                        copyBoard[nx][ny] = 2;
                        Q.add(new Point(nx, ny));
                    }
                }
            }

        }

        calculateRoom(copyBoard);
    }

    static void calculateRoom(int[][] copyBoard) {
        int room = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (copyBoard[i][j] == 0) {
                    room++;
                }
            }
        }
        answer = Math.max(room, answer);
    }




    static class Point {
        int x, y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
