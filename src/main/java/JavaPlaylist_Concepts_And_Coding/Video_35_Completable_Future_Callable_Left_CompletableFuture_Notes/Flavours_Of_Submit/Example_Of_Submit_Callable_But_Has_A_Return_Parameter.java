package JavaPlaylist_Concepts_And_Coding.Video_35_Completable_Future_Callable_Left_CompletableFuture_Notes.Flavours_Of_Submit;

import java.util.concurrent.*;

public class Example_Of_Submit_Callable_But_Has_A_Return_Parameter {

    /**
     * In this example will , show you how we are using
     * Runnable Use case , which has no return value
     * **/

    public static void main(String[] args) {

        ThreadPoolExecutor executor = new ThreadPoolExecutor(1  , 1 , 1 , TimeUnit.SECONDS ,
                new ArrayBlockingQueue<>(1) , Executors.defaultThreadFactory() ,
                new ThreadPoolExecutor.AbortPolicy());

        executor.allowCoreThreadTimeOut(true);

        Future<String> future = executor.submit(() -> {
            return "Callable Use case of Submit method";
        });

        /**
         * Basically FutureTask has 3 attributes mainly
         * 1. RunnableTask
         * 2. State
         * 3. Outcome : For Runnable flavour its explicitly set to NULL
         * **/

        /**
         * public <T> Future<T> submit(Callable<T> task) {
         *         if (task == null) throw new NullPointerException();
         *         RunnableFuture<T> ftask = newTaskFor(task);
         *         execute(ftask);
         *         return ftask;
         *     }
         *
         *     RunnableFuture<T> ftask = newTaskFor(task);
         *     Here we are not explicitly passing Null value ,
         *     and we are passing , any outcome explicitly
         *     there is an execute method
         *     execute(ftask); , which will set the outcome in
         *     FutureTask
         *
         * */

        try {
            String obj = future.get();
            System.out.println(obj);
        } catch (Exception e) {

        }


    }
}
