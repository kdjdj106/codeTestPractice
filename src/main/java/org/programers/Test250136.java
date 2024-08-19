package org.programers;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class Test250136 {
    static int n, m;
    static int[][] board;
    static boolean[][] visit;
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};
    static int sum =0;
    static Set<Integer> set;
    static int[] arr;
    static Queue<Node> Q;

    public static void main(String[] args) {
        board = new int[][]{{0, 0, 0, 1, 1, 1, 0, 0}, {0, 0, 0, 0, 1, 1, 0, 0}, {1, 1, 0, 0, 0, 1, 1, 0}, {1, 1, 1, 0, 0, 0, 0, 0}, {1, 1, 1, 0, 0, 0, 1, 1}};
        System.out.println(solution(board));


    }

    static public int solution(int[][] land) {
        board = land;
        int answer = 0;
        n = land.length;
        m = land[0].length;
        visit = new boolean[n][m];
        arr = new int[m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (land[i][j] == 1 && !visit[i][j]) {
                    set = new HashSet<>();
                    bfs(i, j);
                    for (Integer num : set){
                        arr[num] += sum;
                    }
                    sum =0;
                }
            }

        }
        for (Integer num : arr){
            answer  = Math.max(answer, num);
        }
        return answer;
    }
    static void bfs(int x, int y) {
        Q = new LinkedList<>();
        set.add(y);
        Q.offer(new Node(x, y));
        visit[x][y] = true;
        sum += board[x][y];

        while (!Q.isEmpty()) {
            Node tmp = Q.poll();
            for (int i = 0; i < 4; i++) {
                int nx = tmp.x + dx[i];
                int ny = tmp.y + dy[i];
                if (nx >= 0 && nx < n && ny >= 0 && ny < m && board[nx][ny] == 1 && !visit[nx][ny]) {
                    visit[nx][ny] = true;
                    sum += board[nx][ny];
                    set.add(ny);
                    Q.offer(new Node(nx, ny));
                }
            }
        }
    }
    static class Node{
        int x, y;
        public Node(int x, int y){
            this.x = x;
            this.y = y;
        }
    }


}
