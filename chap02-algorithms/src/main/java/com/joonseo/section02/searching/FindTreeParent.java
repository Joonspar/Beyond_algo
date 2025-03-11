package com.joonseo.section02.searching;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.StringReader;
import java.util.*;

public class FindTreeParent {
    static int N; // 노드이 개수
    static List<Integer>[] list; // 연결 노드 저장 배열
    static int[] parent; // 최종 결과 저장 배열
    static boolean[] visited; // 방문 결과 저장 배열
    public static String solution(String input) throws IOException {
        BufferedReader br = new BufferedReader(new StringReader(input));
        N = Integer.parseInt(br.readLine());

        parent = new int[N+1];
        visited = new boolean[N+1];
        list = new ArrayList[N+1];

        for(int i = 0; i< N+1; i++){
            list[i] = new ArrayList<>();
        }

        /* N - 1개의 줄의 입력 처리*/
        StringTokenizer st;
        for(int i = 1; i< N; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            list[a].add(b); // a라는 node에 b를 추가
            list[b].add(a); // b라는 node에 a를 추가
        }
        // DFS VS BFS를 활용해 트리 구조를 탐색하면서 parent 배열에 값을 입력 한다.
        dfs(1);
        bfs(1);

        /* 트리 탐색이 완료 된 이후에는 parent 배열에 부모 노드 값이 담겨 있으므로
        *  합쳐서 문자열로 만들고 반환한다. */
        StringBuilder sb = new StringBuilder();
        for(int i = 2; i< parent.length; i++){
            sb.append(parent[i]).append(" ");
        }
        return sb.toString();
    }
    static void dfs(int parentNode){
        visited[parentNode] = true;

        /*연결 된 노드를 반복 */
        for(int childNode : list[parentNode]){
            if(!visited[childNode]){
                // 부모를 관리하는 배열에 해당 자식 노드의 부모 노드를 담는다.
                parent[childNode] = parentNode;
                // 그 자식 노드를 부모로 하는 자식 노드를 탐색한다.
                dfs(childNode);
            }
        }
    }
    static void bfs(int root){
        Queue<Integer> q = new LinkedList<>();
        q.offer(root);
        visited[root] = true;
        while(!q.isEmpty()) {
            int parentNode = q.poll();
            for(int childNode : list[parentNode]){
                if(!visited[childNode]){
                    visited[childNode] = true;
                    parent[childNode] = childNode;
                    q.offer(childNode);
                }
            }
        }
    }
}
