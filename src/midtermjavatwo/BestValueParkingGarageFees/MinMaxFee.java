package midtermjavatwo.BestValueParkingGarageFees;

import midtermjavatwo.PaymentType;

public class MinMaxFee implements PaymentType {

    private double staticFee;
    private double dynamicFee;
    private String name;

    public MinMaxFee(){
        staticFee = 5.00;
        dynamicFee = 1.00;
        name = "Min/Max Fee";
    }

    @Override
    public double getPaymentTotal(int time) {
        if(((time*dynamicFee)+staticFee)>15.00)
        {
            return 15.00;
        }
        else
        {
            return (time*dynamicFee)+staticFee;
        }
    }

    @Override
    public String getPaymentName() {
        return name;
    }
}
