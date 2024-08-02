package JavaPlaylist_Concepts_And_Coding.Video_30_Thread_Creation_Thread_Lifecycle_Inter_Thread_Communication.Thread_Class_Extending;

public class Example {

    public static void main(String[] args) {

        MultiThreadingLearning multiThreadingLearning = new MultiThreadingLearning();
        multiThreadingLearning.start();
        System.out.println("main thread finished");
    }
}

class MultiThreadingLearning extends Thread {

    @Override
    public void run(){

        try {
            Thread.sleep(3000);
        } catch (Exception e) {

        }
        System.out.println("implementing Thread by extending Thread Class");
    }
}
