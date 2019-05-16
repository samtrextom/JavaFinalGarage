package midtermjavatwo.BestValueParkingGarageFees;

import midtermjavatwo.MenuType;

public class CheckOutMenu implements MenuType {

    @Override
    public void print() {
        System.out.println("1 - Check out Ticket");
        System.out.println("2 - Return to Main Menu");
    }
}
