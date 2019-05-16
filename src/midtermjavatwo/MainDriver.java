/**
 * This is a software application for automating the parking and exiting functions at a commercial parking garage.
 * This allows cars to enter, leave, produce a ticket, use the tickets to keep track of profits,
 * as well as see total profits.
 * This software application uses JUnit tests, Strategy, Factory and Singleton Patterns.
 * 
 * @version 2.0
 * @author Abby Snopek, Sam Tom
 * 
 * 
 */
package midtermjavatwo;

import midtermjavatwo.BestValueParkingGarageFees.*;

import java.io.File;
import java.time.LocalTime;
import java.util.Scanner;


public class MainDriver {

    public static void main(String[] args) {

        Scanner keyboard = new Scanner(System.in);
        Boolean inProgram = true;
        String usersChoice;
        PaymentStructure paymentStructure = BestValuePaymentStructure.getInstance();
        PrintMenu printMenu = BestValuePrintMenu.getInstance();
        Garage garage = Garage.getInstance();
        garage.setPaymentStructure(paymentStructure);
        garage.openGarage();

        do{
            printMenu.getMenuType("WELCOME").print();
            printMenu.getMenuType("MAIN").print();
            usersChoice = keyboard.nextLine();

            switch(usersChoice) {
                //two
                case "1": printMenu.getMenuType("CHECKIN").print();
                String choice2 = keyboard.nextLine();
                    switch(choice2) {

                        case "1":
                        {
                            Ticket c = new Ticket();
                            garage.addTicket(c);
                            c.Display();
                            //Give User Ticket ID Number
                        break;
                        }
                        //one
                        case "2": printMenu.getMenuType("MAIN").print();
                        break;
                    }
                break;
                    //three
                case "2": printMenu.getMenuType("CHECKOUT").print();
                String choice3 = keyboard.nextLine();
                    switch(choice3) {

                        //Check out car
                        //checkoutCar
                        case "1": printMenu.getMenuType("PAYOPTION").print();
                        String choice4 = keyboard.nextLine();
                        Ticket currentTicket = new Ticket();

                        switch(choice4)
                        {
                            case"1":
                            {
                                garage.addLostTicket();
                                currentTicket = new Ticket(new LostFee());
                                break;
                            }
                            case"2":
                            {
                                printMenu.getMenuType("TICKETNUMBER").print();
                                int id = Integer.parseInt(keyboard.nextLine());
                                currentTicket = garage.findTicket(id);
                                currentTicket.setPaymentType(new SpecialEventFee());
                                break;
                            }
                            case"3":
                            {
                                printMenu.getMenuType("TICKETNUMBER").print();
                                int id = Integer.parseInt(keyboard.nextLine());
                                currentTicket = garage.findTicket(id);
                                currentTicket.setPaymentType(new MinMaxFee());

                                break;
                            }
                            default:
                            {
                                break;
                            }
                        }

                            currentTicket.calculateTotal();
                            garage.addClosedTicket(currentTicket);
                            System.out.println("You checked out at "+currentTicket.displayOutTime());
                        System.out.println("Your total was $"+currentTicket.getTotal()+" for "+currentTicket.getPaymentType().getPaymentName()+" parking.");
                        break;

                        default: printMenu.getMenuType("MAIN").print();
                        break;
                    }
                break;
                    //Close Garage Program

                case "3": garage.displayAll();
                break;

                //close garage
                case "4":
                    System.out.println("Are you sure you would like to exit the program? Y/N: ");
                    String exitChoice = keyboard.nextLine();

                    if(exitChoice.toUpperCase().equals("Y")) {
                        System.out.println("Thank you for using " + garage.getGarageName());
                        garage.closeGarage();
                        //System.out.println("Total Revenue for the day: " + garage.getTotalRevenue());
                        inProgram = false;
                    }
                    else {
                        inProgram = true;
                    }
                    break;
                default: printMenu.getMenuType("MAIN").print();
                     break;
            }

        }while (inProgram);
    }
}
//