package org.beakJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Test16918 {
    static int n, m, time;
    static char[][] board;
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};
    static Queue<Point> Q;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        time = Integer.parseInt(st.nextToken());
        board = new char[n][m];
        Q = new LinkedList<>();

        // 폭탄 위치를 큐에 담는다.
        for (int i = 0; i < n; i++) {
            String str = br.readLine();
            for (int j = 0; j < m; j++) {
                char ch = str.charAt(j);
                if (ch == 'O') Q.offer(new Point(i, j));
                board[i][j] = str.charAt(j);
            }
        }
        // 시간이 1초면 그냥 바로 보드를 출력하고
        if (time == 1) {
            printBoard();
        }

        // 시간이 짝수면 보드에 폭탄을 가득 채워서 출력한다.
        else if (time % 2 == 0) {
            setFillBoard(board);
            printBoard();
        }
        // 나머지 경우에 로직을 시작한다.
        else {
            bfs();
            printBoard();
        }

    }



    static void bfs() {
        // 2초 부터 시작한다. 그 이유는 1초때는 보드 자체를 출력하고
        // 시작 하기위해서는 보드를 폭탄으로 채우고 큐에 담긴 폭탄을 터트리기 위해서 이다.
        for (int t = 2; t <= time; t++) {

            // 시간이 짝수 일때 현재 보드를 폭탄으로 채우고 continue;
            if (t % 2 == 0){
                setFillBoard(board);
                continue;
            }

            // 시간이 홀수 일경우 큐에 있는 폭탄을 모두 터트린다.
            while (!Q.isEmpty()) {
                Point tmp = Q.poll();

                // 현재 폭탄 위치를 '.'로 변경
                board[tmp.x][tmp.y] = '.';
                for (int i = 0; i < 4; i++) {
                    int nx = tmp.x + dx[i];
                    int ny = tmp.y + dy[i];

                    // 상하좌우 가 '.'가 아니면 '.'로 바꿔준다.
                    if (nx >= 0 && nx < n && ny >= 0 && ny < m && board[nx][ny] != '.') {
                        board[nx][ny] = '.';
                    }
                }


            }
            //나머지 폭탄이 있는 위치를 큐에 담는다.
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    if (board[i][j] == 'O') Q.offer(new Point(i, j));
                }
            }
        }
    }
    static void setFillBoard(char[][] board){
        for (int i = 0; i < n; i++) {
            Arrays.fill(board[i], 'O');
        }
    }
    private static void printBoard() {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                System.out.print(board[i][j]);
            }
            System.out.println();
        }
    }
    static class Point {
        int x, y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

}
