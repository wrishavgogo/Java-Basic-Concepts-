package JavaPlaylist_Concepts_And_Coding.Video_11_Generics_NotesLeftToMake_And_Wildcards_Left.Raw_Type;

public class Example {

    public static void main(String[] args) {

        GenericClass<String> stringGenericClass = new GenericClass<>();
        // above is a parameterised Generic Class , we have provided the Type it should have


        // Non Parameterised Generic Class ---> Raw Class
        // internally Java creates it like
        // GenericClass<Object> genericClass = new GenericClass<>();
        GenericClass genericClass = new GenericClass();
        genericClass.setValue("1");
        genericClass.setValue("One");
    }
}

class GenericClass<T> {

    T value;

    public void setValue(T value) {
        this.value = value;
    }

    public T getValue() {
        return value;
    }
}
