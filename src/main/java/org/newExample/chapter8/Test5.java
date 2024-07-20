package org.newExample.chapter8;

import java.util.Arrays;
import java.util.Scanner;

public class Test5 {
    static int n;
    static int m;
    static int answer = Integer.MAX_VALUE;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        int[] arr= new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        m = sc.nextInt();
        Arrays.sort(arr);

        DFS(arr, 0, 0);
        System.out.println(answer);
    }
    static void DFS(int[] arr, int sum, int L){
        if (sum > m) return;
        if (L >= answer) return;
        if (sum == m) {
            answer = Math.min(answer, L);
        }else {
            for (int i = n-1; i >=0 ; i--) {
             DFS(arr, sum + arr[i], L+1);
            }
        }
    }
}
