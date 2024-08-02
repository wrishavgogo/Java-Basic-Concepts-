package JavaPlaylist_Concepts_And_Coding.Video_32_Locks_And_Condition.Semaphores;

import java.util.concurrent.Semaphore;

public class Main {

    public static void main(String[] args) {

        Semaphore semaphore = new Semaphore(2);
        // only 2 threads are allowed into the critical section at a time
        SharedResource sharedResource1 = new SharedResource(semaphore);
        SharedResource sharedResource2 = new SharedResource(semaphore);

        for(int i = 0 ; i < 5 ; i ++ ) {

            Thread t1 = new Thread(new ConsumerTask(sharedResource2));
            Thread t2 = new Thread(new ConsumerTask(sharedResource1));
            t1.start();
            t2.start();
        }



    }
}
