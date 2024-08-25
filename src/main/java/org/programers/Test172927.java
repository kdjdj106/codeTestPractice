package org.programers;

import java.util.Arrays;

/*
예를 들어, 철 곡괭이는 다이아몬드를 캘 때 피로도 5가 소모되며, 철과 돌을 캘때는 피로도가 1씩 소모됩니다. 각 곡괭이는 종류에 상관없이 광물 5개를 캔 후에는 더 이상 사용할 수 없습니다.

마인은 다음과 같은 규칙을 지키면서 최소한의 피로도로 광물을 캐려고 합니다.

사용할 수 있는 곡괭이중 아무거나 하나를 선택해 광물을 캡니다.
한 번 사용하기 시작한 곡괭이는 사용할 수 없을 때까지 사용합니다.
광물은 주어진 순서대로만 캘 수 있습니다.
광산에 있는 모든 광물을 캐거나, 더 사용할 곡괭이가 없을 때까지 광물을 캡니다.
즉, 곡괭이를 하나 선택해서 광물 5개를 연속으로 캐고, 다음 곡괭이를 선택해서 광물 5개를 연속으로 캐는 과정을 반복하며, 더 사용할 곡괭이가 없거나 광산에 있는 모든 광물을 캘 때까지 과정을 반복하면 됩니다.

마인이 갖고 있는 곡괭이의 개수를 나타내는 정수 배열 picks와 광물들의 순서를 나타내는 문자열 배열 minerals가 매개변수로 주어질 때, 마인이 작업을 끝내기까지 필요한 최소한의 피로도를 return 하는 solution 함수를 완성해주세요.

제한사항
picks는 [dia, iron, stone]과 같은 구조로 이루어져 있습니다.
0 ≤ dia, iron, stone ≤ 5
dia는 다이아몬드 곡괭이의 수를 의미합니다.
iron은 철 곡괭이의 수를 의미합니다.
stone은 돌 곡괭이의 수를 의미합니다.
곡괭이는 최소 1개 이상 가지고 있습니다.
5 ≤ minerals의 길이 ≤ 50
minerals는 다음 3개의 문자열로 이루어져 있으며 각각의 의미는 다음과 같습니다.
diamond : 다이아몬드
iron : 철
stone : 돌
* */
public class Test172927 {
    public static void main(String[] args) {
        int[] arr1 = new int[]{1, 3, 2};
        String[] arr2 = new String[]{"diamond", "diamond", "diamond", "iron", "iron", "diamond", "iron", "stone"};

        System.out.println(solution(arr1, arr2));
    }

    static public int solution(int[] picks, String[] minerals) {
        int min = Math.min(picks[0] + picks[1] + picks[2], minerals.length / 5 + 1);
        int answer = 0;
        int[][] calcMine = new int[min][3];
        int diamondPick = 0, steelPick = 0, stonePick = 0;
        // arr[0] : 다이아몬드 곡괭이 수, arr[1] 철 곡갱이 수, arr[2] : 돌 곡갱이 수
        for (int i = 0; i < minerals.length; i += 5) {
            if (i / 5 == min) break;

            for (int j = i; j < i + 5; j++) {
                String m = minerals[j];
                if (m.equals("diamond")) {
                    diamondPick += 1;
                    steelPick += 5;
                    stonePick += 25;
                } else if (m.equals("iron")) {
                    diamondPick += 1;
                    steelPick += 1;
                    stonePick += 5;
                } else {
                    diamondPick += 1;
                    steelPick += 1;
                    stonePick += 1;
                }

                if (j == minerals.length - 1) {
                    break;
                }
            }
            calcMine[i / 5][0] = diamondPick;
            calcMine[i / 5][1] = steelPick;
            calcMine[i / 5][2] = stonePick;

            diamondPick = 0;
            steelPick = 0;
            stonePick = 0;
        }
        //돌로 캤을 때 피로도가 가장 높은 순으로 내림차순 정렬
        // 그 이유는 돌로 피로도를 계산해야 제일 피로도가 높은 범위를 알수 있기 때문이다.
        Arrays.sort(calcMine, (o1, o2) -> (o2[2]-o1[2]));

        for (int i = 0; i < min; i++) {
            if (picks[0] != 0) {
                answer += calcMine[i][0]; //다이아로 캤을 때 피로도
                picks[0]--;
            } else if (picks[1] != 0) {
                answer += calcMine[i][1];
                picks[1]--;
            } else if (picks[2] != 0) {
                answer += calcMine[i][2];
                picks[2]--;
            }
        }
        return answer;
    }
}
