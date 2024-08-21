package org.programers;
/*
두 원 사이의 정수
x축과 y축으로 이루어진 2차원 직교 좌표계에 중심이 원점인 서로 다른 크기의 원이 두 개 주어집니다. 반지름을 나타내는 두 정수 r1, r2가 매개변수로 주어질 때, 두 원 사이의 공간에 x좌표와 y좌표가 모두 정수인 점의 개수를 return하도록 solution 함수를 완성해주세요.
※ 각 원 위의 점도 포함하여 셉니다.
* */
public class Test181187 {
    public long solution(int r1, int r2) {
        long answer = 0;

        double r1pow = Math.pow(r1, 2);
        double r2pow = Math.pow(r2, 2);

        int onLine = (r2 - r1 + 1)*4; //선 위에 있는 좌표 개수

        for(int i=0; i<= r2; i++){ //1사분면만 계산
            double xpow = Math.pow(i, 2);


            if(i > r1) r1pow = 0;
            double y1 =0;
            if(r1pow != 0){
                y1 = Math.sqrt(r1pow - xpow); //작은원
                if(y1 > Math.floor(y1)){
                    y1 = Math.ceil(y1);
                }
            }

            double y2 = Math.sqrt(r2pow - xpow); //큰원
            if(y2 > Math.floor(y2)){
                y2 = Math.floor(y2);
            }
            answer += (int)y2 - (int)y1 + 1;

        }

        return answer*4 - onLine; //중복 계산된 점 빼주기
    }
}
