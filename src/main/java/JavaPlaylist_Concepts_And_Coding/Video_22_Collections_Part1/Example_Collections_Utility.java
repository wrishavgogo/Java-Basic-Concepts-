package JavaPlaylist_Concepts_And_Coding.Video_22_Collections_Part1;

import java.util.ArrayList;
import java.util.Collections;


interface Shape {

    public static int getValue() {
        return 2;
    }

    public default int getNewValue() {
        return 3;
    }

    public void method();
}

interface newShape extends Shape {

    @Override
    default void method() {
        System.out.println("done");
    }
}

public class Example_Collections_Utility {

    public static void main(String[] args) {

        ArrayList<Integer> arr = new ArrayList<>();
        arr.add(1);
        arr.add(2);
        arr.add(3);

        System.out.println("max value = " + Collections.max(arr));
        System.out.println("min value = " + Collections.min(arr));
        Collections.shuffle(arr);
        System.out.println("shuffled = " + arr);

        Shape.getValue();

    }
}


