package com.example.supertl;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

public class Utils {
    public static void printArray(Integer[][] arr) {
        if (arr == null) return;
        Consumer<Integer[]> cons = t -> {
            Arrays.stream(t).toList().forEach(l -> System.out.print(l.toString() +" "));
            System.out.println();
        };
        Arrays.stream(arr).forEach(cons);
    }


    public static Integer[][] convert(List<List<Integer>> list) {
        Integer[][] res = new Integer[list.size()][];
        for (int i = 0; i < list.size(); i++)
            res[i] = list.get(i).toArray(new Integer[]{});
        return res;
    }
}
