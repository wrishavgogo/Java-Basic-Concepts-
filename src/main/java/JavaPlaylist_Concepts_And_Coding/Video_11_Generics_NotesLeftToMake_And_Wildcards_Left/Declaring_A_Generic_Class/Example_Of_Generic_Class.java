package JavaPlaylist_Concepts_And_Coding.Video_11_Generics_NotesLeftToMake_And_Wildcards_Left.Declaring_A_Generic_Class;

public class Example_Of_Generic_Class {

    public static void main(String[] args) {

        GenericClass<Integer> integerGenericObject = new GenericClass<Integer>();
        integerGenericObject.setValue(10);
        System.out.println("Here I used the class as Integer" + integerGenericObject.getValue());

        GenericClass<String> stringGenericObject = new GenericClass<String>();
        stringGenericObject.setValue("value");
        System.out.println("Here I used the same Generic class as String " + stringGenericObject.getValue());
    }

}

/**
 * Note how T is written within the diamond brackets beside the className
 * Rest all can be used as it is
 * */
class GenericClass<T> {

    T id;

    public void setValue(T id) {
        this.id = id;
    }

    public T getValue() {
        return id;
    }
}
