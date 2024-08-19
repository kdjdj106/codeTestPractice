package org.programers;

public class Test12977 {
    public static void main(String[] args) {
        int[] arr = new int[] {1,2,3,4};
        solution(arr);
    }
   static public int solution(int[] nums) {
        int answer = 0;
        int length = nums.length;
       for (int i = 0; i < length; i++) {
           for (int j = i+1; j < length; j++) {
               for (int k = j+1; k < length; k++) {
                   int sum = nums[i]+ nums[j] + nums[k];
                   if (isPossible(sum)){answer++;}
               }
           }
       }
        // [실행] 버튼을 누르면 출력 값을 볼 수 있습니다.
        System.out.println(answer);

        return answer;
    }
    static boolean isPossible(int sum){
        if (sum == 2) return true;
        else {
            for (int i = 2; i <= (int)Math.sqrt(sum); i++) {
                if (sum % i == 0) return false;
            }
        }
        return true;
    }
}
