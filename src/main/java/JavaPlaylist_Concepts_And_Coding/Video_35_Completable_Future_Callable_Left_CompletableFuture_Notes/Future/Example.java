package JavaPlaylist_Concepts_And_Coding.Video_35_Completable_Future_Callable_Left_CompletableFuture_Notes.Future;

import java.util.concurrent.*;

public class Example {
    /**
     * In this example we will see how
     * Future is returned by thread pool executor and how different methods of it are used
     * */

    public static void main(String[] args) {

        ThreadPoolExecutor executor = new ThreadPoolExecutor(1 , 1 , 1  , TimeUnit.SECONDS ,
                new ArrayBlockingQueue<Runnable>(1) , Executors.defaultThreadFactory()
                , new ThreadPoolExecutor.DiscardPolicy());

        // this is to kill the idle thread after KEEP ALIVE time is done
        executor.allowCoreThreadTimeOut(true);
        Future futureObj = executor.submit(() -> {
            try {
                // Runnable task is running for 7 seconds
                Thread.sleep(7000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });

        /***
         * Working mechanism of Future
         *
         * executor.submit() -->  returns us RunnableFuture ( lets say x )
         * RunnableFuture x = newfTask()
         * newfTask in turn returns --> FutureTask
         *
         * Class FutureTask<V> implements RunnableFuture<V>
         *
         * Interface RunnableFuture<V> extends Runnable, Future<V>
         *
         *     So returnType of executor.submit  ----> Future
         * **/

        try {
            // made the main thread sleep for 2 seconds
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        // checking to see if the executor has completed the task or not
        System.out.println("is executor job done " + futureObj.isDone());

        try {
            // trying to check again with a timeout of 1 second
            // if the pool has finished its execution
            futureObj.get(1 , TimeUnit.SECONDS);
        } catch (Exception e) {

        }

        try {
            // get the object
            futureObj.get();
        } catch (Exception e) {

        }

        // check finally if it's done or not
        System.out.println("is executor job done " +futureObj.isDone());





    }
}


