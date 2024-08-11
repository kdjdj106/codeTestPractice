package org.beakJoon;

import java.util.Scanner;

/*
세로R칸, 가로C칸으로 된 표 모양의 보드가 있다. 보드의 각 칸에는 대문자 알파벳이 하나씩 적혀 있고,
좌측 상단 칸 (1행 1열) 에는 말이 놓여 있다.

말은 상하좌우로 인접한 네 칸 중의 한 칸으로 이동할 수 있는데, 새로 이동한 칸에 적혀 있는 알파벳은 지금까지 지나온 모든 칸에 적혀 있는 알파벳과는 달라야 한다. 즉, 같은 알파벳이 적힌 칸을 두 번 지날 수 없다.

좌측 상단에서 시작해서, 말이 최대한 몇 칸을 지날 수 있는지를 구하는 프로그램을 작성하시오. 말이 지나는 칸은 좌측 상단의 칸도 포함된다.
첫째 줄에
R과 C가 빈칸을 사이에 두고 주어진다. (1 ≤ R,C ≤ 20) 둘째 줄부터
R개의 줄에 걸쳐서 보드에 적혀 있는 C개의 대문자 알파벳들이 빈칸 없이 주어진다.

입력            |
2 4           |     3 6
CAAB          |    HFDFFB
ADCB          |    AJHGDH
              |    DGAGEH
출력
3             |    6
* */
public class Test1987 {
    static int[] dy = {1, 0, -1, 0};
    static int[] dx = {0, 1, 0, -1};
    static char[][] board;

    // 알파벳은 26자리 이기 때문에 알파벳을 체크해줄 배열을 담는다.
    static boolean[] check = new boolean[26];
    static int n, m, cnt;
    static int answer=0;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        sc.nextLine();
        board = new char[n][m];
        for (int i = 0; i < n; i++) {
            String str = sc.nextLine();
            for (int j = 0; j < str.length(); j++) {
                board[i][j] = str.charAt(j);
            }
        }
        check[board[0][0] -'A'] = true;
        DFS(0, 0, 1);
        System.out.println(answer);

    }
    public static void DFS(int x, int y, int cnt){
        answer = Math.max(answer, cnt);
        if(cnt == 26) return;
        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            // 다음 칸이 올바른 범위이고 알파벳 체크배열에서 체크가 안되있다면
            if (nx >= 0 && nx < n && ny >= 0 && ny < m && !check[board[nx][ny] - 'A']) {
                // 체크하고 dfs한다.
                check[board[nx][ny] - 'A'] = true;
                DFS(nx, ny, cnt + 1);
                // dfs에서 나온후 체크를 해체한다.
                check[board[nx][ny] - 'A'] = false;
            }
        }
    }

}
