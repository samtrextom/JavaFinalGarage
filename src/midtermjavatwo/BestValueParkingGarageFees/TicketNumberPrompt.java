package midtermjavatwo.BestValueParkingGarageFees;

import midtermjavatwo.MenuType;

public class TicketNumberPrompt implements MenuType {

    @Override
    public void print() {
        System.out.println();
        System.out.println("What was your Ticket's ticket number? ");
    }
}
