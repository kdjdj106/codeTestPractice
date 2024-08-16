package org.beakJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Test103 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        int answer = 0;
        int lp = 0;
        int rp = 1;

        while (rp <= n) {
            if (rp == n) {
                for (int i = lp; i < rp; i++) {
                    answer = Math.max(answer, arr[lp] * (rp - i));
                    lp++;
                }
                break;
            } else if (arr[rp - 1] <= arr[rp]) {
                rp++;
                continue;
            } else {
                for (int i = lp; i < rp; i++) {
                    answer = Math.max(answer, arr[lp] * (rp - i));
                    lp++;
                }
                lp = rp;
            }
            rp++;
        }
        System.out.println(answer);
    }

}
