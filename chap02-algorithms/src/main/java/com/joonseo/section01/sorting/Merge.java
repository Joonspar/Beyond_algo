package com.joonseo.section01.sorting;

import java.util.Arrays;

public class Merge {
    public static void solution(int[] arr){
        System.out.println("원본 배열 : " + Arrays.toString(arr)); //디버깅용 출력문
        int[] temp = new int[arr.length]; // 추가된 배열
        mergeSort(arr,temp,0,arr.length-1);
        System.out.println("정렬된 배열 : " + Arrays.toString(arr)); // 디버깅용 출력문
    }

    private static void mergeSort(int[] arr,int[] temp, int left, int right){
        if(left < right){
            int mid = (left + right)/2;
            mergeSort(arr,temp,left,mid); // 왼쪽부터 mid까지 재귀
            mergeSort(arr,temp,mid+1,right); // mid+1부터 오른쪽까지 재귀
            merge(arr,temp,left,mid,right);
        }
    }
    private static void merge(int[] arr,int[] temp, int left, int mid, int right){
        System.out.println("병합 전 : " + Arrays.toString(arr)); // 디버깅용 출력문
        System.out.println("left : " + left + ", mid : " + mid + ", right : " + right); // 디버깅용 출력문

        // 병합 구간의 배열을 임시 배열에 복사
        for(int i = left; i<=right; i++){
            temp[i] = arr[i]; // 임시배열에 copy
        }
        int idx1 = left;
        int idx2 = mid + 1;
        int curr = left;

        while(idx1 <= mid && idx2 <= right){ // 포인터가 벗어나게 되면 반복문 종료
            if(temp[idx1] <= temp[idx2]){
                arr[curr++] = temp[idx1++];
            }else{
                arr[curr++] = temp[idx2++];
            }
        }

        // 왼쪽 배열에 남은 요소를 복사한다.
        // 오른족 배열에 남아있을 걍우는 이미 제자리에 있으므로 처리 x
        while(idx1 <= mid){
            arr[curr++] = temp[idx1++];
        }
        System.out.println("병합 후 : " + Arrays.toString(arr)); // 디버깅용 출력문
        System.out.println("======================================="); // 디버깅용 출력문
    }
}
