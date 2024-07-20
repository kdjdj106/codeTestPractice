package org.newExample.chapter9;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Test2 {
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        int n = sc.nextInt();
        ArrayList<Office> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            list.add(new Office(sc.nextInt(), sc.nextInt()));
        }
        Collections.sort(list);
        int firstTime =0;
        int cnt =0;
        for (Office office : list){

            if (office.startTime >= firstTime){
                cnt++;
                firstTime = office.endTime;
            }
        }
        System.out.println(cnt);
    }
    public static class Office implements Comparable<Office>{
        int startTime;
        int endTime;

        public Office(int startTime, int endTime) {
            this.startTime = startTime;
            this.endTime = endTime;
        }

        @Override
        public int compareTo(Office o) {
            if (o.endTime == this.endTime){
                return this.startTime - o.startTime;

            }else return this.endTime - o.endTime;
        }
    }
}
