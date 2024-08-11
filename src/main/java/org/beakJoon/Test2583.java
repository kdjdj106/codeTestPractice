package org.beakJoon;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

/*
눈금의 간격이 1인 M×N(M,N≤100)크기의 모눈종이가 있다. 이 모눈종이 위에 눈금에 맞추어 K개의 직사각형을 그릴 때,
이들 K개의 직사각형의 내부를 제외한 나머지 부분이 몇 개의 분리된 영역으로 나누어진다.

예를 들어 M=5, N=7 인 모눈종이 위에 <그림 1>과 같이 직사각형 3개를 그렸다면, 그 나머지 영역은 <그림 2>와 같이 3개의 분리된 영역으로 나누어지게 된다.
<그림 2>와 같이 분리된 세 영역의 넓이는 각각 1, 7, 13이 된다.

M, N과 K 그리고 K개의 직사각형의 좌표가 주어질 때, K개의 직사각형 내부를 제외한 나머지 부분이 몇 개의 분리된 영역으로 나누어지는지, 그리고 분리된 각 영역의 넓이가 얼마인지를 구하여 이를 출력하는 프로그램을 작성하시오.
첫째 줄에 M과 N, 그리고 K가 빈칸을 사이에 두고 차례로 주어진다. M, N, K는 모두 100 이하의 자연수이다.
둘째 줄부터 K개의 줄에는 한 줄에 하나씩 직사각형의 왼쪽 아래 꼭짓점의 x, y좌표값과 오른쪽 위 꼭짓점의 x, y좌표값이 빈칸을 사이에 두고 차례로 주어진다.
모눈종이의 왼쪽 아래 꼭짓점의 좌표는 (0,0)이고, 오른쪽 위 꼭짓점의 좌표는(N,M)이다. 입력되는 K개의 직사각형들이 모눈종이 전체를 채우는 경우는 없다.

예제입력
5 7 3
0 2 4 4
1 1 2 5
4 0 6 2

출력
3
1 7 13
* */
public class Test2583 {
    static int n, m, c, area;
    static int[] dx ={1, 0, -1, 0};
    static int[] dy ={0, 1, 0, -1};
    static ArrayList<Integer> list = new ArrayList<Integer>();
    static int[][] board;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        board = new int[n][m];
        c = sc.nextInt();

        // 입력받은 영역을 보드에 표시한다.
        for (int q = 0; q < c; q++) {
            int y1 = sc.nextInt();
            int x1 = sc.nextInt();
            int y2 = sc.nextInt();
            int x2 = sc.nextInt();
            for (int i = x1; i < x2; i++) {
                for (int j = y1; j < y2; j++) {
                    board[i][j] = 1;
                }
            }
        }
        // 영역이 아닌 부분을 발견하면 dfs하여 넓이를 구한다.
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (board[i][j] == 0) {
                    area =1;
                    dfs(i, j);
                    list.add(area);
                }
            }
        }

        // dfs한 넓이를 list에 담아 오름차순으로 정렬한다.
        Collections.sort(list);
        System.out.println(list.size());
        for (Integer integer : list) {
            System.out.print(integer+" ");
        }
    }

    //로직 시작
    public static void dfs(int i, int j) {
        // 이미 탐색한 영역을 표기한다.
        board[i][j] = 1;


        for (int k = 0; k < 4; k++) {
            int nx = i + dx[k];
            int ny = j + dy[k];
            // 탐색한 영역이 아니고 올바른 범위안에 있다면 dfs한다.
            if (nx>= 0 && nx < n && ny >= 0 && ny < m && board[nx][ny] == 0) {
                board[nx][ny] = 1;
                area++;
                dfs(nx, ny);
            }
        }
    }
}
