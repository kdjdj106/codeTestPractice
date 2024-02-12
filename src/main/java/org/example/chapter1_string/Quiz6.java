package org.example.chapter1_string;

import java.util.Scanner;

public class Quiz6 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < str.length(); i++) {
            if (str.indexOf(str.charAt(i)) == i){
                sb.append(str.charAt(i));
            }
        }
        System.out.println(sb.toString());
    }
}
