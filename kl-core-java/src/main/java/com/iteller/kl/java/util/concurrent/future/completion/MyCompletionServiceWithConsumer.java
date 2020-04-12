package com.iteller.kl.java.util.concurrent.future.completion;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;
import java.util.function.Consumer;

/**
 * @author: 18060903(iTeller_zc)
 * date:2020/4/8 9:23
 * description:
 */
public class MyCompletionServiceWithConsumer {

    public static void main(String[] args) throws InterruptedException, ExecutionException {
        //创建任务线程池
        ExecutorService executorService = Executors.newFixedThreadPool(5);
        List<Callable<Integer>> list = new ArrayList<>();
        int taskCount = 5;

        for(int i = taskCount; i>0; i--){
            int j = i * 2;
            list.add(() -> {
               TimeUnit.SECONDS.sleep(j);
               return j;
            });
        }

        solve(executorService, list, a -> {
            System.out.println(System.currentTimeMillis() + ":" + a);
        });

        executorService.shutdown();

    }

    public static <T> void solve(ExecutorService executorService, List<Callable<T>> list, Consumer<T> consumer) throws InterruptedException, ExecutionException {
        CompletionService<T> completionService = new ExecutorCompletionService(executorService);
        for(Callable<T> callable : list){
            completionService.submit(callable);
        }
        int n = list.size();
        for(int i=0; i<n; i++){
            //block wait
            T taskResult = completionService.take().get();
            if(taskResult != null){
                consumer.accept(taskResult);
            }
        }
    }
}
