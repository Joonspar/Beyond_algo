package com.joonseo.section02.searching;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.StringReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/* 너비 우선 탐색
*  선입 선출 구조의 queue를 활용
*  시작 노드에서 출발해서 시작 노드를 기준으로 가까운 노드를 먼저 방문하면서 탐색하는 알고리즘이다.*/
public class BFS {

    /* 배추 밭에 필요한 배추 지렁이 갯수 구하는 문제
    *  x,y좌표를 활용한 탐색 문제를 해결할 수 있다.
    * */
    // 배추밭의 크기와 배추 개수
    static int M,N,K;
    // 배추밭
    static int[][] map;
    // 배추 찾기를 할 때 방문 했는지 여부를 확인해야함
    static boolean[][] visit;
    // 지렁이의 개수
    static int count;
    static int[] dx = {0,0,-1,1};
    static int[] dy = {-1,1,0,0};
    // x와 y를 갖고있는 node 클래스
    static class Node{
        int x;
        int y;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    // 현재 좌표
    static int cx , cy = 0;
    // BFS로 문제를 해결하기 위한 Queue
    static Queue<Node> q = new LinkedList<>();

    public static int solution(String input) throws IOException {
        BufferedReader br = new BufferedReader(new StringReader(input));
        StringTokenizer st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        map = new int[M][N]; // 개수는 맞지만 반전된 좀 꼬롬해
        visit = new boolean[M][N];
        count = 0;

        /* 배추 밭에 배추 심기*/
        for(int i = 0; i<K; i++){
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            map[x][y] = 1;
        }

        // 출력 확인
        System.out.println("배추밭");
        for(int i = 0; i<M; i++){
            for(int j = 0; j<N; j++){
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();

        /* 배추 찾기 */
        for(int i = 0; i<M; i++){
            for (int j = 0; j<N; j++){
                /* 방문하지 않은 위치 배추가 심어져있다면 지렁이를 심는다. */
                if(map[i][j] == 1 && !visit[i][j]){
                    count += 1;
                    /* 해당 위치에 붙어있는 배추밭 방문 체크 */
                    bfs(i,j);
                }
            }
        }
        return count;
    }

    /* 지렁이가 심어질 때마다 한 번씩 동작하는 bfs 메서드*/
    static void bfs(int x, int y){
        visit[x][y] = true;
        q.offer(new Node(x, y));

        // 연속적으로 상하좌우가 배추가 심어져 있다면 해당 위치를 방문한 것으로 체크하고
        // queue를 통해 탐색 진행
        while(!q.isEmpty()){
            Node nodde = q.poll();

            /* 상하좌우 살펴보기*/
            for(int i = 0; i<4; i++){
                cx = nodde.x + dx[i];
                cy = nodde.y + dy[i];

                /* 지금 보는 방향이 좌표로서 존재하고, 방문한 적이 없고, 배추가 심어져 있다면*/
                if(rangeCheck() && !visit[cx][cy] && map[cx][cy] == 1){
                    q.offer(new Node(cx, cy));
                    visit[cx][cy] = true;
                }
            }
        }
    }

    static boolean rangeCheck(){
        return cx >= 0 && cx < M && cy >= 0 && cy < N;
    }
}
