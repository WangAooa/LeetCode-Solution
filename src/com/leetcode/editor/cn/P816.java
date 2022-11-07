package com.leetcode.editor.cn;

import sun.jvm.hotspot.runtime.ResultTypeFinder;

import java.util.*;

public class P816 {
    public List<String> ambiguousCoordinates(String s) {
        List<String> result = new ArrayList<>();

        s = s.substring(1, s.length() - 1);

        //1025
        for (int i = 1; i < s.length(); i++) {
            List<String> xList = generateNum(s.substring(0, i));
            List<String> yList = generateNum(s.substring(i));

            if (!xList.isEmpty() && !yList.isEmpty()) {
                for (String xtemp : xList) {
                    for (String ytemp : yList) {
                        result.add("(" + xtemp + ", " + ytemp + ")");
                    }
                }
            }
        }
        return result;

    }

    public List<String> generateNum(String s) {
        List<String> result = new ArrayList<>();
        if (s.equals("0") || s.charAt(0) != '0') {
            result.add(s);
        }

        //1234
        for (int i = 1; i < s.length(); i++) {
            if((s.charAt(0) == '0' && i > 1) || s.charAt(s.length() - 1) == '0')
                continue;
            result.add(s.substring(0, i) + "." + s.substring(i));
        }

        return result;
    }
}
