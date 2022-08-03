package com.leetcode.editor.cn;

import java.util.Arrays;

public class offer05 {
    class Solution {
        public String replaceSpace(String s) {
            char[] charlist = new char[s.length() * 3];
            int index = 0;
            for(int i = 0; i < s.length(); i++){
                char temp = s.charAt(i);
                if(temp == ' '){
                    charlist[index++] = '%';
                    charlist[index++] = '2';
                    charlist[index++] = '0';
                }
                else
                    charlist[index++] = temp;
            }
            return new String(charlist, 0, index);

        }
    }
}
