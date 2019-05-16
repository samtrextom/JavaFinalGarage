package midtermjavatwo.BestValueParkingGarageFees;

import midtermjavatwo.PaymentStructure;
import midtermjavatwo.PaymentType;

public class BestValuePaymentStructure implements PaymentStructure {

    private static BestValuePaymentStructure instance = null;
    private String garageName = "Best Value Parking Garage";

    private BestValuePaymentStructure(){}

    @Override
    public PaymentType getPaymentType(String paymentType) {
        return null;
    }

    @Override
    public String getName() {
        return garageName;
    }

    public static PaymentStructure getInstance()
    {
        if(instance == null)
        {
            instance = new BestValuePaymentStructure();
        }
        return instance;
    }
}
