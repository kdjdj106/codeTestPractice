package org.programers.algorismKit.hash;

import java.util.HashMap;

/*폰켓몬

 * */
public class Test1845 {
    public static void main(String[] args) {
        int[] arr  = {3,1,2,3};
        System.out.println(solution(arr));
    }
    static public int solution(int[] nums) {
        int answer = 0;
        int num = nums.length/2;
        HashMap<Integer, Integer> map = new HashMap<>();
        for (Integer i : nums){
            map.put(i, map.getOrDefault(i, 0) + 1);
        }
        if (map.size() >= num) answer = num;
        else {
            answer = map.size();
        }
        return answer;
    }
}
