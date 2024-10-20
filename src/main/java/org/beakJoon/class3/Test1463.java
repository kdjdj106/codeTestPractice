package org.beakJoon.class3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Test1463 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int a = Integer.parseInt(br.readLine());
        int cnt = 0;

        while (a != 1){
            if (a == 1) break;

            if (a %3 == 0){
                a /= 3;
                cnt++;
            } else if (a % 2 == 0) {
                a /= 2;
                cnt++;
            }else break;
        }
        System.out.println(cnt);
    }
}
