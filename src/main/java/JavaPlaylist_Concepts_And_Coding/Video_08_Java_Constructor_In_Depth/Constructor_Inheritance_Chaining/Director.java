package JavaPlaylist_Concepts_And_Coding.Video_08_Java_Constructor_In_Depth.Constructor_Inheritance_Chaining;

public class Director extends Manager{

    Director() {
        // super() --> this has a hidden super method here ,
        // internally Java calls this method , even if you write it explicitly , it won't make any difference
        System.out.println("this is the constructor of Director Class");
    }

    public static void main(String[] args) {

        Director director = new Director();

        /**
         * this is the constructor of Person class
         * this is the constructor of Manager Class
         * this is the constructor of Director Class
         *
         * Output ^^
         * Constructor chaining happened, It goes to the top level and initiates
         * Person ---> Manager ---> Director
         * */
    }
}
