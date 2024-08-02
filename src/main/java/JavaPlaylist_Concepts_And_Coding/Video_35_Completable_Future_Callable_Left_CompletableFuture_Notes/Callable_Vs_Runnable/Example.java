package JavaPlaylist_Concepts_And_Coding.Video_35_Completable_Future_Callable_Left_CompletableFuture_Notes.Callable_Vs_Runnable;

import java.util.concurrent.*;

public class Example {

    /***
     * The executor.submit() method has 3 variants
     * 1. submit(Runnable task)
     * 2. submit(Runnable task, T result)
     * 3. submit(Callable<T> task)
     *
     * Q) is how do we know We are not passing runnable into the submit method
     *
     * See the difference below , Callable returns something whereas Runnable does not return anything
     * */

    /**
     * Follow the below example to understand more properly
     *
     *
     * */

    public static void main(String[] args) {

        ThreadPoolExecutor executor = new ThreadPoolExecutor(1 , 1 , 1 , TimeUnit.SECONDS ,
                new ArrayBlockingQueue<>(1) , Executors.defaultThreadFactory() ,
                new ThreadPoolExecutor.AbortPolicy());

        /**
         * This is directly calling the runnable flavour of submit , because we have passed runnable
         * */
        Future futureRunnableObj = executor.submit(() -> System.out.println("calls runnable , step inside the method to see"));

        /**
         * This is directly calling the callable flavour of submit , because its returning
         * a value ,  we have called a callable mode of the submit method
         * Step into the method to see for yourself
         * */
        Future futureCallableObj = executor.submit(() -> {return "Callable Implementation";});

    }
}

@FunctionalInterface
interface Runnable{
    public void run();
}

@FunctionalInterface
interface Callable<T> {
    T call() throws Exception;
}
