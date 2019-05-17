package midtermjavatwo;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class TicketDataStorage {

    private static TicketDataStorage instance = null;

    ArrayList<TotalPayments> totalPayments = new ArrayList();

    private TicketDataStorage(){}

    /**This will read in a new line of a text document and turn them into TotalPayments objects
    * 
    * @param line String
    */
    public void addExistingTotal(String line)
    {
        String[] wordArray = line.split("%");
        totalPayments.add(new TotalPayments(
                wordArray[0],
                Double.parseDouble(wordArray[1]),
                Integer.parseInt(wordArray[2])
        ));
    }

    /**
    * checks to see if the ticket type is found in the arrayList of tickets
    * @param tickets ArrayList<Ticket>
    * @return true or false depending on the loop
    */
    public void addTotals(ArrayList<Ticket> tickets)
    {
        for (Ticket ticket:tickets
             ) {

            boolean ticketTypeFound = false;

            for (TotalPayments total : totalPayments
            ) {
                if (ticket.getPaymentType().getPaymentName().equals(total.getName())) {
                    total.addPayment(ticket.getTotal());
                    ticketTypeFound = true;
                }
            }
            if (!ticketTypeFound) {
                totalPayments.add(new TotalPayments(ticket.getPaymentType().getPaymentName(), ticket.getTotal()));
            }
        }
    }

    /**
    * 
    */
    public void displayAllTotals()
    {
        for (TotalPayments total:totalPayments
             ) {
            total.display();
        }
    }

    /**
    * checks to see if total payments is empty (created to check lost tickets-if there are still tickets
    * this means the customer is being kicked out and must pay the lost ticket fee)
    *
    * @return true or false depending on what is still in totalPayments
    */
    public boolean hasTotal()
    {
        if(totalPayments.isEmpty())
        {
            return false;
        }
        return true;
    }

    /**
    * this writes the total payments to the file
    * @param index int
    * @return line returns what has been written to total payments
    */
    public String writeToFile(int index)
    {
        String line = totalPayments.get(index).toString();
        totalPayments.remove(index);
        return line;
    }

    public ArrayList<TotalPayments> getTotalPaymentsArray(){return totalPayments;}

    /**
    * creates a singleton design pattern for the garage
    *
    * @return a new Garage for the customer to use
    */
    public static TicketDataStorage getInstance()
    {
        if(instance == null)
        {
            instance = new TicketDataStorage();
        }
        return instance;
    }
}
