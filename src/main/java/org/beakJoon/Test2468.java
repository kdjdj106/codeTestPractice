package org.beakJoon;

import java.util.Scanner;

/*
입력
첫째 줄에는 어떤 지역을 나타내는 2차원 배열의 행과 열의 개수를 나타내는 수 N이 입력된다. N은 2 이상 100 이하의 정수이다.
둘째 줄부터 N개의 각 줄에는 2차원 배열의 첫 번째 행부터 N번째 행까지 순서대로 한 행씩 높이 정보가 입력된다.
각 줄에는 각 행의 첫 번째 열부터 N번째 열까지 N개의 높이 정보를 나타내는 자연수가 빈 칸을 사이에 두고 입력된다. 높이는 1이상 100 이하의 정수이다.

출력
첫째 줄에 장마철에 물에 잠기지 않는 안전한 영역의 최대 개수를 출력한다.

예제 입력 1
5
6 8 2 6 2
3 2 3 4 6
6 7 3 3 2
7 2 5 3 6
8 9 5 2 7
예제 출력 1
5

예제 입력 2
7
9 9 9 9 9 9 9
9 2 1 2 1 2 9
9 1 8 7 8 1 9
9 2 7 9 7 2 9
9 1 8 7 8 1 9
9 2 1 2 1 2 9
9 9 9 9 9 9 9
예제 출력 2
6
* */
public class Test2468 {
    static int n;
    static int[][] board;
    static boolean[][] check;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    static int answer = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        board = new int[n][n];
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int a = sc.nextInt();
                board[i][j] = a;
                max = Math.max(max, a);
            }
        }
        for (int h = 0; h < max+1; h++) {
            int cnt =0;
            check = new boolean[n][n];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (board[i][j] > h && !check[i][j]) {
                        cnt++;
                        dfs(i, j, h);
                    }
                }
            }
            answer = Math.max(answer, cnt);
        }
        System.out.println(answer);
    }

    static void dfs(int x, int y, int h) {
        check[x][y] = true;
        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
//            if(nx<0||ny<0||nx>=n||ny>=n||
//                    //물에 잠기거나 이미 확인한 곳이면 체크하지 않는다
//                    board[nx][ny]<=h||check[nx][ny]) continue;
            if (nx >= 0 && nx < n && ny >= 0 && ny < n && !check[nx][ny] && board[nx][ny] > h) {
                dfs(nx, ny, h);
            }
//            dfs(nx,ny,h);
        }
    }
}
