package org.programers.algorismKit.ExhaustiveSearch;
/*
* 소수 찾기
* https://school.programmers.co.kr/learn/courses/30/lessons/42839
* */
public class Test42839 {
    public static void main(String[] args) {
        System.out.println(solution("17"));
    }
    static public int solution(String numbers) {
        int answer = 0;
        int[] num = new int[numbers.length()];
        for (int i = 0; i < numbers.length(); i++) {
            num[i] = numbers.charAt(i) - '0';
        }


        return answer;
    }
    static boolean prime(int n) {
        if(n<2) return false;

        for(int i=2; i <= Math.sqrt(n); i++) {
            if(n % i == 0) return false;
        }

        return true;
    }
}
