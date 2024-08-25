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
            // board가 static으로 걸려있기 때문에 계산 해줄 tmp보드를 만들었다.
            // 매 초 계산 해야되기 때문에 매초 초기화를 해준다.
            tmpBoard = new int[n][m];
            // 미세먼지 확산
            diffusionDust();
           board = tmpBoard;
            // 공기청정기로 공기이동
            moveDust();
        }
        int answer = 2;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                answer += board[i][j];
            }
        }
        System.out.println(answer);
    }

    // 미세먼지 확산 함수
    static void diffusionDust() {

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                // 공기 청정기는 찾으면 continue해준다.
                if (board[i][j] == -1) {
                    tmpBoard[i][j] = -1;
                    continue;
                }

                // 보드의 먼지를 옮겨담는다.
                tmpBoard[i][j] += board[i][j];

                // 4방향으로 먼지를 확산시킨다.
                for (int k = 0; k < 4; k++) {
                    int nx = i + dx[k];
                    int ny = j + dy[k];

                    // 공기청정기거나 범위에 맞지 않는다면 생략
                    if (ny < 0 || ny >= m || nx < 0 || nx >= n) continue;
                    if (board[nx][ny] == -1) continue;


                    //확산될 tmpBoard에 board의 먼지 1/5를 넣어주고
                    tmpBoard[nx][ny] += (board[i][j] / 5);

                    //기존 위치에서는 board의 1/5를 빼준다.
                    tmpBoard[i][j] -= (board[i][j] / 5);
                }
            }
        }
    }

    static void moveDust() {
        // 역으로 공기청정기로 들어오는 방향부터 로직을 돌린다.
        // 그래야만 먼지가 이동했을 때 한칸이 비게 되고 그 빈자리로 먼지가 이동하게 된다.
        // 왼쪽위
        for (int i = airFresherUp - 1; i > 0; i--) {
            board[i][0] = board[i - 1][0];
        }

        // 상단
        for (int i = 0; i < m - 1; i++) {
            board[0][i] = board[0][i + 1];
        }
        // 오른쪽 위
        for (int i = 0; i < airFresherUp - 1; i++) {
            board[i][m - 1] = board[i + 1][m - 1];
        }
        // 하단
        for (int i = m - 1; i > 0; i--) {
            board[airFresherUp - 1][i] = board[airFresherUp - 1][i - 1];
        }

        // 공기 청정기 위치에는 흡입구는 -1
        // 나가는 쪽은 0
        board[airFresherUp - 1][0] = -1;
        board[airFresherUp - 1][1] = 0;



        // 왼쪽 아래
        for (int i = airFresherDown - 1; i < n - 1; i++) {
            board[i][0] = board[i + 1][0];
        }

        // 하단
        for (int i = 0; i < m - 1; i++) {
            board[n - 1][i] = board[n - 1][i + 1];
        }


        // 오른쪽 아래
        for (int i = n - 1; i > airFresherDown - 1; i--) {
            board[i][m - 1] = board[i - 1][m - 1];
        }

        // 상단
        for (int i = m - 1; i > 0; i--) {
            board[airFresherDown - 1][i] = board[airFresherDown - 1][i - 1];
        }

        // 공기 청정기 위치에는 흡입구는 -1
        // 나가는 쪽은 0
        board[airFresherDown - 1][0] = -1;
        board[airFresherDown - 1][1] = 0;
    }
}
