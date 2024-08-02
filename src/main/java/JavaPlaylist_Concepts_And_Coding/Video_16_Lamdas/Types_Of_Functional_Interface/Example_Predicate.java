package JavaPlaylist_Concepts_And_Coding.Video_16_Lamdas.Types_Of_Functional_Interface;

public class Example_Predicate {

    public static void main(String[] args) {

        Predicate<Integer> evenNumber = (Integer i ) -> {
            return (i % 2) == 0  ;
        };

        evenNumber.test(2);

    }
}

interface Predicate<T> {
    /**
     * Accepts 1 parameter and returns boolean
     * */
    boolean test(T t);
}
