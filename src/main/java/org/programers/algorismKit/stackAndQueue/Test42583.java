package org.programers.algorismKit.stackAndQueue;

import java.util.LinkedList;
import java.util.Queue;
/*다리를 지나는 트럭
 */
public class Test42583 {
    public static void main(String[] args) {
        int bridge_length= 2;
        int weight =10;
        int[] truck_weights ={7,4,5,6};
        System.out.println(solution(bridge_length, weight, truck_weights));
    }
    static public int solution(int bridge_length, int weight, int[] truck_weights) {
        int time = 0;
        int sum =0;
        Queue<Integer> bridge = new LinkedList<>();
        for (int i :truck_weights){
            while (true){
                if (bridge.isEmpty()){
                    bridge.offer(i);
                    time++;
                    sum += i;
                    break;
                }else if (bridge.size() == bridge_length){
                    int n = bridge.poll();
                    sum = sum - n;
                }else {
                    if (sum + i <= weight){
                        bridge.offer(i);
                        time++;
                        sum += i;
                        break;
                    }else{
                        bridge.offer(0);
                        time++;
                    }
                }
            }
        }




        return time + bridge_length;
    }

}
