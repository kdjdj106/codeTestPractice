package org.beakJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
로봇 청소기는 다음과 같이 작동한다.

1. 현재 칸이 아직 청소되지 않은 경우, 현재 칸을 청소한다.
2. 현재 칸의 주변 4칸 중 청소되지 않은 빈 칸이 없는 경우,
2-1바라보는 방향을 유지한 채로 한 칸 후진할 수 있다면 한 칸 후진하고 1번으로 돌아간다.
2-2바라보는 방향의 뒤쪽 칸이 벽이라 후진할 수 없다면 작동을 멈춘다.
3. 현재 칸의 주변 4칸 중 청소되지 않은 빈 칸이 있는 경우,
3-1 반시계 방향으로 90도 회전한다.
3-2 바라보는 방향을 기준으로 앞쪽 칸이 청소되지 않은 빈 칸인 경우 한 칸 전진한다.
1번으로 돌아간다.
* */
public class Test14503 {
    static int n, m, answer;
    static int sX, sY, sD;
    static int[][] board;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        board = new int[n][m];

        st = new StringTokenizer(br.readLine());
        sX = Integer.parseInt(st.nextToken());
        sY = Integer.parseInt(st.nextToken());
        sD = Integer.parseInt(st.nextToken());
        board[sX][sY] = 3;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        answer = 0;
        if (board[sX][sY]== 0){
            board[sX][sY] = 3;
            answer++;
        }
        dfs(sX, sY, sD);
        System.out.println(answer);

    }

    static void dfs(int x, int y, int d) {

        for (int i = 0; i < 4; i++) {

            d = (d + 3) % 4;

            int nx = x + dx[d];
            int ny = y + dy[d];
            if (nx >= 0 && nx < n && ny >= 0 && ny < m && board[nx][ny] == 0) {
                board[nx][ny] = 3;
                answer++;
                dfs(nx, ny, d);
                return;
            }
        }
        int nd = (d + 2) % 4;
        int bx = x + dx[nd];
        int by = y + dy[nd];
        if (bx >= 0 && bx < n && by >= 0 && by < m && board[bx][by] != 1){
            dfs(bx, by, d);
        }
    }
}