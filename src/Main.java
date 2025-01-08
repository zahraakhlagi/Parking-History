import java.util.Scanner;

//TIP To <b>Run</b> code,  press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
   public static Scanner userInput= new Scanner(System.in);
    public static void main(String[] args) {
        //can I compare registration stored as string?
        //can I compare date stored as string?
        //test code
        String tempS1="ABC123";
        String tempS2="def456";
        if(tempS1.compareToIgnoreCase(tempS2)>0){
            System.out.println("S1 is greater than S2");
        } else if (tempS1.compareToIgnoreCase(tempS2)<0) {
            System.out.println("S1 is less than S2");

        }else{
            System.out.println("S1 is same as S2");
        }
        String tempD1="02";
        String tempD2="10";
        //1<2<3  integers
        //1<10<2 Alphabaticaly compare character by character
        if(tempD1.compareToIgnoreCase(tempD2)>0){
            System.out.println("d1 is greater than d2");
        } else if (tempD1.compareToIgnoreCase(tempD2)<0) {
            System.out.println("d1 is less than d2");

        }else{
            System.out.println("d1 is same as d2");
        }
//by using test code we underestand we can use string to compare date and reg nummer

        while (true){
            switch (menu()){
                case 1:
                    System.out.println("Car check in");
                    //ask user of reg num och date entry
                    //verify reg num (3-8 char), verify date(yyyy-mm-dd), both are verified for format
                    //check if user wants to charge the car
                    break;
                case 2:
                    System.out.println("Car check out");
                    break;
                case 3:
                    System.out.println("Car status");
                    break;
                case 4:
                    System.out.println("print history by arrival date");
                    break;
                case 5:
                    System.out.println("Print history by registration number");
                    break;
                case -1:
                    System.exit(0);
                default:
                    System.out.println("That is a invalid entry");
            }
        }
    }
    public static int menu(){
        System.out.println("-----------AIRPORT PARKING--------------");
        System.out.println("1. Drive in");
        System.out.println("2. Drive out");
        System.out.println("3. Check parking");
        System.out.println("4. Print parking history (by arrival date)");
        System.out.println("5. Print parking history (by registration number");
        System.out.println("q. End program");
        System.out.println("> Enter your option:");
        return input();
    }
    public static int input(){
        int number=0;

        while(true){
            if (userInput.hasNextInt()){
                number=userInput.nextInt();
                if(number>0){
                    break;
                }
            } else if (userInput.hasNext()) {
                String isString=userInput.next();
                if(isString.endsWith("q")){
                    number=-1;
                    break;
                }
            }
        }
        return number;
    }
}