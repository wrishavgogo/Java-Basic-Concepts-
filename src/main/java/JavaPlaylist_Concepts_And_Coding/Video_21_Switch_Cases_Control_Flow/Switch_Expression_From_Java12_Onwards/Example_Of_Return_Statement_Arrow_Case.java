package JavaPlaylist_Concepts_And_Coding.Video_21_Switch_Cases_Control_Flow.Switch_Expression_From_Java12_Onwards;

public class Example_Of_Return_Statement_Arrow_Case {


    public static void main(String[] args) {

        int age = 10;

        /**
         * Switch Expression Using ->N Label
         * **/
        String val = switch (age) {

            case 20 -> ("20");
            case 10 -> ("10");
            case 30 -> ("40");
            default -> ("default");
        };

        System.out.println(age);
    }
}
