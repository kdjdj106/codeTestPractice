package org.newExample.chapter9;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Test1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        ArrayList<Person> list = new ArrayList<>();
        int answer =0;
        for (int i = 0; i < n; i++) {
            list.add(new Person(sc.nextInt(), sc.nextInt()));
        }
        Collections.sort(list);
        int maxWeight = Integer.MIN_VALUE;
        for (Person p : list){
            if (p.weight > maxWeight){
                answer++;
                maxWeight = p.weight;
            }
        }
        System.out.println(answer);
    }
    public static class Person implements Comparable<Person>{
        int height;
        int weight;
        public Person(int height, int weight){
            this.height = height;
            this.weight = weight;
        }

        @Override
        public int compareTo(Person o) {
            return o.height -this.height;
        }
    }
}
