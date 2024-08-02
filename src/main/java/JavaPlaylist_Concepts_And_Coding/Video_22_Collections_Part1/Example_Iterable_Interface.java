package JavaPlaylist_Concepts_And_Coding.Video_22_Collections_Part1;

import java.util.ArrayList;
import java.util.Iterator;

public class Example_Iterable_Interface {

    public static void main(String[] args) {

        ArrayList<Integer> arr = new ArrayList<>();
        arr.add(1);
        arr.add(2);
        arr.add(3);
        arr.add(4);
        arr.add(5);

        Iterator<Integer> it = arr.iterator();
        while(it.hasNext()) {
            int val = it.next();
            System.out.println(val);
            if(val == 3) {
                it.remove();
            }
        }

        System.out.println(arr);
    }
}
