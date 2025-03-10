package com.joonseo.section01.sorting;

import java.util.Arrays;


public class Insertion {

    public static void solution(int[] arr) {
        for(int i = 1; i<arr.length; i++){ // 0번 인덱스는 정렬이 되어있다고 가정하므로 1부터 시작
            System.out.println(i + "번째 : " + Arrays.toString(arr)); // 확인용 출력문
            int temp = arr[i]; // 중간에 삽입 될 값을 위한 임시변수
            int j;
            for(j = i-1; j>=0; j--){ // 역순으로 탐색을 진행한다.
                // i인덱스보다 앞으로 인덱스를 탐색하면서 기준 값 보다 큰 경우 뒤로 하나씩 밀어버린다.
                if(arr[j] > temp){ // 현재 값과 삽입될 값을 비교하여 현재값이 더 큰 경우
                    arr[j+1] = arr[j]; // 현재 값은 다음 순번으로 이동하게 된다.
                }else{
                    break; // 앞에 정렬됐으므로 삽입할 위치를 찾게 되었다.
                }
                // 반복문을 빠져나왔다는 것은, 적절한 삽입 위치를 찾았다는 의미
            }
            arr[j+1] = temp;
        }
    }
}