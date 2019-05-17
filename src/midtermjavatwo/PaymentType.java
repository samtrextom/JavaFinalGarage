package midtermjavatwo;

/**
 * interface for the different payment types that can apply to tickets
 *
 */
public interface PaymentType {

    /**
     * Takes in the amount of time that the car was in the garage
     * and returns the total cost of the ticket
     * @param time
     * @return total
     */
    double getPaymentTotal(int time);

    /**
     * returns the name of the payment type
     * @return name
     */
    String getPaymentName();
}
