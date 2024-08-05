package org.beakJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Test17140 {
    static int eX, eY, eNum, answer = 0;
    static ArrayList<Point> boardList;
    static Map<Integer, Integer> map;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        eX = Integer.parseInt(st.nextToken()) - 1;
        eY = Integer.parseInt(st.nextToken()) - 1;
        eNum = Integer.parseInt(st.nextToken());

        int[][] board = new int[100][100];
        map = new HashMap<Integer, Integer>();
        for (int i = 0; i < 3; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 3; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        int x = 3, y = 3;
        boardList = new ArrayList<>();
        while (true) {
            if (board[eX][eY] == eNum) {
                break;
            }
            if (answer > 100) {
                answer = -1;
                break;
            }
            int[][] tmpBoard = new int[100][100];
            if (x >= y) {
                for (int i = 0; i < x; i++) {
                    for (int j = 0; j < y; j++) {
                        if (board[i][j] != 0)
                            map.put(board[i][j], map.getOrDefault(board[i][j], 0) + 1);
                    }
                    if (map.isEmpty()) continue;
                    for (Integer key : map.keySet()) {
                        boardList.add(new Point(key, map.get(key)));
                    }
                    Collections.sort(boardList);
                    int index = 0;
                    for (Point p : boardList) {
                        tmpBoard[i][index++] = p.num;
                        tmpBoard[i][index++] = p.cnt;
                    }
                    y = Math.max(y, boardList.size() *2);
                    map.clear();
                    boardList.clear();
                }

            } else {
                for (int i = 0; i < y; i++) {
                    for (int j = 0; j < x; j++) {
                        if (board[j][i] != 0)
                            map.put(board[j][i], map.getOrDefault(board[j][i], 0) + 1);
                    }
                    if (map.isEmpty()) continue;
                    for (Integer key : map.keySet()) {
                        boardList.add(new Point(key, map.get(key)));
                    }
                    Collections.sort(boardList);
                    int index = 0;
                    for (Point p : boardList) {
                        tmpBoard[index++][i] = p.num;
                        tmpBoard[index++][i] = p.cnt;
                    }
                    x = Math.max(x, boardList.size() *2);
                    map.clear();
                    boardList.clear();
                }
            }
            answer++;
            board = tmpBoard;
        }
        System.out.println(answer);
    }

    static class Point implements Comparable<Point>{
        int num, cnt;

        public Point(int num, int cnt) {
            this.num = num;
            this.cnt = cnt;
        }

        @Override
        public int compareTo(Point o) {
            if (this.cnt == o.cnt) {
                return this.num - o.num;
            } else
                return this.cnt - o.cnt;
        }
    }
}
