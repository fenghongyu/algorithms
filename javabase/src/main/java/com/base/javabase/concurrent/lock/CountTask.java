package com.base.javabase.concurrent.lock;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.Future;
import java.util.concurrent.RecursiveTask;

/**
 * Created on 2019-06-03
 * @author fenghongyu
 */
public class CountTask extends RecursiveTask {
    private final int THRESHOLD = 2;
    private int start;
    private int end;

    public CountTask(int start, int end) {
        this.start = start;
        this.end = end;
    }

    @Override
    protected Integer compute() {
        int sum = 0;
        boolean canConputer = (end - start) <= THRESHOLD;
        if(canConputer) {
            for(int i=start; i<=end;i++) {
                sum+=i;
            }
        } else {
            int mindle = (start+end)/2;
            CountTask leftCt = new CountTask(start, mindle);
            CountTask rightCt = new CountTask(mindle+1, end);
            leftCt.fork();
            rightCt.fork();

            Integer leftResult = (Integer) leftCt.join();
            Integer rightReslt = (Integer) rightCt.join();
            sum = leftResult + rightReslt;
        }
        return sum;
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ForkJoinPool pool = new ForkJoinPool();
        CountTask countTask = new CountTask(1,4);
        Future<Integer> task = pool.submit(countTask);

        System.out.println(task.get());
    }
}
