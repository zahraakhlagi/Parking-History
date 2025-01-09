import java.util.Scanner;

//TIP To <b>Run</b> code,  press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
   public static Scanner userInput= new Scanner(System.in);

   public static final int MAX_CARS=10;
    public static void main(String[] args) {
        //can I compare registration stored as string?
        //can I compare date stored as string?
        //test code
       /* String tempS1="ABC123";
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
//by using test code we underestand we can use string to compare date and reg nummer*/

        /*
        Index 0 is registration number
        Index 1 is arrival date
        Index 2 is departures date
        Index 3 is Yes No for car changing used
        Index 4 is parking fee
         */
        String[][] parkingLot = new String[MAX_CARS][5];
        int numOfCars=0;


        loadTestData(parkingLot);
        numOfCars=4;
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
                    //validate arrival date=departure date
                    break;
                case 3:
                    System.out.println("Car status");
                    break;
                case 4:
                    System.out.println("print history by arrival date");
                   // printParkingLotSummary(parkingLot);
                    printHistoryByArrivalDate(parkingLot,numOfCars);
                    break;
                case 5:
                    System.out.println("Print history by registration number");
                    printHistoryByArrivalRegistration(parkingLot,numOfCars);
                    break;
                case -1:
                    System.exit(0);
                default:
                    System.out.println("That is a invalid entry");
            }
        }
    }

    public static void loadTestData(String[][] parkingLot){
        //Entry1
        parkingLot[0][0]= "ABC123";
        parkingLot[0][1]="2023-01-01";
        parkingLot[0][2]="2023-01-02";
        parkingLot[0][3]="Yes";
        parkingLot[0][4]="370";

        //Entry2
        parkingLot[1][0]= "AC123";
        parkingLot[1][1]="2019-01-01";
        parkingLot[1][2]="2023-01-02";
        parkingLot[1][3]="No";
        parkingLot[1][4]="120";

        //Entry3
        parkingLot[2][0]= "ABC123";
        parkingLot[2][1]="2021-01-01";
        parkingLot[2][2]="";
        parkingLot[2][3]="No";
        parkingLot[2][4]="0";

        //Entry4
        parkingLot[3][0]= "BCD456";
        parkingLot[3][1]="2022-01-01";
        parkingLot[3][2]="";
        parkingLot[3][3]="Yes";
        parkingLot[3][4]="0";


    }

    public static void printHistoryByArrivalDate(String[][] parkingLot,int numOfCars){
        //copy of the original array
        String[][] tempParkingLot= new String[MAX_CARS][5];
        System.arraycopy(parkingLot,0,tempParkingLot,0,numOfCars);
        //bubble sort
        for (int i=0; i<numOfCars;i++){
            for (int j=0; j< numOfCars-1;j++){
                if(tempParkingLot[j][1].compareToIgnoreCase(tempParkingLot[j+1][1])>0){
                    String[] temp= tempParkingLot[j];
                    tempParkingLot[j]=tempParkingLot[j+1];
                    tempParkingLot[j+1]=temp;
                }
            }
        }
        printParkingLotSummary(parkingLot,numOfCars);
    }

    public static void printHistoryByArrivalRegistration(String[][] parkingLot,int numOfCars){
        //copy of the original array
        String[][] tempParkingLot= new String[MAX_CARS][5];
        System.arraycopy(parkingLot,0,tempParkingLot,0,numOfCars);
        //bubble sort
        for (int i=0; i<numOfCars;i++){
            for (int j=0; j< numOfCars-1;j++){
                if(tempParkingLot[j][0].compareToIgnoreCase(tempParkingLot[j+1][0])>0){
                    String[] temp= tempParkingLot[j];
                    tempParkingLot[j]=tempParkingLot[j+1];
                    tempParkingLot[j+1]=temp;
                }
            }
        }
        printParkingLotSummary(parkingLot,numOfCars);
    }
    public static void printParkingLotSummary(String[][] parkingLot,int numOfCars){
        System.out.printf("%-10s %-15s %-15s %-15s %-15s%n ","Registration","Entered","Exited","Charging used","Parking cost");
        for(int i=0; i<numOfCars;i++){
            System.out.printf("%-10s %-15s %-15s %-15s %-15s%n ",
                    parkingLot[i][0],
                    parkingLot[i][1],
                    parkingLot[i][2],
                    parkingLot[i][3],
                    parkingLot[i][4]
                    );
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