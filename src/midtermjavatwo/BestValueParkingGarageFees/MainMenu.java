package midtermjavatwo.BestValueParkingGarageFees;

import midtermjavatwo.MenuType;

public class MainMenu implements MenuType {

    @Override
    public void print() {
        System.out.println("1 - Checking into the garage");
        System.out.println("2 - Checking out of the garage");
        System.out.println("3 - Check cars in the garage");
        System.out.println("4 - Close Garage");
    }
}
