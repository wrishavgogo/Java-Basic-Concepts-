package JavaPlaylist_Concepts_And_Coding.Video_31_Thread_Joining_Daemon.Thread_Priority;

public class Example {

    public static void main(String[] args) {

        Thread t1 = new Thread(() -> {
            System.out.println("do something");
        });

        t1.setPriority(9);
    }
}
