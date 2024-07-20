package org.newExample.chapter8;

import java.util.ArrayList;
import java.util.Scanner;

public class Test14 {
    static int[][] board;
    static int[] combi;
    static int n, m;
    static ArrayList<Point> houseList, pizzaList;
    static int answer = Integer.MAX_VALUE;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        houseList = new ArrayList<>();
        pizzaList = new ArrayList<>();
        combi = new int[m];
        board = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int tmp = sc.nextInt();
                if (tmp == 1) houseList.add(new Point(i, j));
                else if (tmp == 2) pizzaList.add(new Point(i, j));
            }
        }
        DFS(0, 0);
        System.out.println(answer);
    }

    public static void DFS(int L, int s) {
        if (L == m) {
            int sum = 0;
            for (Point point : houseList) {
                int distance = Integer.MAX_VALUE;
                for(int i : combi){
                    distance=Math.min(distance, Math.abs(point.x-pizzaList.get(i).x)+Math.abs(point.y-pizzaList.get(i).y));
                }
                sum += distance;
            }
            answer = Math.min(sum, answer);
        } else {
            for(int i=s; i<pizzaList.size(); i++){
                combi[L]=i;
                DFS(L+1, i+1);
            }
        }
    }




    public static class Point {
        int x;
        int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
