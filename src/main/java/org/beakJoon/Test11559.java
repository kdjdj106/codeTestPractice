package org.beakJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Test11559 {
    static int answer =0;
    static char[][] board;
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};
    static Queue<Point> Q;

    // 모여있는 뿌요뿌요가 몇개인지 세기위한 리스트
    static ArrayList<int[]> list;
    static boolean flag = true;
    public static void main(String[] args) throws IOException {
        board = new char[12][6];
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        for (int i = 0; i < 12; i++) {
            String str = br.readLine();
            for (int j = 0; j < 6; j++) {
                board[i][j]  = str.charAt(j);
            }
        }
        // 무한으로 돌리되
        // 더이상 터질게 없으면 빠져나온다.
        while (true){
            flag = false;
            bfs();
            onFloor();
            if (!flag) break;
            answer++;
        }
        System.out.println(answer);
    }
    static void bfs(){
        Q = new LinkedList<>();


        // 칸은 정해져있기 때문에 이렇게 만든다.
        boolean[][] visit = new boolean[12][6];
        for (int i = 0; i < 12; i++) {
            for (int j = 0; j < 6; j++) {
                if (board[i][j] != '.' && !visit[i][j]){
                    list = new ArrayList<>();
                    list.add(new int[] {i, j});
                    Q.offer(new Point(i, j, board[i][j]));
                    visit[i][j] = true;


                    while (!Q.isEmpty()){
                        Point tmp = Q.poll();
                        for (int k = 0; k < 4; k++) {
                            int nx = tmp.x + dx[k];
                            int ny = tmp.y + dy[k];

                            if (nx >= 0 && nx < 12 && ny >= 0 && ny < 6 && !visit[nx][ny]){
                                if (board[nx][ny] == tmp.color){
                                    Q.offer(new Point(nx, ny, board[nx][ny]));
                                    list.add(new int[] {nx, ny});
                                    visit[nx][ny] = true;
                                }
                            }
                        }
                    }

                    // 리스트에 4개 이상 모이면 뿌요뿌요를 터트려준다.
                    if (list.size() >= 4){
                        for (int[] arr : list){
                            int nx = arr[0];
                            int ny = arr[1];
                            board[nx][ny] = '.';

                            flag = true;
                        }
                    }
                }
            }
        }

    }
    static void onFloor() {
        // 각 열 마다 내리는 연산 수행함
        for(int j=0; j<6; j++) {
            down(j);
        }
    }

    // 한 열에 있는 뿌요를 바닥까지 내림
    static void down(int j) {
        Queue<Point> puyo = new LinkedList<>();
        int idx = 11;

        /*
         * 뿌요의 위치를 큐에 넣음, 가장 아래에 있는 빈 칸의 인덱스를 구함
         * -> 가장 바닥에 있는 뿌요도 큐에 넣어서 모두 빈 칸으로 만든 뒤
         * 가장 아래부터 큐에 있는 뿌요들을 차례로 채워나감
         */
        for(int i=11; i>=0; i--) {
            if(board[i][j] != '.') {
                puyo.add(new Point(i, j, board[i][j]));
                board[i][j] = '.';
            }
        }
        // 뿌요를 가장 밑에 있는 빈 칸에 채워나감
        while(!puyo.isEmpty()) {
            Point p = puyo.poll();

            char color = p.color;

            board[idx][j] = color;

            idx--;
        }

    }


    static class Point{
        int x, y;
        char color;
        public Point(int x, int y, char color) {
            this.x = x;
            this.y = y;
            this.color = color;
        }
    }
}
