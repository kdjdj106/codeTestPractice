package org.programers.algorismKit.sort;

import java.util.Arrays;
/*가장 큰 수
 */
public class Test42746 {
    public static void main(String[] args) {
        int[] arr = {3, 30, 34, 5, 9};
        System.out.println(solution(arr));
    }
    static public String solution(int[] numbers) {
        String answer = "";
        String[] arr = new String[numbers.length];
        for (int i = 0; i < numbers.length; i++) {
            arr[i] = String.valueOf(numbers[i]);
        }
        Arrays.sort(arr, (o1, o2) -> (o2 + o1).compareTo(o1 + o2));

        if (arr[0].equals("0")) {
            return "0";
        }
        return String.join("", arr);
    }
}
