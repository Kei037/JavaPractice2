package ch_09.map3;

// HashMap에 아이디와 점수가 저장되어 있음
// 실행결과와 같이 평균 점수를 출력하고, 최고점수와 최고점수를 받으 아이디를 출력할 것

import java.util.HashMap;
import java.util.Map;

public class Test {
    public static void main(String[] args) {
        Map<String, Integer> map = new HashMap<>();
        map.put("blue", 96);
        map.put("hong", 86);
        map.put("white", 92);

        String name = null; // 최고 점수를 받은 아이디 저장
        int maxScore = 0; // 최고 점수 저장
        int totalScore = 0; // 점수 합계 저장

        // 작성위치
        for (var strKey : map.keySet()) {
            int thisScore = map.get(strKey);
            totalScore += thisScore;
            if (maxScore < thisScore) {
                maxScore = thisScore;
                name = strKey;
            }
        }
        System.out.println("최고 점수를 받은 아이디 : " + name);
        System.out.println("최고 점수 : " + maxScore);
        System.out.println("평균 점수 : " + (double)totalScore / map.size());
        /*
        최고 점수를 받은 아이디 : blue
        최고 점수 : 96
        평균 점수 : 91.33333333333333
         */
    }
}
