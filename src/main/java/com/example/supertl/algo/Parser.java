package com.example.supertl.algo;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Parser {
    public Integer[] parse(String s){
        List<Integer> digits = new ArrayList<>();
        String[] strList = s.split(",");
        for (String str : strList) {
            if (str.contains("-")) {
                digits.addAll(rangeFromStr(str));
            } else digits.add(Integer.parseInt(str));
        }
        return unique(digits).toArray(new Integer[]{});
    }

    public Integer[][] parse(String[] arr) {
        Integer[][] res = new Integer[arr.length][];
        for (int i = 0; i < arr.length; i++)
            res[i] = parse(arr[i]);
        return res;
    }

    protected List<Integer> rangeFromStr(String s) {
        List<Integer> res = new ArrayList<>();
        int indexOfHyphen = s.indexOf("-");
        if (indexOfHyphen != -1) {
            int fromRange = Integer.parseInt(s.substring(0, indexOfHyphen));
            int toRange = Integer.parseInt(s.substring(indexOfHyphen + 1));
            for (int i = fromRange; i <= toRange; i++)
                res.add(i);
        }
        return res;
    }

    protected List<Integer> unique(List<Integer> digits) {
        return digits.stream().distinct().collect(Collectors.toList());
    }
}
