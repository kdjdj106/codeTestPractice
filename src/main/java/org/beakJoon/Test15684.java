package org.beakJoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

/*
입력
첫째 줄에 세로선의 개수 N, 가로선의 개수 M, 세로선마다 가로선을 놓을 수 있는 위치의 개수 H가 주어진다. (2 ≤ N ≤ 10, 1 ≤ H ≤ 30, 0 ≤ M ≤ (N-1)×H)

둘째 줄부터 M개의 줄에는 가로선의 정보가 한 줄에 하나씩 주어진다.

가로선의 정보는 두 정수 a과 b로 나타낸다. (1 ≤ a ≤ H, 1 ≤ b ≤ N-1) b번 세로선과 b+1번 세로선을 a번 점선 위치에서 연결했다는 의미이다.

가장 위에 있는 점선의 번호는 1번이고, 아래로 내려갈 때마다 1이 증가한다. 세로선은 가장 왼쪽에 있는 것의 번호가 1번이고, 오른쪽으로 갈 때마다 1이 증가한다.

입력으로 주어지는 가로선이 서로 연속하는 경우는 없다.

출력
i번 세로선의 결과가 i번이 나오도록 사다리 게임을 조작하려면, 추가해야 하는 가로선 개수의 최솟값을 출력한다. 만약, 정답이 3보다 큰 값이면 -1을 출력한다. 또, 불가능한 경우에도 -1을 출력한다.

예제 입력 1
2 0 3
예제 출력 1
0

 */
public class Test15684 {
    static int n, m, h, answer;
    static int[][] board;
    static boolean check =false;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        h = sc.nextInt();
        if (m == 0){
            System.out.println(0);
            System.exit(0);
        }
        board = new int[h + 1][n + 1];
        for (int i = 0; i < m; i++) {
            int x = sc.nextInt();
            int y = sc.nextInt();
            board[x][y] = 1;
            board[x][y + 1] = -1;
        }

        for (int i = 0; i <= 3; i++) {
            answer =i;
            dfs(1, 0);
            if (check) break;
        }
        System.out.println((check) ? answer : -1);
    }
    public static void dfs(int x, int cnt){
        if (check) return;
        if (answer == cnt){
            if (possible()) check = true;
            return;
        }
        for (int i = x; i < h+1; i++) {
            for (int j = 1; j < n; j++) {
                if (board[i][j] == 0 && board[i][j+1] == 0){
                    board[i][j] = 1;
                    board[i][j+1] = -1;
                    dfs(x, cnt+1);
                    board[i][j] = board[i][j+1] = 0;
                }
            }
        }
    }
    public static boolean possible(){
        for (int i = 1; i <= n; i++) {
            int x =1;
            int y =i;
            for (int j = 1; j <= h; j++) {
                if (board[x][y] == 1) y++;
                else if (board[x][y] == -1) y--;
                x++;
            }
            if (y != i) return false;

        }
        return true;
    }
}
