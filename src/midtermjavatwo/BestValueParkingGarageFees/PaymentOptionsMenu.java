package midtermjavatwo.BestValueParkingGarageFees;

import midtermjavatwo.MenuType;

public class PaymentOptionsMenu implements MenuType {

    @Override
    public void print() {
        System.out.println();
        System.out.println("Best Value Parking Garage");
        System.out.println("========================");
        System.out.println("Select a payment option below:");
        System.out.println("1) Lost Ticket");
        System.out.println("2) Special Event Parking");
        System.out.println("3) Normal Parking");
    }
}