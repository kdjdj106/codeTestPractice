package org.programers;

import java.util.*;

/*
과제 진행하기
문제 설명
과제를 받은 루는 다음과 같은 순서대로 과제를 하려고 계획을 세웠습니다.

과제는 시작하기로 한 시각이 되면 시작합니다.
새로운 과제를 시작할 시각이 되었을 때, 기존에 진행 중이던 과제가 있다면 진행 중이던 과제를 멈추고 새로운 과제를 시작합니다.
진행중이던 과제를 끝냈을 때, 잠시 멈춘 과제가 있다면, 멈춰둔 과제를 이어서 진행합니다.
만약, 과제를 끝낸 시각에 새로 시작해야 되는 과제와 잠시 멈춰둔 과제가 모두 있다면, 새로 시작해야 하는 과제부터 진행합니다.
멈춰둔 과제가 여러 개일 경우, 가장 최근에 멈춘 과제부터 시작합니다.
과제 계획을 담은 이차원 문자열 배열 plans가 매개변수로 주어질 때, 과제를 끝낸 순서대로 이름을 배열에 담아 return 하는 solution 함수를 완성해주세요.

제한사항
3 ≤ plans의 길이 ≤ 1,000
plans의 원소는 [name, start, playtime]의 구조로 이루어져 있습니다.
name : 과제의 이름을 의미합니다.
2 ≤ name의 길이 ≤ 10
name은 알파벳 소문자로만 이루어져 있습니다.
name이 중복되는 원소는 없습니다.

start : 과제의 시작 시각을 나타냅니다.

"hh:mm"의 형태로 "00:00" ~ "23:59" 사이의 시간값만 들어가 있습니다.

모든 과제의 시작 시각은 달라서 겹칠 일이 없습니다.
과제는 "00:00" ... "23:59" 순으로 시작하면 됩니다. 즉, 시와 분의 값이 작을수록 더 빨리 시작한 과제입니다.
playtime : 과제를 마치는데 걸리는 시간을 의미하며, 단위는 분입니다.

1 ≤ playtime ≤ 100
playtime은 0으로 시작하지 않습니다.

배열은 시간순으로 정렬되어 있지 않을 수 있습니다.
진행중이던 과제가 끝나는 시각과 새로운 과제를 시작해야하는 시각이 같은 경우 진행중이던 과제는 끝난 것으로 판단합니다.
* */
public class Test176962 {
    public static void main(String[] args) {
        String[][] arr = new String[][]{{"korean", "11:40", "30"}, {"english", "12:10", "20"}, {"math", "12:30", "40"}};
        solution(arr);
        arr = new String[][]{{"science", "12:40", "50"}, {"music", "12:20", "40"}, {"history", "14:00", "30"}, {"computer", "12:30", "100"}};
        solution(arr);
        arr = new String[][]{{"a", "09:00", "30"}, {"b", "09:20", "10"}, {"c", "09:40", "10"}};
        solution(arr);
    }

    static public String[] solution(String[][] plans) {
        String[] answer = {};
        ArrayList<Schedule> list = new ArrayList<>();
        Stack<Schedule> waitList = new Stack<>();
        ArrayList<String> endList = new ArrayList<>();

        for (String[] arr : plans) {
            String subject = arr[0];
            String[] clock = arr[1].split(":");
            int startTime = Integer.parseInt(clock[0]) * 60 + Integer.parseInt(clock[1]);
            int time = Integer.parseInt(arr[2]);
            list.add(new Schedule(subject, startTime, time));
        }

        Collections.sort(list);


        for (int i = 0; i < list.size()-1; i++) {
            // 대기 리스트에 아무것도 없다면 다음 과목을 비교
            if (waitList.isEmpty()) {
                // 현재과목과 다음과목을 비교
                Schedule tmp = list.get(i);
                int diffTime = list.get(i + 1).startTime - tmp.startTime;
                // 걸리는 시간이 두과목의 시작 시간의 차이보다 같거나 작다면
                if (diffTime >= tmp.time) {
                    // 끝난 리스트에 저장
                    endList.add(tmp.subject);
                } else {
                    //걸리는 시간이 시작 시간의 차이보다 크다면
                    // 걸린 시간을 빼주고 대기 리스트에 저장
                    tmp.time -= diffTime;
                    waitList.push(tmp);
                }
            }
            // 대기 리스트에 스케줄이 있다면 로직 시작
            else {
                Schedule tmp = list.get(i);
                int diffTime = list.get(i + 1).startTime - tmp.startTime;





                // diffTime이 현재과목의 실행시간 보다 많다면 현재 실행시간 만큼 diffTime에서 빼주고
                // 현재과목을 종료리스트에 저장
                if (diffTime >= tmp.time) {
                    endList.add(tmp.subject);
                    diffTime -= tmp.time;

                    // 그래도 diff타임이 남아있고 대기 리스트에 과목이 있다면
                    // diffTime이 0이되거나 대기리스트가 빌때까지 반복
                    while (!waitList.isEmpty() && diffTime > 0) {
                        Schedule waitSchedule = waitList.pop();

                        // diffTime이 대기과목 실행시간 보다 크면
                        // diffTime에서 대기과목의 실행시간 만큼 빼주고 종료리스트에 추가.
                        if (diffTime>= waitSchedule.time) {
                            endList.add(waitSchedule.subject);
                            diffTime -= waitSchedule.time;
                        }
                        // diffTime이 대기과목 실행시간 보다 작으면
                        // diffTime을 0으로 설정
                        else{
                            waitSchedule.time -= diffTime;
                            waitList.push(waitSchedule);
                            diffTime =0;

                        }
                    }
                }
                // diffTime이 대기과목의 실행시간 보다 적다면 대기 과목의 실행시간에서 diffTime만큼 빼주고
                // 다시 대기 리스트에 집어 넣는다.
                else {
                    tmp.time -= diffTime;
                    waitList.push(tmp);
                }

            }
        }
        endList.add(list.get(list.size()-1).subject);
        while (!waitList.isEmpty()){
            endList.add(waitList.pop().subject);
        }
        answer = endList.toArray(new String[endList.size()]);
        return answer;
    }

    static class Schedule implements Comparable<Schedule> {
        String subject;
        int startTime;
        int time;

        public Schedule(String subject, int startTime, int time) {
            this.subject = subject;
            this.startTime = startTime;
            this.time = time;
        }

        @Override
        public int compareTo(Schedule o) {
            return this.startTime - o.startTime;
        }
    }
}