package JavaPlaylist_Concepts_And_Coding.Video_11_Generics_NotesLeftToMake_And_Wildcards_Left.Bounded_Generics.Multi_Bound;

public class Example {

    /**
     * If you want to bound Classes on multiple Restrictive bounds
     * then you can use MultiBound
     *
     * Syntax : -
     *
     * public class A <T extends ConcreteClass & Interface1 & Interface2 >
     *
     * We know in java , a class can atmax extend 1 concrete Class
     * And implement Multiple Interfaces , hence we can bound as many Interfaces as possible
     * but concreate Class should be 1
     * First Bound should be on Concrete Class ,
     * **/

    public static void main(String[] args) {

        MultiBoundGenericClass<A> satisfiesBounds = new MultiBoundGenericClass<>();
        // NO ERROR since all the bounds are satisfied

        //MultiBoundGenericClass<B> doesNotSatisfy = new MultiBoundGenericClass<>();
        /**
         * Uncomment the code to see that doesNotSatisfy error
         * */
    }
}

interface Interface1 {

}

interface Interface2 {

}

class ConcreteClass {

}

class MultiBoundGenericClass < T extends ConcreteClass & Interface1 & Interface2 > {

}

/**
 * A satisfies all the bounds of the MultiBoundGenericClass
 * */
class A extends ConcreteClass implements Interface1,Interface2 {

}

/**
 * B does not implement Interface 2 so it does not satisfy the criteria of
 * bounds provided by the Generic class
 * */
class B extends ConcreteClass implements Interface1 {

}




