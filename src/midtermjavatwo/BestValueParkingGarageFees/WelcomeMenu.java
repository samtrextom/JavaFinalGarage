package midtermjavatwo.BestValueParkingGarageFees;

import midtermjavatwo.MenuType;

public class WelcomeMenu implements MenuType {

    @Override
    public void print() {
        System.out.println();
        System.out.println("Best Value Parking Garage");
        System.out.println("========================");
        System.out.println();
        System.out.println("Choose your option below: ");
    }
}
