package midtermjavatwo.BestValueParkingGarageFees;

import midtermjavatwo.PaymentType;

public class SpecialEventFee implements PaymentType {

    private double staticFee;
    private double dynamicFee;
    private String name;

    public SpecialEventFee(){
        staticFee = 20.00;
        dynamicFee = 0.00;
        name = "Special Event Fee";
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
