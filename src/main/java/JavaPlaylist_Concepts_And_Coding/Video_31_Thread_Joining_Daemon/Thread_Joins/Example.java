package JavaPlaylist_Concepts_And_Coding.Video_31_Thread_Joining_Daemon.Thread_Joins;

public class Example {

    public static void main(String[] args) {

        Thread th1 = new Thread(() -> {

            try {
                Thread.sleep(9000);
            }
            catch ( Exception e) {

            }

            System.out.println("thread 1 finished");
        });

        th1.start();

        try {
            th1.join();
        } catch ( Exception e ) {

        }

        /**
         * No matter how many times we do it ,
         * Thread 1 will finish then thread main will finish
         * Main thread will wait for thread1 to finish
         * **/


        System.out.println("Main thread finished");
    }
}

