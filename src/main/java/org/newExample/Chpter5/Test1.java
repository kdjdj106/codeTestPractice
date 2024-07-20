package org.newExample.Chpter5;

import java.util.Scanner;
import java.util.Stack;

public class Test1 {
    public static void main(String[] args) {
        String answer = "YES";
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();

        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if (ch == '(') stack.push(ch);
            else {
                if (stack.isEmpty()){
                    answer = "NO";
                    break;
                }
                stack.pop();
            }
        }
        if (!stack.isEmpty()) answer = "NO";
        System.out.println(answer);
    }
}
