package org.beakJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Test17144 {
    static int n, m, time;
    static int[][] board;
    static int[][] tmpBoard;
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {1, -1, 0, 0};
    static int airFresherUp, airFresherDown;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        time = Integer.parseInt(st.nextToken());
        board = new int[n][m];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < 1; j++) {
                // 공기청정기 위치 찾기
                if (board[i][j] == -1) {
                    airFresherUp = i;
                    airFresherDown = i + 1;
                    break;
                }
            }
        }

        for (int i = 0; i < time; i++) {
            tmpBoard = new int[n][m];
            // 미세먼지 확산
            diffusionDust();
            board = tmpBoard.clone();
            // 공기청정기로 공기이동
            moveDust();
        }

    }

    static void diffusionDust() {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (board[i][j] == -1) {
                    tmpBoard[i][j] = -1;
                    continue;
                }
                if (board[i][j] == 0) continue;

                tmpBoard[i][j] += board[i][j];
                for (int k = 0; k < 4; k++) {
                    int nx = i + dx[k];
                    int ny = j + dy[k];

                    if (nx >= 0 && nx < n && ny >= 0 && ny < m && board[nx][ny] != -1) {
                        tmpBoard[nx][ny] += (board[i][j] / 5);
                        tmpBoard[i][j] -= (board[i][j] / 5);
                    }
                }
            }
        }
    }

    static void moveDust() {
        // 역으로 공기청정기로 들어오는 방향부터 로직을 돌린다.
        // 그래야만 먼지가 이동했을 때 한칸이 비게 되고 그 빈자리로 먼지가 이동하게 된다.

        // 왼쪽위
        for (int i = 0; i < airFresherUp -1; i++) {
            board[i+1][0] = board[i][0];
        }

        // 상단
        for (int i = m; i > 0 ; i--) {
            board[0][i-1] = board[0][i];
        }
        // 오른쪽 위
        for (int i = airFresherUp; i >0 ; i--) {
            board[i-1][m] = board[i][m];
        }
        // 하단
        for (int i = 0; i < m - 1; i++) {
            board[airFresherUp][i+1] = board[airFresherUp][i];
        }

        board[airFresherUp][0] =0;
    }
}
