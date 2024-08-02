package JavaPlaylist_Concepts_And_Coding.Video_32_Locks_And_Condition.Condition;

public class ConsumerTask implements Runnable{

    SharedResource sharedResource;

    public ConsumerTask(SharedResource sharedResource) {
        this.sharedResource = sharedResource;
    }

    @Override
    public void run() {
        sharedResource.consumeItem();
    }

}
