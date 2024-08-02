package JavaPlaylist_Concepts_And_Coding.Video_16_Lamdas.Types_Of_Functional_Interface;

public class Example_Function {

    public static void main(String[] args) {
        Function<Integer , String> function = (Integer t) -> {

            if( (t % 2 ) == 0 ) {
                return "even";
            }
            return "odd";
        };

        function.apply(2);
    }
}

@FunctionalInterface
interface Function<T , R> {
    /**
     * Accepts one parameter
     * and returns 1 result
     * */
    R apply(T t);
}
