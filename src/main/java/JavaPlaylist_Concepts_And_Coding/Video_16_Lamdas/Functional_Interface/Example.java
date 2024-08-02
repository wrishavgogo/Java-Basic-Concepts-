package JavaPlaylist_Concepts_And_Coding.Video_16_Lamdas.Functional_Interface;

public class Example {

    /**
     * Functional Interface should have only 1 abstract method
     * that is the rule
     *
     * We can provide @FunctionalInterface annotation but that is optional
     *
     * It should have only 1 abstract method , but it can have multiple
     * static Methods , multiple default methods
     *
     *
     * **/
}

interface Bird {

    void canFly();
}

@FunctionalInterface
interface Person {

    void canWalk();
}

@FunctionalInterface
interface LivingBeing {

    void canBreathe();

    static void staticMethod() {
        // some implementation
    }

    default void defaultMethod() {
        // some implementation
    }

    String toString();
    /**
     * This toString method is from the object class
     * which has been used in the interface
     * Any class implementing this interface need not implement this method
     * because all classes implicitly extend the Object class
     * */

}
