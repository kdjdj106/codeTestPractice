package org.beakJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/*
문제
스타트링크에서 판매하는 어린이용 장난감 중에서 가장 인기가 많은 제품은 구슬 탈출이다. 구슬 탈출은 직사각형 보드에 빨간 구슬과 파란 구슬을 하나씩 넣은 다음, 빨간 구슬을 구멍을 통해 빼내는 게임이다.

보드의 세로 크기는 N, 가로 크기는 M이고, 편의상 1×1크기의 칸으로 나누어져 있다. 가장 바깥 행과 열은 모두 막혀져 있고, 보드에는 구멍이 하나 있다. 빨간 구슬과 파란 구슬의 크기는 보드에서 1×1크기의 칸을 가득 채우는 사이즈이고, 각각 하나씩 들어가 있다. 게임의 목표는 빨간 구슬을 구멍을 통해서 빼내는 것이다. 이때, 파란 구슬이 구멍에 들어가면 안 된다.

이때, 구슬을 손으로 건드릴 수는 없고, 중력을 이용해서 이리 저리 굴려야 한다. 왼쪽으로 기울이기, 오른쪽으로 기울이기, 위쪽으로 기울이기, 아래쪽으로 기울이기와 같은 네 가지 동작이 가능하다.

각각의 동작에서 공은 동시에 움직인다. 빨간 구슬이 구멍에 빠지면 성공이지만, 파란 구슬이 구멍에 빠지면 실패이다. 빨간 구슬과 파란 구슬이 동시에 구멍에 빠져도 실패이다. 빨간 구슬과 파란 구슬은 동시에 같은 칸에 있을 수 없다. 또, 빨간 구슬과 파란 구슬의 크기는 한 칸을 모두 차지한다. 기울이는 동작을 그만하는 것은 더 이상 구슬이 움직이지 않을 때 까지이다.

보드의 상태가 주어졌을 때, 10번 이하로 빨간 구슬을 구멍을 통해 빼낼 수 있는지 구하는 프로그램을 작성하시오.

입력
첫 번째 줄에는 보드의 세로, 가로 크기를 의미하는 두 정수 N, M (3 ≤ N, M ≤ 10)이 주어진다. 다음 N개의 줄에 보드의 모양을 나타내는 길이 M의 문자열이 주어진다. 이 문자열은 '.', '#', 'O', 'R', 'B' 로 이루어져 있다. '.'은 빈 칸을 의미하고, '#'은 공이 이동할 수 없는 장애물 또는 벽을 의미하며, 'O'는 구멍의 위치를 의미한다. 'R'은 빨간 구슬의 위치, 'B'는 파란 구슬의 위치이다.

입력되는 모든 보드의 가장자리에는 모두 '#'이 있다. 구멍의 개수는 한 개 이며, 빨간 구슬과 파란 구슬은 항상 1개가 주어진다.

출력
파란 구슬을 구멍에 넣지 않으면서 빨간 구슬을 10번 이하로 움직여서 빼낼 수 있으면 1을 없으면 0을 출력한다.

예제 입력 1
5 5
#####
#..B#
#.#.#
#RO.#
#####
예제 출력 1
1
* */
public class Test13460 {
    static int n, m;
    static char[][] board;
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};
    static boolean[][][][] visit;
    static Queue<Position> Q;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        int redX =0, redY=0, blueX=0, blueY=0;
        board = new char[n][m];
        visit = new boolean[n][m][n][m];
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
        Q = new LinkedList<>();
        Position position = new Position(redX, redY, blueX, blueY, 1);
        visit[redX][redY][blueX][blueY] = true;
        Q.offer(position);
        System.out.println(bfs());
    }
    public static int bfs(){
        while (!Q.isEmpty()){
            Position tmp = Q.poll();
            if (tmp.cnt > 10) return -1;

            for (int i = 0; i < 4; i++) {
                Marble redMarble = move(tmp.redX, tmp.redY, i, 0);
                Marble blueMarble = move(tmp.blueX, tmp.blueY, i, 0);

                int nRedX = redMarble.X;
                int nRedY = redMarble.Y;
                int nRedDis = redMarble.dis;
                int nBlueX = blueMarble.X;
                int nBlueY = blueMarble.Y;
                int nBlueDis = blueMarble.dis;

                if (board[nBlueX][nBlueY] == 'O') continue;
                if (board[nRedX][nRedY] == 'O'){
                    return tmp.cnt;
                }

                if (nRedX == nBlueX && nRedY == nBlueY){
                    if (nRedDis> nBlueDis){
                        nRedX -= dx[i];
                        nRedY -= dy[i];
                    }else if(nBlueDis > nRedDis){
                        nBlueX -= dx[i];
                        nBlueY -= dy[i];
                    }
                }
                if (visit[nRedX][nRedY][nBlueX][nBlueY]) continue;

                visit[nRedX][nRedY][nBlueX][nBlueY] = true;
                Q.offer(new Position(nRedX, nRedY, nBlueX, nBlueY, tmp.cnt+1));
            }
        }

        return 0;
    }
    public static Marble move(int x, int y, int i, int dis){
        while (board[x+dx[i]][y+dy[i]] != '#' && board[x][y] != 'O'){
            x += dx[i];
            y += dy[i];
            dis +=1;
        }

        // 밑 코드를 써도 상관없음 위 코드를 풀어놓은것 뿐
        /*
        while (true){
            x += dx[i];
            y += dy[i];
            dis +=1;
            if (board[x][y] == '#'){
                x -= dx[i];
                y -= dy[i];
                dis -= 1;
                return new Marble(x, y, dis);
            } else if (board[x][y] == 'O') {
                return new Marble(x, y, dis);
            }
        }
        */
        return new Marble(x, y, dis);
    }
    public static class Position{
        int redX, redY, blueX, blueY, cnt;

        public Position(int redX, int redY, int blueX, int blueY, int cnt) {
            this.redX = redX;
            this.redY = redY;
            this.blueX = blueX;
            this.blueY = blueY;
            this.cnt = cnt;
        }
    }

    public static class Marble {
        int X, Y, dis;

        public Marble(int X, int Y, int dis) {
            this.X = X;
            this.Y = Y;
            this.dis = dis;
        }
    }
}
