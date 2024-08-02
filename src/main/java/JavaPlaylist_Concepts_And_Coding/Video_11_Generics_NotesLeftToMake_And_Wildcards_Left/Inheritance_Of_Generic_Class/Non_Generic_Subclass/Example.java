package JavaPlaylist_Concepts_And_Coding.Video_11_Generics_NotesLeftToMake_And_Wildcards_Left.Inheritance_Of_Generic_Class.Non_Generic_Subclass;

public class Example {
}

class Print<T> {

    T value;

    public T getValue() {
        return value;
    }

    public void setValue(T value) {
        this.value = value;
    }
}

class ColorPrint extends Print<String> {

    /**
     * The important part is that since the subclass is non-generic
     * Hence it needs a concrete parent class
     * which we have defined as Print<String>
     * */
}
