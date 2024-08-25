package org.programers.skillCheck;

import org.programers.Test169199;

import java.util.LinkedList;
import java.util.Queue;

public class Level2Test2 {
    static char[][] board;
    static boolean[][] visit;
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static int n, m;
    static Point robot, goal;
    static Queue<Point> Q;
    public static void main(String[] args) {
        String[] arr = {"...D..R", ".D.G...", "....D.D", "D....D.", "..D...."};
        System.out.println(solution(arr));
    }
    static public int solution(String[] arr) {
        int answer = 0;
        n = arr.length;
        m = arr[0].length();
        board = new char[n][m];
        visit = new boolean[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                char ch = arr[i].charAt(j);
                if (ch == 'R') {
                    robot = new Point(i, j, 0);
                }else if (ch == 'G') {
                    goal = new Point(i, j, 0);
                }
                board[i][j] = ch;
            }
        }


        return bfs();
    }
    static int bfs(){
        Queue<Point> Q = new LinkedList<Point>();
        Q.offer(robot);
        visit[robot.x][robot.y] = true;
        while (!Q.isEmpty()) {
            Point tmp = Q.poll();

            if (tmp.x == goal.x && tmp.y == goal.y) {
                return tmp.cnt;
            }

            for (int i = 0; i < 4; i++) {
                int nx = tmp.x;
                int ny = tmp.y;

                while (check(nx, ny) && board[nx][ny] != 'D') {
                    nx += dx[i];
                    ny += dy[i];
                }
                nx -= dx[i];
                ny -= dy[i];

                if (visit[nx][ny]) continue;

                visit[nx][ny] = true;
                Q.offer(new Point(nx, ny, tmp.cnt+1));
            }
        }
        return -1;
    }
    static boolean check(int x, int y){
        if (x>= 0 && x < n && y >= 0 && y <m) return true;
        return false;
    }

    static class Point{
        int x, y, cnt;
        public Point(int x, int y, int cnt) {
            this.x = x;
            this.y = y;
            this.cnt = cnt;
        }
    }
}
