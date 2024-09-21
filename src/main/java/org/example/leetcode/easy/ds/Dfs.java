//package org.example.leetcode.easy.ds;
//
//import java.util.*;
//
//public class Dfs {
//    public static class Node <K>{
//        public K data;
//        public List<Node<K>> child;
//        public Node(K data){
//            this.data = data;
//            child = null;
//        };
//    }
//
//    public static class TreeNode <K>{
//        public K data;
//        public TreeNode<K> left;
//        public TreeNode<K> right;
//        public TreeNode(K data){
//            this.data = data;
//            left = null; right = null;
//        };
//    }
//    public static <K> void dfs(Node<K> node) {
//        Queue<Node<K>> queue = new ArrayDeque<>();
//        queue.add(node);
//
//        while (queue.size() > 0) {
//            Node<K> n = queue.poll();
//            if (n.child == null)
//                continue;
//            for (Node<K> c: n.child) {
//                dfs(c);
//            }
//        }
//    }
//
//    public static <K> int maxTreeHeight(TreeNode<K> node) {
//        if (node == null)
//            return 0;
//
//        int lh = maxTreeHeight(node.left);
//        int rh = maxTreeHeight(node.right);
//
//        return (lh>rh)?(lh+1):(rh+1);
//    }
//
//    public static void main(String[] args) {
//        Node<Integer> n = new Node<>(10);
//        dfs(n);
//
//        TreeNode<Integer> treeNode = new TreeNode<>(10);
//        maxTreeHeight(treeNode);
//       }
//    }
//
//}
