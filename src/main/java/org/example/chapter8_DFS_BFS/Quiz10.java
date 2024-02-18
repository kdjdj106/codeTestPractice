package org.example.chapter8_DFS_BFS;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/*미로의 최단거리 통로(BFS)
        7*7 격자판 미로를 탈출하는 최단경로의 길이를 출력하는 프로그램을 작성하세요. 경로의 길
        이는 출발점에서 도착점까지 가는데 이동한 횟수를 의미한다. 출발점은 격자의 (1, 1) 좌표이
        고, 탈출 도착점은 (7, 7)좌표이다. 격자판의 1은 벽이고, 0은 도로이다.
        격자판의 움직임은 상하좌우로만 움직인다. 미로가 다음과 같다면
        위와 같은 경로가 최단 경로의 길이는 12이다.
        ▣ 입력설명
        첫 번째 줄부터 7*7 격자의 정보가 주어집니다.
        ▣ 출력설명
        첫 번째 줄에 최단으로 움직인 칸의 수를 출력한다. 도착할 수 없으면 -1를 출력한다.
        ▣ 입력예제 1
        0 0 0 0 0 0 0
        0 1 1 1 1 1 0
        0 0 0 1 0 0 0
        1 1 0 1 0 1 1
        1 1 0 1 0 0 0
        1 0 0 0 1 0 0
        1 0 1 0 0 0 0
        ▣ 출력예제 1
        12
*/
public class Quiz10 {
    static class Point {
        int x;
        int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    static int[][] board, dis;
    static Queue<Point> queue = new LinkedList<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        board = new int[8][8];
        dis = new int[8][8];
        for (int i = 1; i < board.length; i++) {
            for (int j = 1; j < board.length; j++) {
                board[i][j] = sc.nextInt();
            }
        }
        BFS(1, 1);
        int answer = dis[7][7];
        System.out.println(answer);
    }

    public static void BFS(int x, int y){
        Queue<Point> Q=new LinkedList<>();
        Q.offer(new Point(x, y));
        board[x][y]=1;
        while(!Q.isEmpty()){
            Point tmp=Q.poll();
            for(int i=0; i<4; i++){
                int nx=tmp.x+dx[i];
                int ny=tmp.y+dy[i];
                if(nx>=1 && nx<=7 && ny>=1 && ny<=7 && board[nx][ny]==0){
                    board[nx][ny]=1;
                    Q.offer(new Point(nx, ny));
                    dis[nx][ny]=dis[tmp.x][tmp.y]+1;
                }
            }
        }
    }
}
