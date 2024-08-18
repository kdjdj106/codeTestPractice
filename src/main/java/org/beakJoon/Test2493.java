package org.beakJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.Stack;
import java.util.StringTokenizer;

public class Test2493 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        Stack<Tower> stack = new Stack<>();
        StringBuilder sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            int tmpTower  = Integer.parseInt(st.nextToken());

            if (stack.isEmpty()){
                sb.append(0 + " ");
                stack.push(new Tower(i+1, tmpTower));
            }else {
                while(true){
                    if (stack.isEmpty()){
                        sb.append(0 + " ");
                        stack.push(new Tower(i+1, tmpTower));
                        break;
                    }
                    int prevTower = stack.peek().height;
                    if (prevTower > tmpTower){
                        sb.append(stack.peek().idx).append(" ");
                        stack.push(new Tower(i+1, tmpTower));
                        break;
                    }else {
                        stack.pop();
                    }
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
