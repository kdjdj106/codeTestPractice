package org.newExample.chpater7;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Test8 {
    static int[] move = {-1, 1, 5};
    static int[] ch;
    static int answer = 0;
    static Queue<Integer> Q = new LinkedList<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        System.out.println(BFS(n, m));

    }

    public static int BFS(int n, int m) {
        ch = new int[10001];
        Q.offer(n);
        int L = 0;
        while (!Q.isEmpty()) {
            int length = Q.size();
            for (int i = 0; i < length; i++) {
                int position = Q.poll();
                if (position == m) return L;
                for (int j = 0; j < move.length; j++) {
                    int movedPosition = position + move[j];
                    if (movedPosition > 0 && movedPosition < 10001 && ch[movedPosition] == 0) {
                        ch[movedPosition] = 1;
                        Q.offer(movedPosition);
                    }
                }
            }
            L++;
        }
        return 0;
    }
}
