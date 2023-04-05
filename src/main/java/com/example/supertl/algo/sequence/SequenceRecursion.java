package com.example.supertl.algo.sequence;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SequenceRecursion implements Sequence{
    @Override
    public List<List<Integer>> get(Integer[][] digits) {
        List<List<Integer>> res = new ArrayList<>();
        recursion(digits, new ArrayList<>(), res);
        return res;
    }

    private void recursion(Integer[][] list, List<Integer> arr, List<List<Integer>> res) {
        if (list.length == 0) {
            res.add(arr);
            return;
        }
        Integer[] stepDigits = list[0];
        for (Integer i : stepDigits) {
            List<Integer> curList = new ArrayList<>(arr);
            curList.add(i);
            recursion(Arrays.copyOfRange(list, 1, list.length), curList, res);
        }
    }
}
