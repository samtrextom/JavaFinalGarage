package midtermjavatwo;

/**
 * This is the class that will contain the totals of each type of payment and the total amount
 * also it will contain the total amount of tickets that pay for with this type
 */

public class TotalPayments {

    private double total;
    private int count;
    private String name;

    /**
     * Constructor
     * sets count to 1
     * @param name
     * @param total
     */
    public TotalPayments(String name, double total)
    {
        this.name = name;
        this.total = total;
        this.count = 1;
    }

    /**
     * Constructor
     *
     * @param name
     * @param total
     * @param count
     */
    public TotalPayments(String name, double total, int count)
    {
        this.name = name;
        this.total = total;
        this.count = count;
    }

    /**This method adds a payment to the total amount and incriments the count
     *
     * @param payment
     */
    public void addPayment(double payment)
    {
        total += payment;
        count++;
    }

    /**
     *
     * @return total
     */
    public double getTotal(){return total;}

    /**
     *
     * @return count
     */
    public int getCount(){return count;}

    /**
     *
     * @return name
     */
    public String getName(){return name;}

    /**
     * displays the count, name and total of the payment type
     */
    public void display()
    {
        System.out.println(""+count+" "+name+": $"+total);
    }

    /**
     *
     * @return turns the payment type into a string used for writing to the text file
     */
    public String toString()
    {
        return name+"%"+total+"%"+count;
    }
}
