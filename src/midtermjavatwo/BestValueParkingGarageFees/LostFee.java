package midtermjavatwo.BestValueParkingGarageFees;

import midtermjavatwo.PaymentType;

public class LostFee implements PaymentType {

    private double staticFee;
    private double dynamicFee;
    private String name;

    public LostFee(){
        staticFee = 25.00;
        dynamicFee = 0.00;
        name = "Lost Fee";
    }

    @Override
    public double getPaymentTotal(int time) {
        return (time * dynamicFee) + staticFee;
    }

    @Override
    public String getPaymentName() {
        return name;
    }
}
