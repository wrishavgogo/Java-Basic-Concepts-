package JavaPlaylist_Concepts_And_Coding.Video_21_Switch_Cases_Control_Flow.Switch_Case;

public class Example_With_No_Break {

    /**
     * We know about switch statements already ,
     * am having this class to let you know about the few unknown behaviours of switch
     * */

    public static void main(String[] args) {

        int expression = 10;

        switch (expression) {

            case 1:
                System.out.println("this is case 1");
                break;
            case 2:
                System.out.println("this is case 2");
                break;
            case 10:
                System.out.println("this is case 10");
                // note we did not use break statement here
            case 20:
                System.out.println("this is case 20");
            case 30:
                System.out.println("this is case 30");
            default :
                System.out.println("default block : since we did not use break " +
                        "it will keep executing the below statements " +
                        "till it finds any break statement");
        }
    }

}
