package JavaPlaylist_Concepts_And_Coding.Video_35_Completable_Future_Callable_Left_CompletableFuture_Notes.CompletableFuture;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class Example_thenCompose_thenComposeAsync {


    public static void main(String[] args) {




        CompletableFuture future = CompletableFuture.supplyAsync(() -> {
            return "hello";
        }).thenCompose((String val) -> {

            try {
                Thread.sleep(4000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println("Thread in sync = " + Thread.currentThread().getName());
            return CompletableFuture.supplyAsync(() -> {
                try {
                    Thread.sleep(4000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                System.out.println("Thread in sync = " + Thread.currentThread().getName());
                return val + " world";
            });

        }).thenCompose((String val) -> {
            return CompletableFuture.supplyAsync(() -> {
                try {
                    Thread.sleep(4000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                System.out.println("Thread in sync = " + Thread.currentThread().getName());
                return val + " all";
            });
        });

        try {
            System.out.println(future.get());
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } catch (ExecutionException e) {
            throw new RuntimeException(e);
        }

        CompletableFuture futureAsync = CompletableFuture.supplyAsync(() -> {
            System.out.println("Thread in Async = " + Thread.currentThread().getName());
            return "hello";
        }).thenComposeAsync((String val) -> {

            try {
                Thread.sleep(4000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println("Thread in Async = " + Thread.currentThread().getName());
            return CompletableFuture.supplyAsync(() -> {
                return val + " world";
            });

        }).thenComposeAsync((String val) -> {

            try {
                Thread.sleep(4000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println("Thread in Async = " + Thread.currentThread().getName());
            return CompletableFuture.supplyAsync(() -> {
                return val + " all";
            });
        });

        try {
            System.out.println(futureAsync.get());
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } catch (ExecutionException e) {
            throw new RuntimeException(e);
        }
    }
}
