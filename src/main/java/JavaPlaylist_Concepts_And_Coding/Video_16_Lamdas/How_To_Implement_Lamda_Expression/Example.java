package JavaPlaylist_Concepts_And_Coding.Video_16_Lamdas.How_To_Implement_Lamda_Expression;

public class Example {


    public static void main(String[] args) {

        /** 2nd way , Making an anonymous Class **/

        Bird obj = new Bird() {
            @Override
            public void canFly(String val) {
                // some Implementation
            }
        };

        /** 3rd way , By Lambda Expression */


        Bird birdObj = (String value) -> {
            System.out.println(value + " used in lambda expression ");
        };

        birdObj.canFly("Functional Interface");



    }



}

@FunctionalInterface
interface Bird {
    void canFly(String val);
}

/** 1st Way , Making a concrete class */
class BirdClass implements Bird {

    @Override
    public void canFly(String val) {
        // some implementation
    }

    public static void main(String[] args) {

        Bird oneLineImplementation = (String value) -> System.out.println("Lambda having " +
                "1 line implementation only ");

        oneLineImplementation.canFly("1 line implementation");
    }
}
