package org.example.chapter4.HashMap_HashSet_TreeSet;
/*

모든 아나그램 찾기(해쉬, 투포인터, 슬라이딩 윈도우)
        S문자열에서 T문자열과 아나그램이 되는 S의 부분문자열의 개수를 구하는 프로그램을 작성하
        세요. 아나그램 판별시 대소문자가 구분됩니다. 부분문자열은 연속된 문자열이어야 합니다.
        ▣ 입력설명
        첫 줄에 첫 번째 S문자열이 입력되고, 두 번째 줄에 T문자열이 입력됩니다.
        S문자열의 길이는 10,000을 넘지 않으며, T문자열은 S문자열보다 길이가 작거나 같습니다.
        ▣ 출력설명
        S단어에 T문자열과 아나그램이 되는 부분문자열의 개수를 출력합니다.
        ▣ 입력예제 1
        bacaAacba
        abc
        ▣ 출력예제 1
        3
        출력설명: {bac}, {acb}, {cba} 3개의 부분문자열이 "abc"문자열과 아나그램입니다.
        ▣ 입력예제 2
        bacaAacbaa
        abca
        ▣ 출력예제 2
        3
*/

import java.util.HashMap;
import java.util.Scanner;

public class Quiz4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s1 = sc.nextLine();
        String s2 = sc.nextLine();
        int answer = 0;
        HashMap<Character, Integer> map1 = new HashMap<>();
        HashMap<Character, Integer> map2 = new HashMap<>();
        for (char c : s2.toCharArray()) {
            map2.put(c, map2.getOrDefault(c, 0) + 1);
        }

        for (int i = 0; i < s2.length(); i++) {
            map1.put(s1.charAt(i), map1.getOrDefault(s1.charAt(i), 0) + 1);
        }
        if (map1.equals(map2)) answer++;

        int lt = 0;
        for (int rt = s2.length(); rt < s1.length(); rt++) {
            map1.put(s1.charAt(rt), map1.getOrDefault(s1.charAt(rt), 0) + 1);
            map1.put(s1.charAt(lt), map1.get(s1.charAt(lt)) - 1);
            if (map1.get(s1.charAt(lt)) == 0) map1.remove(s1.charAt(lt));
            if (map1.equals(map2)) answer++;
            lt++;
        }
        System.out.println(answer);
    }
}
