package com.example.supertl;

import com.example.supertl.algo.Parser;
import com.example.supertl.algo.sequence.Sequence;
import com.example.supertl.algo.sequence.SequenceRecursion;

import java.util.List;

public class Port {
    private String[] indexes;
    private Integer[][] digits;
    private Parser parser;
    private Sequence sequence;

    public Port(String[] indexes) {
        this.indexes = indexes;
        parser = new Parser();
        sequence = new SequenceRecursion();
    }

    public Integer[][] parse() {
        digits = parser.parse(indexes);
        return digits;
    }

    public Integer[][] sequence() {
        if (digits == null)
            return null;
        List<List<Integer>> seq = sequence.get(digits);
        return Utils.convert(seq);
    }
}
