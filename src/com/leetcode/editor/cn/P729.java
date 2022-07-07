package com.leetcode.editor.cn;

import java.util.Comparator;
import java.util.TreeSet;

public class P729 {
    class MyCalendar {

        public boolean book(int start, int end) {
            if (query(root, 0, END, start, end-1) == 0){
                update(root, 0, END, start, end-1, 1);
                return true;
            }
            return false;
        }
    }
    class Node{
        Node left, right;
        int value, add;
    }
    Node root = new Node();
    int END = (int)1e9;
    public void update(Node root, int start, int end, int l, int r, int value){
        if (start >= l && end <= r){
            root.value = value;
            root.add = 1;
            return;
        }
        int mid = (start + end) >> 1;
        pushDown(root);

        if (l <= mid){
            update(root.left, start, mid, l, r, value);
        }
        if (r > mid){
            update(root.right, mid + 1, end, l, r, value);
        }
        pushUp(root);

    }
    public int query(Node root, int start, int end, int l, int r){
        if (start >= l && end <= r){
            return root.value;
        }
        pushDown(root);

        int mid = (start + end) >> 1, result = 0;
        if (l <= mid){
            result = Math.max(result, query(root.left, start, mid, l, r));
        }
        if (r > mid){
            result = Math.max(result, query(root.right, mid+1, end, l, r));
        }
        return result;
    }
    public void pushUp(Node node){
        node.value = Math.max(node.left.value, node.right.value);
    }
    public void pushDown(Node node){
        if (node.left == null) node.left = new Node();
        if (node.right == null) node.right = new Node();
        if (node.add == 0) return;
        node.left.value = 1;
        node.left.add = 1;
        node.right.value = 1;
        node.right.add = 1;
        node.add = 0;
    }
}
