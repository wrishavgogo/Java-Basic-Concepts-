package JavaPlaylist_Concepts_And_Coding.Video_35_Completable_Future_Callable_Left_CompletableFuture_Notes.CompletableFuture;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Future;

public class Example_runAsync_Vs_supplyAsync {


    public static void main(String[] args) {

        System.out.println("started network call");
        Future<?> f = CompletableFuture.runAsync(() -> networkCall())
                .thenAccept((value) ->
                        System.out.println("value from network call from runAsync : " + value));

        /***
         * Important difference between runAsync and SupplyAsync
         * runnable does not return any value if your remember
         * in functionalInterface it is void
         *
         * supplies , does not accept any argument and
         * returns a value , hence supplyAsync is used
         *
         * ***/
        CompletableFuture.supplyAsync(() -> networkCall())
                .thenAccept((value) ->
                        System.out.println("value from network call supplyAsync : " + value));

        /**
         * the thenAccept is used to accept return value from networkCall
         * or any other method provided in runAsync()
         * **/

        /***
         * Since the completable Future runs on Daemon threads by default
         * hence main thread might not wait for it
         * */

        sleepALittle(5000);
        try {
            f.get();
        } catch (Exception e) {
        }


        System.out.println("ended network call");

    }


    public static int networkCall() {

        sleepALittle(2000);
        return 5;
    }
    public static void sleepALittle(int seconds) {

        try {
            Thread.sleep(seconds);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
