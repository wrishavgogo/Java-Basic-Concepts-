package JavaPlaylist_Concepts_And_Coding.Video_08_Java_Constructor_In_Depth.Constructor_Chaining;

public class Calculation {


    /***
     * The following is an example of
     * constructor chaining
     * */
    String name;
    int empId;

    Calculation() {
        this(10);
    }

    Calculation(int empId) {
        this("employeeName" , empId);
    }

    Calculation(String name , int empId) {
        this.name = name;
        this.empId = empId;
    }
}
