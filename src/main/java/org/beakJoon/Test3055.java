package org.beakJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Test3055 {
    static int n, m, answer = Integer.MAX_VALUE;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    static char[][] board;
    static Queue<Node> queue;
    static Queue<Node> water;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        board = new char[n][m];

        queue = new LinkedList<>();
        water = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            String str = br.readLine();
            for (int j = 0; j < m; j++) {
                char ch = str.charAt(j);
                board[i][j] = ch;
                if (ch == 'S') {
                    queue.offer(new Node(i, j, 0));

                } else if (ch == '*') {
                    water.offer(new Node(i, j, 0));

                }
            }
        }
        bfs();
        if (answer == Integer.MAX_VALUE) {
            System.out.println("KAKTUS");
        } else System.out.println(answer);
    }

    static void bfs() {
        int waterSize = 0;
        while (!queue.isEmpty()) {
            waterSize = water.size();
            for (int w = 0; w < waterSize; w++) {
                Node waterNode = water.poll();
                for (int i = 0; i < 4; i++) {
                    int nx = waterNode.x + dx[i];
                    int ny = waterNode.y + dy[i];

                    if (nx >= 0 && nx < n && ny >= 0 && ny < m) {
                        if (board[nx][ny] == '.') {
                            board[nx][ny] = '*';
                            water.offer(new Node(nx, ny, waterNode.cnt + 1));
                        }
                    }
                }
            }

            int size = queue.size();
            for (int q = 0; q < size; q++) {
                Node tmp = queue.poll();
                for (int i = 0; i < 4; i++) {
                    int nx = tmp.x + dx[i];
                    int ny = tmp.y + dy[i];

                    if (nx >= 0 && nx < n && ny >= 0 && ny < m) {
                        if (board[nx][ny] == 'D') {
                            answer = Math.min(answer, tmp.cnt + 1);
                            return;
                        }
                        if (board[nx][ny] == '.') {
                            board[nx][ny] = 'S';
                            queue.offer(new Node(nx, ny, tmp.cnt + 1));
                        }
                    }
                }
            }

        }


    }

    static class Node {
        int x, y, cnt;

        public Node(int x, int y, int cnt) {
            this.x = x;
            this.y = y;
            this.cnt = cnt;
        }
    }

}
