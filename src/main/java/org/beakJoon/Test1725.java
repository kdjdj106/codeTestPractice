package org.beakJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Test1725 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());   //히스토그램 개수
        int[] height = new int[N+2];         //히스토그램 높이

        long answer = 0;
        Stack<Integer> stack = new Stack<>();      //히스토그램 인덱스 담을 스택

        height[0] = 0;   //맨 첫번째 히스토그램까지 포함해서 계산할 때 편리하게
        height[N] = 0;   //반복문 마지막에 스택에 남은 애들을 계산해주기 위해

        for(int i = 1; i <= N; i++)
            height[i] = Integer.parseInt(br.readLine());

        stack.push(0);

        for(int i = 1; i <= N+1; i++) {
            while(!stack.isEmpty()) {
                int top = stack.peek();

                if(height[top] <= height[i])
                    break;

                stack.pop();
                answer = Math.max(answer, height[top] * (i-stack.peek()-1));

            }

            stack.push(i);
        }

        System.out.println(answer);


    }

}
