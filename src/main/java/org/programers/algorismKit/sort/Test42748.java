package org.programers.algorismKit.sort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.logging.Logger;

/*K번째수
 */
public class Test42748 {
    static Logger logger = Logger.getLogger(Test42748.class.getName());
    public static void main(String[] args) {
        int[] arr = {1, 5, 2, 6, 3, 7, 4};
        int[][] arr2 ={{2, 5, 3}, {4, 4, 1}, {1, 7, 3}};
        logger.info("answer: " + Arrays.toString(solution(arr, arr2)));
    }
    static public int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];
        for (int i = 0; i < commands.length; i++) {
            ArrayList<Integer> list = new ArrayList<>();
            for (int j = commands[i][0]-1; j < commands[i][1]; j++) {
                list.add(array[j]);
            }
            Collections.sort(list);
            int a = list.get(commands[i][2]-1);
            answer[i] = a;
        }

        return answer;
    }
}
