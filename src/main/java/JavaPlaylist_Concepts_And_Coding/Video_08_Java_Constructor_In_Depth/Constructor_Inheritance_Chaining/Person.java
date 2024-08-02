package JavaPlaylist_Concepts_And_Coding.Video_08_Java_Constructor_In_Depth.Constructor_Inheritance_Chaining;

public class Person {

    Person() {
        // super() --> this has a hidden super method here ,
        // internally Java calls this method , even if you write it explicitly , it won't make any difference
        System.out.println("this is the constructor of Person class");
    }
}
