package JavaPlaylist_Concepts_And_Coding.Video_16_Lamdas.Types_Of_Functional_Interface;

public class Example_Consumer {

    public static void main(String[] args) {

        Consumer<Integer> consumer = (Integer val) -> {
            System.out.println(val + " used in consumer example");
        };

        consumer.accept(12);
    }
}

/**
 * Already inbuilt in java though
 * am just writing it again
 * */
@FunctionalInterface
interface Consumer<T> {
    /**
     * Accepts the argument and returns nothing
     * */
    void accept(T t);
}
