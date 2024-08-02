package JavaPlaylist_Concepts_And_Coding.Video_10_Nested_Classes_Abstract_Classes.Anonymous_Inner_Class;

public class Anonymous_Inner_Class_Example {

    public static void main(String[] args) {

        Car eV = new Car() {
            @Override
            public void pressBreak() {
                System.out.println("Electric Car break");
            }
        };

        eV.pressBreak();

        Shape square = new Shape() {

            @Override
            public void draw() {
                System.out.println("Draw a square");
            }
        };

        square.draw();

    }
}

interface Car {

    public void pressBreak();
}

abstract class Shape {

    public abstract void draw();
}
