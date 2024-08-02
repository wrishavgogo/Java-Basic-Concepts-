package JavaPlaylist_Concepts_And_Coding.Video_10_Nested_Classes_Abstract_Classes.Static_Nested_Class_Example;

public class Static_Nested_Class_Example {

    public static void main(String[] args) {

        OuterClass.Nested_Inner_Class obj = new OuterClass.Nested_Inner_Class();
        System.out.println("This shows to create an instance of the nested Inner class " +
                "we do not need to initialise the Outer Class");


    }
}

class OuterClass {

    int non_static_instance_variable = 10;
    static int static_instance_variable = 4;

    static class Nested_Inner_Class {

        public void innerClassMethod() {

            //System.out.println(non_static_instance_variable + static_instance_variable );
            // non_static_instance_variable cannot be accessed inside it
        }
    }

    private static class Private_AccessSpecifier_Nested_Inner_Class {

        public void method() {
            System.out.println("this is to show only static inner class " +
                    "can have accessSpecifier as Private/Protected " +
                    "no other classes can have it ");
        }
    }

    public void display() {

        /**
         * This part shows that Objects of private static nested classes can be initialised inside
         * the OuterClass
         * **/
        Private_AccessSpecifier_Nested_Inner_Class obj = new Private_AccessSpecifier_Nested_Inner_Class();
        obj.method();
    }
}
