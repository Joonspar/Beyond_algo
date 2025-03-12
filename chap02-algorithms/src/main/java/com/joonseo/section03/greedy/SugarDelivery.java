package com.joonseo.section03.greedy;

/* 설탕 배달 문제
*  매 단계마다 즉각적으로 최적이라고 생각되는 선택을 반복해서
*  전체 문제의 해답을 구하는 문항*/
public class SugarDelivery {

    public static int solution(int n) {
        int cnt = 0;
        while(true){
            /* 5키로 봉지로 모두 가져갈 수 있다면 ?*/
            if (n % 5 == 0){
                return n / 5 + cnt;
            }
            else if(n < 0){ // 조합이 아예 안되는 상황
                return -1;
            }
            else if(n == 0){ // 3으로만 해결되는 경우
                return cnt;
            }

            /* 5키로로 나누어 떨어지지 않으면 3키로 봉지 사용*/
            n = n - 3;
            cnt++;
        }
    }
}
