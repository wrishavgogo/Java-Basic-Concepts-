package JavaPlaylist_Concepts_And_Coding.Video_35_Completable_Future_Callable_Left_CompletableFuture_Notes.Flavours_Of_Submit;

import java.util.concurrent.*;

public class Example_Of_Submit_Runnable_With_No_Return_Type {

    /**
     * In this example will , show you how we are using
     * Runnable Use case , which has no return value
     * **/

    public static void main(String[] args) {

        ThreadPoolExecutor executor = new ThreadPoolExecutor(1 , 1 , 1 , TimeUnit.SECONDS ,
                new ArrayBlockingQueue<>(1) , Executors.defaultThreadFactory() ,
                new ThreadPoolExecutor.AbortPolicy());

        executor.allowCoreThreadTimeOut(true);
        Future<?> futureObj = executor.submit(() -> {
            System.out.println("Runnable flavour with no return value " +
                    "is called ");
        });

        /**
         * By default this futureObj will be made Future<Void>
         * */

        /**
         *
         * In the above case the below implementation of Submit is being called
        public Future<?> submit(Runnable task) {
            if (task == null) throw new NullPointerException();
            RunnableFuture<Void> ftask = newTaskFor(task, null);
            execute(ftask);
            return ftask;
        }

         RunnableFuture<Void> ftask = newTaskFor(task, null);

         ^^ Focus on the above line ,
         newTaskFor --> Creates a FutureTask , in the 2nd parameter
         we are passing outcome : which is already Null
         **/

        Object object = null ;

        try {
            object = futureObj.get();
        } catch (Exception e) {
            // we need to catch the exception , because the get method throws exception
        }

        /**
         * Since this flavour does not return anything hence the object will be null
         * */
        System.out.println(object == null);
    }
}
