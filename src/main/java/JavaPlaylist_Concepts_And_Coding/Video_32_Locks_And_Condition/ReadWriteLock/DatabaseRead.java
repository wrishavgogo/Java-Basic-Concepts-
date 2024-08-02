package JavaPlaylist_Concepts_And_Coding.Video_32_Locks_And_Condition.ReadWriteLock;

public class DatabaseRead implements Runnable{

    SharedResource sharedResource;

    public DatabaseRead(SharedResource sharedResource) {
        this.sharedResource = sharedResource;
    }

    @Override
    public void run() {
        sharedResource.getItem();
    }
}
