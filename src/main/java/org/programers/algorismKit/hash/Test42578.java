package org.programers.algorismKit.hash;

import java.util.HashMap;

/*의상*/
public class Test42578 {
    public static void main(String[] args) {
        String[][] arr = {{"a", "A"} ,{"b", "B"},{"c", "C"}};
        System.out.println(solution(arr));
    }
    static  public int solution(String[][] clothes) {
        int answer = 0;
        HashMap<String, Integer> map = new HashMap<>();
        for (String[] cloth : clothes) {
            String where = cloth[1];
            map.put(where, map.getOrDefault(where, 0) + 1);
        }
        answer = clothes.length;
        int n=1;
        if (map.size() == 1) return answer;
        else {
            for (Integer i : map.values()) {
                n *= (i+1);
            }
        }

        return  n-1;
    }
}
