package com.joonseo.section02.searching;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.StringReader;
import java.util.*;

public class TreeTraversal {
    static class Node {
        char data;
        Node left, right;

        Node(char data) {
            this.data = data;
        }
    }

    static Map<Character, Node> tree = new HashMap<>();
    static StringBuilder preorderResult = new StringBuilder();
    static StringBuilder inorderResult = new StringBuilder();
    static StringBuilder postorderResult = new StringBuilder();

    public static String solution(String input) throws IOException {
        BufferedReader br = new BufferedReader(new StringReader(input));
        int N = Integer.parseInt(br.readLine()); // 노드 개수

        // 트리 생성
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            char parent = st.nextToken().charAt(0);
            char left = st.nextToken().charAt(0);
            char right = st.nextToken().charAt(0);

            // 부모 노드 생성 (없으면 추가)
            tree.putIfAbsent(parent, new Node(parent));

            // 왼쪽 자식 추가
            if (left != '.') {
                tree.putIfAbsent(left, new Node(left));
                tree.get(parent).left = tree.get(left);
            }

            // 오른쪽 자식 추가
            if (right != '.') {
                tree.putIfAbsent(right, new Node(right));
                tree.get(parent).right = tree.get(right);
            }
        }

        // 루트 노드는 항상 'A'
        Node root = tree.get('A');

        // 트리 순회 수행
        preorder(root);
        inorder(root);
        postorder(root);

        // 결과 반환
        return preorderResult.toString() + "\n" + inorderResult.toString() + "\n" + postorderResult.toString();
    }

    // 전위 순회 (루트 -> 왼쪽 -> 오른쪽)
    static void preorder(Node node) {
        if (node == null) return;
        preorderResult.append(node.data);
        preorder(node.left);
        preorder(node.right);
    }

    // 중위 순회 (왼쪽 -> 루트 -> 오른쪽)
    static void inorder(Node node) {
        if (node == null) return;
        inorder(node.left);
        inorderResult.append(node.data);
        inorder(node.right);
    }

    // 후위 순회 (왼쪽 -> 오른쪽 -> 루트)
    static void postorder(Node node) {
        if (node == null) return;
        postorder(node.left);
        postorder(node.right);
        postorderResult.append(node.data);
    }
}
