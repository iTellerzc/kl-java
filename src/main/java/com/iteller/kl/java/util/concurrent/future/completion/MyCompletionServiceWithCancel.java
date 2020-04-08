package com.iteller.kl.java.util.concurrent.future.completion;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

/**
 * @author: 18060903(iTeller_zc)
 * date:2020/4/8 14:23
 * description:
 */
public class MyCompletionServiceWithCancel {

    public static void main(String[] args) throws InterruptedException, ExecutionException {
        long startTime = System.currentTimeMillis();
        //创建任务线程池
        ExecutorService executorService = Executors.newFixedThreadPool(5);
        List<Callable<Integer>> list = new ArrayList<>();
        int taskCount = 5;

        for(int i = taskCount; i>0; i--){
            int j = i * 2;
            String taskName = "task" + j;
            list.add(() -> {
               TimeUnit.SECONDS.sleep(j);
               System.out.println(taskName + " execute over.");
               return j;
            });
        }

        Integer anyResult = executorService.invokeAny(list);
                //invokeAny(executorService, list);

        System.out.println("耗时：" + (System.currentTimeMillis() - startTime) + "ms, 执行结果:" + anyResult);
        executorService.shutdown();

    }

    private static Integer invokeAny(ExecutorService executorService, List<Callable<Integer>> list) throws InterruptedException, ExecutionException {
        CompletionService<Integer> completionService = new ExecutorCompletionService(executorService);
        List<Future<Integer>> futureTasks = new ArrayList<>();
        for(Callable<Integer> callable : list){
            futureTasks.add(completionService.submit(callable));
        }
        int n = list.size();
        try{
            for(int i=0; i<n; i++){
                //block wait
                Integer taskResult = completionService.take().get();
                if(taskResult != null){
                    return taskResult;
                }
            }
        }finally {
            for(Future future : futureTasks){
                future.cancel(true);
            }
        }
        return null;
    }

}
