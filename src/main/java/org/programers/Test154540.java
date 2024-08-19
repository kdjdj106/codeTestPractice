package org.programers;

import java.util.ArrayList;
import java.util.Collections;

/*
무인도 여행

메리는 여름을 맞아 무인도로 여행을 가기 위해 지도를 보고 있습니다. 지도에는 바다와 무인도들에 대한 정보가 표시돼 있습니다.
지도는 1 x 1크기의 사각형들로 이루어진 직사각형 격자 형태이며, 격자의 각 칸에는 'X' 또는 1에서 9 사이의 자연수가 적혀있습니다.
지도의 'X'는 바다를 나타내며, 숫자는 무인도를 나타냅니다. 이때, 상, 하, 좌, 우로 연결되는 땅들은 하나의 무인도를 이룹니다.
지도의 각 칸에 적힌 숫자는 식량을 나타내는데, 상, 하, 좌, 우로 연결되는 칸에 적힌 숫자를 모두 합한 값은 해당 무인도에서 최대 며칠동안 머물 수 있는지를 나타냅니다.
어떤 섬으로 놀러 갈지 못 정한 메리는 우선 각 섬에서 최대 며칠씩 머물 수 있는지 알아본 후 놀러갈 섬을 결정하려 합니다.

지도를 나타내는 문자열 배열 maps가 매개변수로 주어질 때, 각 섬에서 최대 며칠씩 머무를 수 있는지 배열에 오름차순으로 담아 return 하는 solution 함수를 완성해주세요.
만약 지낼 수 있는 무인도가 없다면 -1을 배열에 담아 return 해주세요.

* */
public class Test154540 {
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};
    static int[][] board;
    static ArrayList<Integer> list;
    static int n, m, sum;

    public static void main(String[] args) {
        String[] maps = new String[]{"X591X", "X1X5X", "X231X", "1XXX1"};
        solution(maps);
    }

    static public int[] solution(String[] maps) {
        int[] answer = {};
        n = maps.length;
        m = maps[0].length();
        board = new int[n][m];
        for (int i = 0; i < n; i++) {
            String str = maps[i];
            for (int j = 0; j < m; j++) {
                char ch = str.charAt(j);
                if (ch != 'X') board[i][j] = Integer.parseInt(String.valueOf(ch));
                else board[i][j] = 0;
            }
        }
        list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (board[i][j] != 0){
                    sum = board[i][j];
                    dfs(i, j);
                    list.add(sum);
                    sum =0;
                }
            }
        }
        if (list.isEmpty()) return new int[] {-1};
        Collections.sort(list);
        answer = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            answer[i] = list.get(i);
        }

        return answer;
    }

    static void dfs(int x, int y) {
        board[x][y] = 0;
        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (nx >= 0 && nx < n && ny >= 0 && ny < m && board[nx][ny] != 0){
                sum += board[nx][ny];
                board[nx][ny] =0;
                dfs(nx, ny);
            }
        }
    }
}
