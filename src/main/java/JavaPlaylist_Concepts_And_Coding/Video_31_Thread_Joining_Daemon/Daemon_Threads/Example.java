package JavaPlaylist_Concepts_And_Coding.Video_31_Thread_Joining_Daemon.Daemon_Threads;

public class Example {

    public static void main(String[] args) {

        Thread t1 = new Thread(() -> {

            try {
                Thread.sleep(9000);
            } catch (Exception e) {

            }
        });

        t1.setDaemon(true);
        t1.start();

        System.out.println("Main thread ends here");

        /**
         * No waiting for thread 1
         * */
    }
}
