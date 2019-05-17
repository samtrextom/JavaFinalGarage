
package midtermjavatwo;


import midtermjavatwo.BestValueParkingGarageFees.LostFee;
import midtermjavatwo.BestValueParkingGarageFees.MinMaxFee;

import java.io.File;
import java.time.Duration;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;


public class Garage {

    private static Garage instance = null;

    //arraylists to hold cars and money they earn
    //<Ticket> declares its going to have cars in it
    private ArrayList<Ticket> openTickets = new ArrayList();
    private ArrayList<Ticket> closedTickets = new ArrayList();


    private TicketDataStorage ticketDataStorage = TicketDataStorage.getInstance();
    private int totalLostTickets = 0;
    private PaymentStructure paymentStructure;

    
    private Garage(){}
    
    /**
     * Constructor Setter for our payment structure
     * @param openTickets ArrayList<Ticket>
     */

    public void addOpenTickets(ArrayList<Ticket> openTickets)
    {
        this.openTickets = openTickets;
    }

    public void setPaymentStructure(PaymentStructure paymentStructure)
    {
        this.paymentStructure = paymentStructure;
    }
    
    /**
     * Returns the name of the payment structure
     *
     * @return paymentStructure name
     */
    public String getGarageName(){return paymentStructure.getName(); }

    /**
    * adding a car/ticket to the ArrayList
    * @param c Ticket
    */
    public void addTicket(Ticket c)
    {
        openTickets.add(c);
    }
    
    /**
    * traverses the arraylist to local the ticket number assigned to the vehicle
    * @param ID int
    * @return new Ticket
    * @return new LostFee
    */
    public Ticket findTicket(int ID)
    {
        for(int i = 0; i < openTickets.size(); i++) {
            if (openTickets.get(i).getID() == ID) {
                Ticket ticket = openTickets.get(i);
                openTickets.remove(i);
                return ticket;
            }
        }
        System.out.println("Ticket not found!\n");
        totalLostTickets ++;
        return new Ticket(new LostFee());
    }
    
    /**
     * displays the openTickets for the parking garage
     *
     */
    public void displayAll()
    {
        for(int i = 0; i < openTickets.size(); i++)
        {
            openTickets.get(i).Display();
            System.out.println();
        }
    }
    
    /**
    * adds one to totalLostTickets count
    *
    */

    public void addLostTicket()
    {
        totalLostTickets++;
    }

    /**
    * adds tickets to closedTickets arraylist
    * @@param ticket Ticket
    */
    public void addClosedTicket(Ticket ticket)
    {
        closedTickets.add(ticket);
    }

    /**
    * creates a file tickets.txt to record the various ticket sales of the parking garage
    *
    */
    public void openGarage()
    {
        File file = new File("tickets.txt");
        if(file.exists())
        {
            GarageFileIn fileIn = new GarageFileIn("tickets.txt");
            String line;

            while ((line = fileIn.fileReadLine()) != null) {

                if (line.isEmpty()) {
                    continue;
                }
                ticketDataStorage.addExistingTotal(line);
            }

            fileIn.fileClose();
        }
    }

    /**
    * checks to see if there is any open tickets, then calculates total of the sales of the parking garage
    *
    * @return the total of sales from the tickets
    * @return adds totals of sales to the arrayList ticketDataStorage
    */
    public void closeGarage()
    {


        if(!openTickets.isEmpty()) {
            int remainingTickets = openTickets.size() - totalLostTickets;

            for(int i = 0; i < remainingTickets; i++)
            {
                Ticket ticket = new Ticket(new LostFee());
                ticket.calculateTotal();
                closedTickets.add(ticket);
            }
        }
        if(!closedTickets.isEmpty()) {
            ticketDataStorage.addTotals(closedTickets);
        }
            GarageFileOut fileOut = new GarageFileOut("tickets.txt");
            ticketDataStorage.displayAllTotals();

            while (ticketDataStorage.hasTotal()) {
                String line = ticketDataStorage.writeToFile(0);
                fileOut.fileWrite(line);
            }
            fileOut.fileClose();

    }

    /**
    * creates a singleton design pattern for the garage
    *
    * @return a new Garage for the customer to use
    */
    public static Garage getInstance()
    {
        if(instance == null)
        {
            instance = new Garage();
        }
        return instance;
    }

}
