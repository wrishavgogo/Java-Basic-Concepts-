package JavaPlaylist_Concepts_And_Coding.Video_11_Generics_NotesLeftToMake_And_Wildcards_Left.Bounded_Generics.Upper_Bound;

public class Example {

    /**
     * Upper Bound (<T extends Number> ) means T can be of type Number or any of its child class only .
     * Here Number is a class , we can even have an interface
     * UpperBound ( <T extends Interface> )
     * UpperBound ( <T extends AbstractClass> )
     * **/

    public static void main(String[] args) {

        Print<Integer> upperBoundObj = new Print<>(); // this is valid
        // since Number ---> ( is extended by ) Integer

        //Print<String> newRules = new Print<>();
        /**
         * UnComment The above line to see Error , since String is not a subclass of Number
         * or even Number itself
         * */

    }

}

class Print<T extends Number> {

    T value;

}
