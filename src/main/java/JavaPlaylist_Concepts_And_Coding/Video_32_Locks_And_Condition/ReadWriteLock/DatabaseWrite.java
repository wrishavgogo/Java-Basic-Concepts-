package JavaPlaylist_Concepts_And_Coding.Video_32_Locks_And_Condition.ReadWriteLock;

public class DatabaseWrite implements Runnable{

    SharedResource sharedResource;

    public DatabaseWrite(SharedResource sharedResource) {
        this.sharedResource = sharedResource;
    }

    @Override
    public void run() {
        sharedResource.setItem();
    }

}
