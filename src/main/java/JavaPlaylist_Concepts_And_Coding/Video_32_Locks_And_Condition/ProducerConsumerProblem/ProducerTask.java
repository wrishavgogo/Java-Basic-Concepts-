package JavaPlaylist_Concepts_And_Coding.Video_32_Locks_And_Condition.ProducerConsumerProblem;

public class ProducerTask implements Runnable{

    SharedResource sharedResource;

    public ProducerTask(SharedResource sharedResource) {
        this.sharedResource = sharedResource;
    }

    @Override
    public void run() {
        sharedResource.addItem();
    }
}
