package JavaPlaylist_Concepts_And_Coding.Video_21_Switch_Cases_Control_Flow.Switch_Case;

public class Example_With_Nested_Switch {


    public static void main(String[] args) {

        int age = 10;
        String month = "Nov";

        switch (age) {

            case 10,20,30,40:
                // inside one of the case
                switch (month) {
                    // there is another switch section
                    case "January","Feb","Mar","Apr","May" :
                        age += -1;
                        break;
                    case "August","Sept","Oct" :
                        age += 2;
                        break;
                    case "Nov","Dec" :
                        age += 4;
                        break;
                }
            case 31 :
                System.out.println("Flow went inside the nested Switch section");
                System.out.println("age = " + age);
                break;
        }
    }
}
