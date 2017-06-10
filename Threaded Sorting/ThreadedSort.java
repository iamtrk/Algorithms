package com.iamtrk.sort;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.*;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * Created by iamtrk on 01/06/17.
 *
 * The program tries to sort a large list of random numbers
 * in two different ways,
 * 1) With collections.sort
 * 2) Use threads equal to the number of processors available
 * for the JVM.
 *
 * Have test ran the script with 20 Million random numbers.
 * Threaded sort performed 4X compared to Collections sort
 * on MacBook Pro.
 */
public class ThreadedSort {

    public static void main(String[] args) {
        int NUM_PROCESSORS = getNumProcessors();
        System.out.println("Available processors are : "+NUM_PROCESSORS);

        int divide = Integer.MAX_VALUE/NUM_PROCESSORS;
        int r = -1;

        List<Integer> list = new ArrayList<>();

        HashMap<Integer, List<Integer>> res = new HashMap<>(NUM_PROCESSORS);
        for (int i = 0; i < NUM_PROCESSORS; i++) {
            res.put(i, new ArrayList<Integer>());
        }
        /*
        * Input numbers are fed from a file that contains a random integer in every line.
        *Ex:
        *399921086
        *977184052
        *719558986
        *1967208386
        *1540117700
        * */
        try {
            BufferedReader reader = new BufferedReader(new FileReader("<Random numbers text file goes here>"));
            String line = "";
            while ((line = reader.readLine()) != null) {
                r = Integer.parseInt(line);
                list.add(r);
                res.get(r / divide).add(r);
            }
        } catch (Exception ex) {
            System.out.println("Please download the rand.txt.gz file " +
                    "from the same repo, Unzip it & provide the txt file path above");
            return;
        }

        long s = System.currentTimeMillis();
        Collections.sort(list);
        long d = System.currentTimeMillis();

        System.out.println("Threaded sort time in Milli Seconds: "+ (d - s));

        ExecutorService service = Executors.newFixedThreadPool(NUM_PROCESSORS);
        s = System.currentTimeMillis();
        Queue<Future<List<Integer>>> futures = new LinkedList<>();
        for (Integer key : res.keySet()) {
            futures.add(service.submit(new SortThread(res.get(key))));
        }

        List<Integer> threadedSort = new ArrayList<>();
        try {
            for (Future<List<Integer>> future : futures) {
                List<Integer> sl = future.get();
                threadedSort.addAll(sl);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        d = System.currentTimeMillis();

        System.out.println("Threaded sort time in Milli Seconds: "+ (d - s));

        System.out.println("Are both the lists same ? "+threadedSort.equals(list));

        service.shutdown();
    }

    /*
    * Returns the number of processors available to JVM
    * */
    public static int getNumProcessors() {
        Runtime runtime = Runtime.getRuntime();
        return runtime.availableProcessors();
    }
}

