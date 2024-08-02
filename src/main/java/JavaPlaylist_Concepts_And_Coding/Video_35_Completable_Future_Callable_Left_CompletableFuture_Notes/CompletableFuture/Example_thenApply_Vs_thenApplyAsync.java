package JavaPlaylist_Concepts_And_Coding.Video_35_Completable_Future_Callable_Left_CompletableFuture_Notes.CompletableFuture;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class Example_thenApply_Vs_thenApplyAsync {

    /***
     * In this example , we will see chaining of operations and thenRun()
     * even after accepting values from the variables we can get it do run different methods
     *
     * */

    public static void main(String[] args) {

        CompletableFuture syncFutureChaining = CompletableFuture.supplyAsync(() -> someNetworkCall())
                .thenApply((Integer value) -> multiplyByTen(value))
                .thenApply((Integer value) -> addHundred(value))
                .thenAccept((value) -> System.out.println("after chaining value is : " +  value))
                .thenRun(() -> methodCall());

        try {
            syncFutureChaining.get();
            // since we are using thenApply , it is a
            // sync process and the thread which completed supplyAsync
            // that thread itself is responsible to complete the process

        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } catch (ExecutionException e) {
            throw new RuntimeException(e);
        }


        /****
         * IMP : thenApply() -> accepts a Function , hence we must pass anything
         * or any method that has a return type
         * **/

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }


        CompletableFuture<String> futureAsync = CompletableFuture.supplyAsync(() -> {
            return "Hello";
        }).thenApplyAsync((String val) -> {

            System.out.println("thread executing 1st thenApplyAsync = " + Thread.currentThread().getName());
            try {
                Thread.sleep(4000);

                /***
                 * This 4 seconds delay is added just to show you that
                 * order of execution is always maintained
                 *
                 * Response will always be Helloworldall
                 * **/
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            return val + "world";
                }).thenApplyAsync((String val) -> {

                    System.out.println("thread executing 2nd thenApplyAsync = " + Thread.currentThread().getName());
                    return val + "all";
                });

//
//        Even though thenApplyAsync can run these stages asynchronously,
//        the completion of one stage will not start the next stage until the current one is done.
//                Thus, the order of the operations is preserved:


        try {
            System.out.println(futureAsync.get());
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } catch (ExecutionException e) {
            throw new RuntimeException(e);
        }

    }

    public static void methodCall() {

        System.out.println(Thread.currentThread().getName() + " post chaining ops");
        System.out.println("this method runs after all the chaining is completed  ");
    }

    public static int someNetworkCall() {

        System.out.println(Thread.currentThread().getName() + " doing network call");
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        return 5;
    }

    public static int multiplyByTen(int val) {

        System.out.println(Thread.currentThread().getName() + " multiply by 10");
        return  val * 10;
    }

    public static int addHundred(int val) {

        System.out.println(Thread.currentThread().getName() + " add hundred");
        return  val + 100;
    }
}


