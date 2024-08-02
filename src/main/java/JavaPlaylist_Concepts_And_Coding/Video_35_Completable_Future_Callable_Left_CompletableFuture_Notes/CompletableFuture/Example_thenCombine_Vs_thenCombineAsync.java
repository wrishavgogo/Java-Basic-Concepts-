package JavaPlaylist_Concepts_And_Coding.Video_35_Completable_Future_Callable_Left_CompletableFuture_Notes.CompletableFuture;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class Example_thenCombine_Vs_thenCombineAsync {

    public static void main(String[] args) {

        CompletableFuture<Integer> future1 = CompletableFuture.supplyAsync(() -> {
            System.out.println("thread executing future1 = " + Thread.currentThread().getName());
            return 100;
        });

        CompletableFuture<String> future2 = CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(4000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println("thread executing future2 = " + Thread.currentThread().getName());
            return "suffix";
        });

        // combining future 1 with future2

        /**
         *
         *  public <U,V> CompletableFuture<V> thenCombine(
         *         CompletionStage<? extends U> other,
         *         BiFunction<? super T,? super U,? extends V> fn) {
         *         return biApplyStage(null, other, fn);
         *     }
         * **/

        // future2 ---> String
        // the first argument of the value is the returnType of future1
        // 2nd argument is return type of value of future2

        CompletableFuture<Double> combinedFuture = future1.thenCombine(future2 ,
                (Integer valueFromFuture1 , String valueFromFuture2) -> {
                    System.out.println("thread executing combining future1 and future2 " +
                            "Asynchronously = "
                            + Thread.currentThread().getName());
                    String res = valueFromFuture1.toString() + valueFromFuture2;
                    Double val = res.length() / 2.00;
                    return val;
                });


        /***
         * Out of the two whichever future thread's execution finishes last ,
         * that thread will continue on the combining tasks
         * **/

        try {
            System.out.println("result from combinedFuture = " + combinedFuture.get());
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } catch (ExecutionException e) {
            throw new RuntimeException(e);
        }



        /***
         * Using combining thenCombineAsync
         *
         * ****/



        CompletableFuture<Double> combinedFutureAsync = future1.thenCombineAsync(future2 ,
                (Integer valueFromFuture1 , String valueFromFuture2) -> {
                    System.out.println("thread executing combining future1 and future2 = "
                            + Thread.currentThread().getName());
                    String res = valueFromFuture1.toString() + valueFromFuture2;
                    Double val = res.length() / 2.00;
                    return val;
                });

        /***
         * Here is no gurantee which thread will execute the combinedAsync
         * might be a completely new thread
         * **/

        try {
            System.out.println("result from combinedFuture Asynchronously= " + combinedFutureAsync.get());
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } catch (ExecutionException e) {
            throw new RuntimeException(e);
        }

    }
}
