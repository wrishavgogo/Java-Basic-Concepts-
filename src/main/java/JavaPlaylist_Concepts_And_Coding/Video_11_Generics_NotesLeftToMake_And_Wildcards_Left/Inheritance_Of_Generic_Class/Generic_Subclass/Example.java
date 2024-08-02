package JavaPlaylist_Concepts_And_Coding.Video_11_Generics_NotesLeftToMake_And_Wildcards_Left.Inheritance_Of_Generic_Class.Generic_Subclass;

public class Example {

    /**
     * Example of Generic Subclass
     * */

    public static void main(String[] args) {
        ColorPrint<String> colorPrint = new ColorPrint<String>();
        colorPrint.setValue("id");
        colorPrint.getValue();
    }
}

class Print<T> {

    T id ;

    public T getValue() {
        return id;
    }

    public void setValue(T id) {
        this.id = id;
    }

}

class ColorPrint<T> extends Print<T> {

    /**
     * This ColorPrint<T> is now a GenericSubclass of Print<T>
     * */
}