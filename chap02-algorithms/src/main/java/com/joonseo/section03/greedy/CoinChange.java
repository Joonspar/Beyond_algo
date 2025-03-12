package com.joonseo.section03.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.StringReader;
import java.util.StringTokenizer;

public class CoinChange {

    public static int solution(String input) throws IOException {
        BufferedReader br = new BufferedReader(new StringReader(input));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()); // 동전의 종류 개수
        int K = Integer.parseInt(st.nextToken()); // 계산할 금액
        int[] coins = new int[N];
        for(int i = 0; i < N; i++){
            coins[i] = Integer.parseInt(br.readLine());
        }
        int cnt = 0; // 필요한 동전의 개수
        for(int i = N - 1; i >= 0; i--){
            if(coins[i] <= K){
                cnt += K / coins[i];
                K %= coins[i];
            }
            if(K == 0){
                break;
            }
        }
        return cnt;
    }
}
