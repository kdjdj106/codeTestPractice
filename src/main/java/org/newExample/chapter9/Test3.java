package org.newExample.chapter9;

import java.io.PushbackInputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Test3 {
    static int n;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        ArrayList<Friends> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            list.add(new Friends(sc.nextInt(), 'a'));
            list.add(new Friends(sc.nextInt(), 'b'));
        }
        Collections.sort(list);
        int answer = 0;
        int tmp =0;
        for (Friends friends: list){
            if (friends.ch == 'a'){
                answer++;
            }else answer--;
            tmp = Math.max(tmp, answer);
        }
        System.out.println(tmp);
    }
    public static class Friends implements Comparable<Friends>{
        int x;
        char ch;
        public Friends(int x, char ch){
            this.x = x;
            this.ch = ch;
        }

        @Override
        public int compareTo(Friends o) {
            if (this.x == o.x){
                return o.ch - this.ch;
            }else return this.x - o.x;
        }
    }
}
