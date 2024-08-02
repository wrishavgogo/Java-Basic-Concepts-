package JavaPlaylist_Concepts_And_Coding.Video_32_Locks_And_Condition.ProducerConsumerProblem;

public class Main {

    public static void main(String[] args) {

        /****
         *
         *  Q) What is producer Consumer problem ?
         *
         *  A) We have a queue of fixed size , lets say 5 , and you have multiple
         *      consumer threads and producer threads , you need to make sure
         *      that consumer thread does not consume when queue is empty
         *      and producer thread does not produce when queue is full , i.e size = 5
         *
         */

        SharedResource sharedResource = new SharedResource(5);

        for(int i = 0 ; i < 5 ; i ++ ) {
            Thread producerThread = new Thread(new ProducerTask(sharedResource));
            Thread consumerThread = new Thread(new ConsumerTask(sharedResource));
            producerThread.start();
            consumerThread.start();
        }



    }
}
