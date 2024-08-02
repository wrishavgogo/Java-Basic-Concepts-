package JavaPlaylist_Concepts_And_Coding.Video_21_Switch_Cases_Control_Flow.Switch_Expression_From_Java12_Onwards;

public class Example_Of_Return_Statement_Using_Yield_Statement {

    public static void main(String[] args) {

        int age = 10;

        /**
         * Switch Expression Using ->N Label
         * **/
        String val = switch (age) {

            case 20 : {
                yield age % 2 == 1 ? "odd" : "even";
            }
            case 10 : {
                if(age % 2 == 1 ) {
                    yield "odd but age is : " + age;
                }
                else {
                    yield "even but age is : " + age;
                }

            }
            default : yield "age does not match anything";
        };

        System.out.println(val);
    }
}
