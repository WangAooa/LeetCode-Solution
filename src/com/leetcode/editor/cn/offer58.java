package com.leetcode.editor.cn;

public class offer58 {
    class Solution {
        //test
        public String reverseLeftWords(String s, int n) {
            StringBuilder result = new StringBuilder();
            int max = n + s.length();
            for(int i = n ; i < s.length(); i++){
                result.append(s.charAt(i));
            }
            for (int i = 0; i < n; i++)
                result.append(s.charAt(i));


            return result.toString();
        }
    }
}
