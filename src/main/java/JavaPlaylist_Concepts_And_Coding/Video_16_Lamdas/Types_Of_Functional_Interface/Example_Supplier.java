package JavaPlaylist_Concepts_And_Coding.Video_16_Lamdas.Types_Of_Functional_Interface;

public class Example_Supplier {

    public static void main(String[] args) {
        Supplier<String> supplier = () -> {
            return "Supplier String example";
        };

        supplier.get();

    }
}

@FunctionalInterface
interface Supplier<T> {
    /**
     * Returns a value
     * and accepts no parameter
     * */
    T get();
}
