package JavaPlaylist_Concepts_And_Coding.Video_11_Generics_NotesLeftToMake_And_Wildcards_Left.What_Problem_Generic_Class_Solves;

public class Why_Generic_Class {

    public static void main(String[] args) {
        NormalClass nm = new NormalClass();
        nm.setValue("twenty");
        Object valueObtained = nm.getValue();

        if((nm.getValue()) instanceof String ) {
            System.out.println("See this is the problem , " +
                    "next time someone could make the value to any other object" +
                    "for example check below");
        }

        nm.setValue(nm);

        if(nm.getValue() instanceof NormalClass) {
            System.out.println("see how everytime before operating you need to check " +
                    "whose instance is it " +
                    "this makes the problem");
        }
    }
}

class NormalClass {

    private Object id;

    public void setValue(Object id) {
        this.id = id;
    }

    public Object getValue() {
        return id;
    }
}
