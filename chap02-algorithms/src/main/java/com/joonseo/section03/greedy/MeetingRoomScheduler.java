package com.joonseo.section03.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.StringReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class MeetingRoomScheduler {
    public static int solution(String input) throws IOException {
        BufferedReader br = new BufferedReader(new StringReader(input));
        int N = Integer.parseInt(br.readLine());
        int[][] time = new int[N][2]; // 회의 시간 [시작시간][종료시간]
        StringTokenizer st;
        int cnt = 0;
//        boolean check = false;
        for(int i = 0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            time[i][0] = Integer.parseInt(st.nextToken());
            time[i][1] = Integer.parseInt(st.nextToken());
        }
//        int[] times = new int[24];
//        for(int i = 0; i<N; i++){
//            for(int j = 0; j<N-1-i; j++ ){
//                if(time[j][1] > time[j+1][1]){
//                    int tmp = time[j][1];
//                    time[j][1] = time[j+1][1];
//                    time[j+1][1] = tmp;
//                }
//            }
//        }
//        for(int i = 0; i<N; i++){
//            int s = time[i][0];
//            int e = time[i][1];
//            if(s != e){
//                for(int j = s; j<e; j++){
//                    if(times[j] != 1){
//                        times[j] = 1;
//                        check = true;
//                    }else{
//                        check = false;
//                        break;
//                    }
//                }
//                if(check){
//                    cnt += 1;
//                }
//            }else{
//                cnt += 1;
//            }
//        }
        /* 종료시간이 빠른 회의 순서로 데이터 정렬 */
        Arrays.sort(time,(t1,t2) ->{
            // 종료 시간이 같은 회의가 있다면 시작 시간이 빠른 순서로 정렬
            // 경계 시간에 있는 회의가 올바르게 처리 되도록 주는 기준
            if(t1[1] == t2[1]) return t1[0] - t2[0];
            return t1[1] - t2[1];
        });
        int end = 0; // 직전 회의가 끝난 시간을 담아둘 변수
        /* time 배열 안에 있는 회의를 반복하며 회의 시간표에 넣을지 확인*/
        for(int i = 0; i<N; i++){
            // 직전 회의가 끝나느 시간과 일치하거나 그 이후에 시작 되는지 확인
            if(time[i][0] >= end){
                cnt += 1;
                end = time[i][1]; // end 시간 갱신
            }
        }

        return cnt;
    }
}
