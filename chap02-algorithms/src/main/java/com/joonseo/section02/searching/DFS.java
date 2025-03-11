package com.joonseo.section02.searching;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.StringReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class DFS {
    static int node,edge;
    static int[][] map;
    static boolean[] visit;
    static int count = 0;

    public static Integer solution(String input) throws IOException {
        BufferedReader br = new BufferedReader(new StringReader(input));
        node = Integer.parseInt(br.readLine());
        edge = Integer.parseInt(br.readLine());

        /* 그래프의 간선 연결 정보를 이차원 배열로 표현*/
        map = new int[node+1][node+1]; // 0번 인덱스 제외하고 사용하기 위함

        /*방문 배열 생성 ( 지나간 노드를 다시 방문하지 않기 위함 )*/
        visit = new boolean[node+1];

        StringTokenizer st;
        /* map에 그래프 정보 작성*/
        for (int i = 0; i<edge; i++){
            st = new StringTokenizer(br.readLine()); // split보다는 시간적 효율이 좋아서 사용
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            // 무방향 그래프이므로 둘 다 1로 설정
            map[a][b] = map[b][a] = 1;
        }
//        dfsRecursive(1); // 이미 1번을 방문했다는 의미
        dfsStack(1);
        return count;
    }

    /*재귀 함수로 DFS 알고리즘을 구현할 메소드 */
    private static void dfsRecursive(int start){
        /* 해당 노드를 방문했으므로 방문 배열에 표시 */
        visit[start] = true;
        /* start 노드의 이웃을 탐색하는 과정 */
        for(int i = 1; i<=node; i++){
            /* start 정점의 이웃 중 방문하지 않은 이웃을 찾는다. */
            if(map[start][i] == 1 && !visit[i]){ // 1이라는 의미는 나의 이웃이라고 여김. 그리고, 재방문을 막기위하여 반전 사용
                /* 바이러스를 전파할 이웃 노드 컴퓨터를 찾은 것이므로 count를 증가시키고
                *  해당 이웃 노드를 방문해서 다시 이웃노드를 재귀적으로 탐색한다. */
                count += 1;
                dfsRecursive(i); // 재귀적으로 호출
            }
        }
    }

    /* Stack을 활용한 방식 */
    private static void dfsStack(int start){
        Stack<Integer> stack = new Stack<>();
        stack.push(start);
        visit[start] = true;

        while(!stack.isEmpty()){
            int current = stack.pop();
            for(int i = 1; i<=node; i++){
                if(map[current][i] == 1 && !visit[i]){
                    stack.push(i);
                    visit[i] = true;
                    count += 1;
                }
            }
        }
    }
}
