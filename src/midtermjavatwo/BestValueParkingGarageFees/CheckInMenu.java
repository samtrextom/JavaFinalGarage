package midtermjavatwo.BestValueParkingGarageFees;

import midtermjavatwo.MenuType;

public class CheckInMenu implements MenuType {

    @Override
    public void print() {
        System.out.println("1 - Check in Ticket");
        System.out.println("2 - Return to Main Menu");
    }
}
