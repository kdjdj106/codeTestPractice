package org.beakJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Test15653 {
    static int n, m;
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};
    static boolean[][][][] visit;
    static char[][] board;
    static Queue<Position> Q;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        Q = new LinkedList<>();
        board = new char[n][m];
        visit = new boolean[n][m][n][m];
        int redX = 0, redY = 0, blueX = 0, blueY = 0;
        for (int i = 0; i < n; i++) {
            String str = br.readLine();
            for (int j = 0; j < str.length(); j++) {
                char ch = str.charAt(j);
                board[i][j] = ch;
                if (ch == 'R') {
                    redX = i;
                    redY = j;
                }
                if (ch == 'B') {
                    blueX = i;
                    blueY = j;
                }
            }
        }
        visit[redX][redY][blueX][blueY] = true;
        Q.offer(new Position(redX, redY, blueX, blueY, 1));
        System.out.println(bfs());


    }

    static int bfs() {
        while (!Q.isEmpty()) {
            Position tmp = Q.poll();
            visit[tmp.redX][tmp.redY][tmp.blueX][tmp.blueY] = true;
            for (int i = 0; i < 4; i++) {
                Marble redMarble = move(tmp.redX, tmp.redY, i);
                Marble blueMarble = move(tmp.blueX, tmp.blueY, i);

                int nRedX = redMarble.x;
                int nRedY = redMarble.y;
                int nBlueX = blueMarble.x;
                int nBlueY = blueMarble.y;
                int nRedDis = redMarble.dis;
                int nBlueDis = blueMarble.dis;

                if (board[nBlueX][nBlueY] == 'O') continue;
                if (board[nRedX][nRedY] == 'O') {
                    return tmp.cnt;
                }

                if (nRedX == nBlueX && nRedY == nBlueY) {
                    if (nRedDis > nBlueDis) {
                        nRedX -= dx[i];
                        nRedY -= dy[i];
                    } else if (nBlueDis > nRedDis) {
                        nBlueX -= dx[i];
                        nBlueY -= dy[i];
                    }
                }

                if (visit[nRedX][nRedY][nBlueX][nBlueY]) continue;

                Q.offer(new Position(nRedX, nRedY, nBlueX, nBlueY, tmp.cnt+1));
                visit[nRedX][nRedY][nBlueX][nBlueY] = true;
            }
        }
        return -1;
    }

    static Marble move(int x, int y, int i) {
        int dis = 0;
        while (board[x + dx[i]][y + dy[i]] != '#' && board[x][y] != 'O') {
            x += dx[i];
            y += dy[i];
            dis += 1;
        }
        return new Marble(x, y, dis);
    }

    static class Position {
        int redX, redY, blueX, blueY, cnt;

        public Position(int redX, int redY, int blueX, int blueY, int cnt) {
            this.redX = redX;
            this.redY = redY;
            this.blueX = blueX;
            this.blueY = blueY;
            this.cnt = cnt;
        }
    }

    static class Marble {
        int x, y, dis;

        public Marble(int x, int y, int dis) {
            this.x = x;
            this.y = y;
            this.dis = dis;
        }
    }
}
