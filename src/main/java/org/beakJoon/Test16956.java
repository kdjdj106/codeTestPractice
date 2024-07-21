package org.beakJoon;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/*
문제
크기가 R×C인 목장이 있고, 목장은 1×1 크기의 칸으로 나누어져 있다. 각각의 칸에는 비어있거나, 양 또는 늑대가 있다. 양은 이동하지 않고 위치를 지키고 있고,
늑대는 인접한 칸을 자유롭게 이동할 수 있다. 두 칸이 인접하다는 것은 두 칸이 변을 공유하는 경우이다.

목장에 울타리를 설치해 늑대가 양이 있는 칸으로 갈 수 없게 하려고 한다. 늑대는 울타리가 있는 칸으로는 이동할 수 없다. 울타리를 설치해보자.

입력
첫째 줄에 목장의 크기 R, C가 주어진다.

둘째 줄부터 R개의 줄에 목장의 상태가 주어진다. '.'는 빈 칸, 'S'는 양, 'W'는 늑대이다.

출력
늑대가 양이 있는 칸으로 갈 수 없게 할 수 있다면 첫째 줄에 1을 출력하고, 둘째 줄부터 R개의 줄에 목장의 상태를 출력한다. 울타리는 'D'로 출력한다.
울타리를 어떻게 설치해도 늑대가 양이 있는 칸으로 갈 수 있다면 첫째 줄에 0을 출력한다.

제한
1 ≤ R, C ≤ 500

예제 입력 1
6 6
..S...
..S.W.
.S....
..W...
...W..
......

예제 출력 1
1
..SD..
..SDW.
.SD...
.DW...
DD.W..
......
*/
public class Test16956 {
    static int n, m;
    static char[][] board;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    static Queue<Point> Q = new LinkedList<>();
    static boolean check = true;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        board = new char[n][m];
        for (int i = 0; i < n; i++) {
            String str = sc.next();
            for (int j = 0; j < str.length(); j++) {
                char ch = str.charAt(j);
                board[i][j] = ch;
                if (ch == 'W') Q.offer(new Point(i, j));
            }
        }
        bfs();
        if (check){
            System.out.println(1);
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    System.out.print(board[i][j]);
                }
                System.out.println();
            }
        }else System.out.println(0);
    }

    public static void bfs() {
        while (!Q.isEmpty()) {
            Point tmp = Q.poll();
            for (int i = 0; i < 4; i++) {
                int nx = tmp.x + dx[i];
                int ny = tmp.y + dy[i];
                if (nx >= 0 && nx < n && ny >= 0 && ny < m){
                    if (board[nx][ny] == '.'){
                        board[nx][ny] = 'D';
                    } else if (board[nx][ny] == 'S') {
                        check = false;
                        return;
                    }
                }
            }

        }

    }
    public static class Point{
        int x, y;
        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
