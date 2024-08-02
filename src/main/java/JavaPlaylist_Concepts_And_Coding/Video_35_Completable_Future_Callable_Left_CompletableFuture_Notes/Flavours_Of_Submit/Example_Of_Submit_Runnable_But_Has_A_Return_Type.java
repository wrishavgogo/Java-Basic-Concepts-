package JavaPlaylist_Concepts_And_Coding.Video_35_Completable_Future_Callable_Left_CompletableFuture_Notes.Flavours_Of_Submit;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

public class Example_Of_Submit_Runnable_But_Has_A_Return_Type {


    public static void main(String[] args) {

        ThreadPoolExecutor executor = new ThreadPoolExecutor(1 , 1 , 1 , TimeUnit.SECONDS ,
                new ArrayBlockingQueue<>(1) , Executors.defaultThreadFactory() ,
                new ThreadPoolExecutor.AbortPolicy());

        executor.allowCoreThreadTimeOut(true);

        List<String> arr = new ArrayList<>();


        /**
         * public <T> Future<T> submit(Runnable task, T result) {
         *         if (task == null) throw new NullPointerException();
         *         RunnableFuture<T> ftask = newTaskFor(task, result);
         *         execute(ftask);
         *         return ftask;
         *     }
         *
         *   Checkout the above method , this flavour of submit is what we are using
         *   Its super cool .
         *
         *   RunnableFuture<T> ftask = newTaskFor(task, result); In this line
         *   whatever result we are passing in the argument , that is being set
         *   as outcome to us
         *   The return type is Future<T>
         *       T is the type we are passing in the 2nd argument
         *       we passed List<String> , so we gotta accept the
         *       Future<List<String>>
         * **/
        Future<List<String>> listFuture = executor.submit(new MyRunnable(arr) , arr);

        try {
            List<String> result = listFuture.get();
            System.out.println(result);
        } catch (Exception e) {

        }


    }
}

class MyRunnable implements Runnable {

    private List<String> arr;

    public MyRunnable(List<String> arr) {
        this.arr = arr;
    }

    public void run(){
        arr.add("Usage of Runnable with return type flavour of Submit ");
    }


}
