package org.newExample.Chpter5;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Test8 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int answer = 1;
        Queue<Person> queue = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            int a = sc.nextInt();
            queue.offer(new Person(a, i));
        }

        while (!queue.isEmpty()) {
            Person tmp = queue.poll();
            for (Person p : queue) {
                if (tmp.priority < p.priority) {
                    queue.offer(tmp);
                    tmp = null;
                    break;
                }
            }
            if (tmp != null) {
                if (tmp.number == m) System.out.println(answer);
                else answer++;

            }
        }


    }

    public static class Person {
        int priority;
        int number;

        public Person(int priority, int number) {
            this.priority = priority;
            this.number = number;
        }
    }
}
