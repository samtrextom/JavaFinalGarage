package midtermjavatwo;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Random;


public class Ticket {
    
    private LocalTime enterTime = LocalTime.of(0,0);
    private LocalTime outTime;
    private int ID;
    private double total;
    private PaymentType paymentType;

    /**
    * constructing ticket to get the data of date and time
    * whenever we make a new car, it sets it to the whatever the current time it
    * @param randHour this sets the random time for when the car comes into the garage
    * @param enterTime is the assigned the random time
    * @param ID is assigned the value of zero
    */

    public Ticket()
    {
        Random rand = new Random();
        int randHour = rand.nextInt(6)+7;
        //System.out.println(randTime);
        this.enterTime = LocalTime.of(randHour, 0);
        this.ID = 0;
    }
    
    /**
     * sets the Ticket
     * @param ID sets the ID to int i
     * @param enterTime sets to the localTime of t
     */
    public Ticket(int i, LocalTime t)
    {
        this.ID = i;
        this.enterTime = t;
    }
    
    /**
    * constructs the Ticket
    * @param paymentType sets up the variable created for the Parking Garage
    */
    public Ticket(PaymentType paymentType)
    {
        this.paymentType = paymentType;
    }
    
    /**
    * Getter returning the variable time
    * @return enterTime when the method is called, it will return the entered time set above by the Random Math and Local Time
    */
    public LocalTime getTime()
    {
       return enterTime;
    }
    
    /**
    * Returns whatever is in the int ID, getters you have to declare the type which is being returned 
    * @return ID
    */
    public int getID()
    {
        return ID;
    }
    
    /**
    * changes the ID to the int we're taking in
    * @param ID an int we are using for the ID of the ticket for the customers
    */
    public void setID(int i)
    {
        ID = i;
    }
    
    /**
    * display method for the customers to see what time they checked in and what their car number is
    * uses other methods to complete
    */
    public void Display()
    {
        System.out.println("You checked in at " + getTime().getHour() + ":00");
        System.out.println("Your car ticket number is: " + getID());
    }

    /**
    * calculates total duration a car was parked in the parking garage
    * @param randHour the random time created for checkout
    * @param outTime the time the car is trying to leave
    * @param hour the duration between enterTime and outTime
    * @param enterTime time of entry to the Parking Garage
    * @param outTime time of leaving the Parking Garage
    * @param total total payment
    * @param paymentType variable created for payment system
    */
    public void calculateTotal() {

        Random rand = new Random();
        int randHour = rand.nextInt(11)+13;
        outTime = LocalTime.of(randHour,0);

        int hour = (int)Duration.between(enterTime,outTime).toHours();

        total = paymentType.getPaymentTotal(hour);
    }

    /**
    * display the time out for the customer
    * @return outTime the time the customer is leaving the parking garage
    */
    public String displayOutTime()
    {
        return outTime.toString();
    }

    /**
    * method to call to get the Total the customer needs to pay
    * @return total total amount needed to pay for time in the parking garage
    */
    public double getTotal(){return total;}

    /**
    * method to call to get the paymentType
    * @return paymentType
    */
    public PaymentType getPaymentType() {
        return paymentType;
    }

    /**
    * declare paymentType
    * @param paymentType declared variable
    */
    public void setPaymentType(PaymentType paymentType) {
        this.paymentType = paymentType;
    }
}
