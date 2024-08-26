package org.programers.algorismKit.hash;

import java.util.HashMap;
/*완주하지 못한 선수
*
* */
public class Test42576 {
    public static void main(String[] args) {
        String[] arr1 = {"mislav", "stanko", "mislav", "ana"};
        String[] arr2 = {"stanko", "ana", "mislav"};
        System.out.println(solution(arr1, arr2));
    }
    static public String solution(String[] participant, String[] completion) {
        String answer = "";
        HashMap<String, Integer> map = new HashMap<String, Integer>();
        for (String s : participant) {
            map.put(s, map.getOrDefault(s, 0)+1);
        }
        for (String s : completion) {
            map.put(s, map.getOrDefault(s, 0)-1);
        }
        for (String s : map.keySet()){
            if (map.get(s) > 0){
                answer += s;
            }
        }
        return answer;
    }
}
