package org.beakJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.StringTokenizer;
import java.util.logging.Logger;

/*
 입력
입력은 여러 개의 테스트 케이스로 이루어지며, 각 테스트 케이스는 세 개의 정수 L, R, C로 시작한다. L(1 ≤ L ≤ 30)은 상범 빌딩의 층 수이다. R(1 ≤ R ≤ 30)과 C(1 ≤ C ≤ 30)는 상범 빌딩의 한 층의 행과 열의 개수를 나타낸다.

그 다음 각 줄이 C개의 문자로 이루어진 R개의 행이 L번 주어진다. 각 문자는 상범 빌딩의 한 칸을 나타낸다. 금으로 막혀있어 지나갈 수 없는 칸은 '#'으로 표현되고, 비어있는 칸은 '.'으로 표현된다. 당신의 시작 지점은 'S'로 표현되고, 탈출할 수 있는 출구는 'E'로 표현된다. 각 층 사이에는 빈 줄이 있으며, 입력의 끝은 L, R, C가 모두 0으로 표현된다. 시작 지점과 출구는 항상 하나만 있다.

출력
각 빌딩에 대해 한 줄씩 답을 출력한다. 만약 당신이 탈출할 수 있다면 다음과 같이 출력한다.

Escaped in x minute(s).
여기서 x는 상범 빌딩을 탈출하는 데에 필요한 최단 시간이다.

만일 탈출이 불가능하다면, 다음과 같이 출력한다.

Trapped!
예제 입력 1
3 4 5
S....
.###.
.##..
###.#

#####
#####
##.##
##...

#####
#####
#.###
####E

1 3 3
S##
#E#
###

0 0 0

예제 출력 1
Escaped in 11 minute(s).
Trapped!
* */
public class Test6593 {
    static int h, n, m;
    static char[][][] board;
    static boolean[][][] visited;
    static int[][][] cnt;
    static int answer = 0;
    static boolean flag = false;
    static int[] dx = {1, 0, -1, 0, 0, 0};
    static int[] dy = {0, 1, 0, -1, 0, 0};
    static int[] dh = {0, 0, 0, 0, 1, -1};
    static Queue<Point> Q;
    static Point start, end;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while (true) {
            flag = false;
            StringTokenizer st = new StringTokenizer(br.readLine());
            if(!st.hasMoreTokens())
                st = new StringTokenizer(br.readLine());

            h = Integer.parseInt(st.nextToken());
            n = Integer.parseInt(st.nextToken());
            m = Integer.parseInt(st.nextToken());
            if (h == 0 && n == 0 && m == 0) {
                break;
            }
            board = new char[h][n][m];
            visited = new boolean[h][n][m];
            cnt = new int[h][n][m];

            for (int z = 0; z < h; z++) {
                for (int i = 0; i < n; i++) {
                    String str = br.readLine();

                    if(str.equals(""))
                        str = br.readLine();

                    for (int j = 0; j < str.length(); j++) {
                        char ch = str.charAt(j);
                        if (ch == 'S') {
                            start = new Point(z, i, j);
                        }
                        if (ch == 'E') {
                            end = new Point(z, i, j);
                        }
                        board[z][i][j] = ch;
                    }
                }
            }
            bfs(start);
            if(!flag){
                System.out.println("Trapped!");
            }
        }
    }

    static void bfs(Point point) {
        visited[point.z][point.x][point.y] = true;
        Q = new LinkedList<>();
        Q.offer(point);
        while (!Q.isEmpty()) {
            Point tmp = Q.poll();
            if (board[tmp.z][tmp.x][tmp.y] == 'E') {
                System.out.println("Escaped in " + cnt[tmp.z][tmp.x][tmp.y] + " minute(s).");
                flag = true;
                return;
            }
            for (int i = 0; i < 6; i++) {
                int nz = tmp.z + dh[i];
                int nx = tmp.x + dx[i];
                int ny = tmp.y + dy[i];

                if (nz >= 0 && nz < h && nx >= 0 && nx < n && ny >= 0 && ny < m && !visited[nz][nx][ny]){
                    if (board[nz][nx][ny] != '#'){
                        cnt[nz][nx][ny] = cnt[tmp.z][tmp.x][tmp.y] +1;
                        visited[nz][nx][ny] = true;
                        Q.offer(new Point(nz, nx, ny));
                    }
                }
            }
        }
    }

    static class Point {
        int z, x, y;

        Point(int z, int x, int y) {
            this.z = z;
            this.x = x;
            this.y = y;
        }
    }
}
