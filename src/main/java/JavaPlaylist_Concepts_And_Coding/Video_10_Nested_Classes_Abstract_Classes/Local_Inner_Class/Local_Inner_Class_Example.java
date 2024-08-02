package JavaPlaylist_Concepts_And_Coding.Video_10_Nested_Classes_Abstract_Classes.Local_Inner_Class;

public class Local_Inner_Class_Example {
}


class Outer {

    public void display() {

        class Inner {

            public void method() {

            }
        }

        Inner in = new Inner();
        in.method(); // only here this scope ends after this
    }
}