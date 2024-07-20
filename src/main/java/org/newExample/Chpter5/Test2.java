package org.newExample.Chpter5;

import java.util.Scanner;
import java.util.Stack;

public class Test2 {
    public static void main(String[] args) {
        String answer = "";
        Scanner sc = new Scanner(System.in);

        String str = sc.nextLine();
        Stack<Character> stack = new Stack<>();
        for (char x : str.toCharArray()) {
            if (x == ')') {
                while (stack.pop() != '(') ;
            } else stack.push(x);
        }

        for (char ch : stack.stream().toList()){
            if (ch != '(' && ch != ')'){
                System.out.print(ch);
            }
        }
    }
}
