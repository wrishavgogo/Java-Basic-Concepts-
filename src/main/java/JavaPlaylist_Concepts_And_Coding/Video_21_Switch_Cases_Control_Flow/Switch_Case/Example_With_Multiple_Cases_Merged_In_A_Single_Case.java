package JavaPlaylist_Concepts_And_Coding.Video_21_Switch_Cases_Control_Flow.Switch_Case;

public class Example_With_Multiple_Cases_Merged_In_A_Single_Case {

    public static void main(String[] args) {


        int expression = 10;

        switch (expression) {

            case 15 :
            case 20 :
            case 1 :
                System.out.println("either 15 , 20 or 1");
            default:
                System.out.println("Number not found :(");
                System.out.println("This is to show how we clubbed cases together");
        }

        /**
         * Below is easier way to club cases together
         * */

        String monthExpression = "November";

        switch (monthExpression) {

            case "January",
                 "February",
                 "March",
                 "April",
                 "May",
                 "June",
                 "July":
                System.out.println("Month within January to May");
                break;
            case "August",
                 "September",
                 "October" :
                System.out.println("Month within Aug to Oct");
                break;
            default :
                System.out.println("Month not found");
                break; // optional since you have given default at the last
        }

        System.out.println("This example shows how We can provide multiple values " +
                "in the expression using comma separated ");
    }
}
