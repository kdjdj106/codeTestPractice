package org.newExample.chapter8;

import java.util.Arrays;
import java.util.Scanner;

public class Test1 {
    static int[] arr;
    static String answer = "NO";
    static int n;
    static int total;
    static boolean flag = false;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
         n = sc.nextInt();
         arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        total = Arrays.stream(arr).sum();
        DFS(arr, 0, 0);
        System.out.println(answer);
    }
    public static void DFS(int[] arr, int L, int sum){
        if (flag) return;
        if (L == n){
            if ((total - sum) == sum){
                flag = true;
                answer = "YES";
            }
        }
        else {
            DFS(arr, L+1, sum + arr[L]);
            DFS(arr, L+1, sum );
        }
    }
}
