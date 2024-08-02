package JavaPlaylist_Concepts_And_Coding.Video_10_Nested_Classes_Abstract_Classes.Non_Static_Nested_Inner_Class_Example;

public class Non_Static_Nested_Inner_Class_Example {

    public static void main(String[] args) {
        //OuterClass.Non_Static_Inner_Class obj = new OuterClass.Non_Static_Inner_Class();
        // this constructor will not be available to you , since using ClassName we can only call static methods
        // Since constructor cannot be static , so it we can only call the constructor of inner class
        // after creating an instance of outer class
        OuterClass outObj = new OuterClass();
        OuterClass.Non_Static_Inner_Class innerObj = outObj.new Non_Static_Inner_Class();
        /**  Pay High Attention to how the constructor of inner class is invoked */
        innerObj.method();
    }
}

class OuterClass {

    int x = 0;
    static int y = 1;
    class Non_Static_Inner_Class {

        public void method() {
            System.out.println(x + y); // both static and non_static can be accessed from here
        }
    }

}
