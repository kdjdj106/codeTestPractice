package org.beakJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Test14923 {
    static int n, m, answer = Integer.MAX_VALUE;
    static int Hx, Hy, Ex, Ey;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, -1, 0, 1};
    static int[][] board;
    static boolean[][][] visit;
    static Queue<Position> Q;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        board = new int[n][m];
        st = new StringTokenizer(br.readLine());
        Hx = Integer.parseInt(st.nextToken());
        Hy = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        Ex = Integer.parseInt(st.nextToken());
        Ey = Integer.parseInt(st.nextToken());

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        Q = new LinkedList<Position>();
        Q.offer(new Position(Hx, Hy, 0, 0));
        visit=  new boolean[2][n][m];
        visit[0][Hx][Hy] = true;
        bfs();

    }
    static void bfs(){
        while (!Q.isEmpty()){
            Position tmp = Q.poll();
            for (int i = 0; i < 4; i++) {
                int nx = tmp.x + dx[i];
                int ny = tmp.y + dy[i];
                if(nx >= 0 && nx < n && ny >= 0 && ny < m){
                    if ( board[nx][ny] == 1){
                        if (tmp.cnt == 0 && !visit[1][nx][ny]){
                            if (nx == Ex && ny == Ey){answer = tmp.time; return;}
                            visit[1][nx][ny] = true;
                            Q.offer(new Position(nx, ny, tmp.cnt +1, tmp.time+1));
                        }
                    }else {
                        if
                    }

                }
            }
        }
    }
    static class Position{
        int x, y,cnt, time;
        public Position(int x, int y, int cnt, int time) {
            this.x = x;
            this.y = y;
            this.cnt = cnt;
            this.time = time;
        }
    }
}
