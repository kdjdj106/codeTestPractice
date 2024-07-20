package org.newExample.Chpter5;

import java.util.Arrays;
import java.util.Scanner;

public class Test10 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();

        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        Arrays.sort(arr);
        int answer =0;
        int lt = 1;
        int rt = arr[n-1];
        while (lt <= rt){
            int mid = (lt + rt) / 2;
            if (count(arr, mid) >=m){
               answer = mid;
               lt = mid+1;
            }else rt = mid -1;
        }
        System.out.println(answer);
    }

    private static int count(int[] arr, int mid) {
        int cnt =1;
        int lastPosition = arr[0];

        for (int i = 1; i < arr.length; i++) {
            if (arr[i] - lastPosition >= mid){
                lastPosition = arr[i];
                cnt++;
            }
        }
        return cnt;
    }
}
