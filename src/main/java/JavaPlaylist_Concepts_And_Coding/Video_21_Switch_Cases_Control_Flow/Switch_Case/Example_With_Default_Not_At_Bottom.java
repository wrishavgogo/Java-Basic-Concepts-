package JavaPlaylist_Concepts_And_Coding.Video_21_Switch_Cases_Control_Flow.Switch_Case;

public class Example_With_Default_Not_At_Bottom {

    public static void main(String[] args) {

        int expression = 45;

        switch (expression) {

            case 1:
                System.out.println("this is case 1");
                break;
            case 2:
                System.out.println("this is case 2");
                break;
            default :
                System.out.println("default block : since we did not use break " +
                        "it will keep executing the below statements " +
                        "till it finds any break statement");
                // note we did not use break statement here
            case 10:
                System.out.println("this is case 10");
            case 20:
                System.out.println("this is case 20");
            case 30:
                System.out.println("this is case 30");
                break;
            case 40:
                System.out.println("this is case 30");

        }
    }
}
