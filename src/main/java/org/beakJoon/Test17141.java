package org.beakJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Test17141 {
    static int n, m, answer = Integer.MAX_VALUE;
    static int[][] board;
    static boolean[][] visited;
    static boolean[][] copyVisited;
    static int[][] copyBoard;
    static int[][] count;
    static int[] dx ={1, 0, -1, 0};
    static int[] dy ={0, 1, 0, -1};
    static Queue<Point> Q;
    static boolean flag;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        Q = new LinkedList<>();
        board = new int[n][n];
        copyVisited = new boolean[n][n];
        copyBoard = new int[n][n];
        visited = new boolean[n][n];
        // 보드에 입력
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                int a = Integer.parseInt(st.nextToken());
                board[i][j] = a;
            }
        }

        // dfs
        dfs(0);
        System.out.println(answer);
    }
    static void dfs(int L){
        count = new int[n][n];
        if (L == 3){
            bfs();
            return;
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == 2 && !visited[i][j]){
                    visited[i][j] = true;
                    dfs(L+1);
                    visited[i][j] = false;
                }
            }
        }
    }
    static void bfs(){
        for (int i = 0; i < n; i++) {
            copyBoard[i] = board[i].clone();
            copyVisited[i] = visited[i].clone();
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == 2 && visited[i][j]){
                    Q.offer(new Point(i, j));
                }
            }
        }



        while (!Q.isEmpty()){
            Point tmp = Q.poll();
            for (int i = 0; i < 4; i++) {
                int nx = tmp.x + dx[i];
                int ny = tmp.y + dy[i];

                if (nx >= 0 && nx < n && ny >= 0 && ny < n && !copyVisited[nx][ny]){
                    if (copyBoard[nx][ny] == 0 || copyBoard[nx][ny] == 2){
                        copyBoard[nx][ny] =2;
                        copyVisited[nx][ny] = true;
                        count[nx][ny] = count[tmp.x][tmp.y]+1;
                        Q.offer(new Point(nx, ny));
                    }

                }
            }
        }
        if (check(copyBoard)){
            answer = Math.min( calculateVirus(count), answer);
        }else answer = -1;

    }
    static boolean check(int[][] copyBoard){
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (copyBoard[i][j] == 0) return false;
            }
        }
        return true;
    }
    static int calculateVirus(int[][] count){
        int t = -1;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                t = Math.max(count[i][j], t);
            }
        }
        return t;
    }
    static class Point{
        int x, y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
// todo 아직 완료 못함 다시 고민!