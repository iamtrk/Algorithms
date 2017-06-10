package com.iamtrk.sort;

import java.util.Collections;
import java.util.List;
import java.util.concurrent.Callable;

/**
 * Created by iamtrk on 10/06/17.
 */
public class SortThread implements Callable<List<Integer>> {

    List<Integer> list;
    public SortThread(List<Integer> list) {
        this.list = list;
    }

    @Override
    public List<Integer> call() {
        Collections.sort(list);
        return list;
    }
}

