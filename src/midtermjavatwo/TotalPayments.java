package midtermjavatwo;

public class TotalPayments {

    private double total;
    private int count;
    private String name;

    public TotalPayments(String name, double total)
    {
        this.name = name;
        this.total = total;
        this.count = 1;
    }

    public TotalPayments(String name, double total, int count)
    {
        this.name = name;
        this.total = total;
        this.count = 1;
    }

    public void addPayment(double payment)
    {
        total += payment;
        count++;
    }

    public String getName(){return name;}

    public void display()
    {
        System.out.println(""+count+" "+name+": $"+total);
    }

    public String toString()
    {
        return name+"%"+total+"%"+count;
    }
}
