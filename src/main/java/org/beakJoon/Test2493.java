package org.beakJoon;

import java.util.Scanner;
import java.util.Stack;

public class Test2493 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Stack<Tower> stack = new Stack<>();
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < n; i++) {
            int tmpTower  = sc.nextInt();

            if (stack.isEmpty()){
                sb.append(0 + " ");
                stack.push(new Tower(i+1, tmpTower));
            }else {
                int prevTower = stack.peek().height;
                if (prevTower > tmpTower){
                    sb.append(stack.peek().idx).append(" ");
                    stack.push(new Tower(i+1, tmpTower));
                }else {
                    stack.pop();
                }
            }
        }
        System.out.println(sb);
    }
    public static class Tower{
        int idx, height;
        public Tower(int idx, int height){
            this.idx = idx;
            this.height = height;
        }
    }
}
