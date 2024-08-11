package org.beakJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Test14890 {
    static int n, m;
    static int[][] board;
    static int answer =0;
    static int[] ROAD;
    static boolean[] visitROAD;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        board = new int[n][n];


        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        for (int i = 0; i < n; i++) {
            if (calc(i, 1)) answer++;
            if (calc(i, 0)) answer++;
        }
        System.out.println(answer);
    }
    static boolean calc(int x, int flag){
        ROAD = new int[n];
        visitROAD = new boolean[n];
        // 가로줄을 ROAD배열에 담는다
        if (flag == 1){
            for (int i = 0; i < n; i++) {
                ROAD[i] = board[x][i];
            }
        }
        // 세로줄을 ROAD배열에 담는다
        else {
            for (int i = 0; i < n; i++) {
                ROAD[i] = board[i][x];
            }
        }
        for (int i = 0; i < n - 1; i++) {
            // 현재길의 높이와 다음칸의 높이차이를 구한다.
            int diff =ROAD[i] - ROAD[i+1];
            // 높이 차이가 2 이상이면 길을 만들수 없기 때문에 false
            if (Math.abs(diff) >1) return false;
            // 높이 차이가 0이면 경사로를 놓을필요가 없기 때문에 continue;
            if (diff == 0) continue;

            // 현재 높이가 다음칸보다 1칸 높으면 내리막 경사로를 설치할수 있는지 체크
            if (diff == 1){
                for (int j = i+1; j <= i+m; j++) {
                    if (!isIn(j) || ROAD[i+1] != ROAD[j] || visitROAD[j])return  false;
                    else visitROAD[j] = true;
                }
                // 경사로를 설치한 구간만큼 i를 증가 (경사로를 설치한 구간을 또 검사할필요는 없기때문)
                i = i + m-1;
            }
            // 오르막일때
            else if (diff == -1){
                // 오르막 일때는 앞구간을 검사하는것이 아니라 이미 지나온 구간을 m 만큼 다시 검사한다.
                for (int j = i; j > i-m; j--) {
                    if (!isIn(j) || ROAD[i] != ROAD[j] || visitROAD[j])return  false;
                    else visitROAD[j] = true;
                }
            }
        }

        return true;
    }
    public static boolean isIn(int num){
        return 0<=num && num<n;
    }
}
