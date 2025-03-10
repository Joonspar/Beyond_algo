package com.joonseo.section06.tree;

import java.util.TreeMap;

/* 펴향 이진 트리
* : 사실상 연결리스트처럼 동작하여 최악의 경우 O(N)의 시간 복잡도
* 균형 이진트리
* : 트리의 높이가 최소화 되어 모든 연산이 평균적으로 O(log N)의 시간 복잡도
* Java Collection FrameWork에서는 TreeSet, TreeMap 등에서 트리 구조를 활용하고 있는데
* 내부적으로 레드 - 블랙 트리로 관리되고 있다.
* */
public class Application {

    public static void main(String[] args) {
        TreeMap<String,String> treeMap = new TreeMap<>();;
        treeMap.put("first","black");
        treeMap.put("second","red");
    }
}
