package lt.swedbank.itacademy.tasks.domain;

import java.math.BigDecimal;
import java.util.Date;

public class VehicleLoan extends Loan {

    private Date manufactured;
    private String model;

    private int age;
    private int maximumAge;

    public Date getManufactured() {
        return manufactured;
    }

    public void setManufactured(Date manufactured) {
        this.manufactured = manufactured;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getMaximumAge() {
        return maximumAge;
    }

    public void setMaximumAge(int maximumAge) {
        this.maximumAge = maximumAge;
    }

    @Override
    public BigDecimal calculateInterestRate() {
        return super.calculateInterestRate().multiply(new BigDecimal(this.getRiskType().getLoanCoefficient()));

        /*switch (getRiskType()) {
            case LOW_RISK:
                System.out.println(super.calculateInterestRate().multiply(new BigDecimal(0.8)));
                return super.calculateInterestRate().multiply(new BigDecimal(0.8));
            case NORMAL_RISK:
                return super.calculateInterestRate();
            case HIGH_RISK:
                System.out.println(super.calculateInterestRate().multiply(new BigDecimal(1.5)));
                return super.calculateInterestRate().multiply(new BigDecimal(1.5));
            default:
                return super.calculateInterestRate();
        } */
    }

    @Override
    public String toString() {
        return "VehicleLoan{" +
                "manufactured=" + manufactured +
                ", model='" + model + '\'' +
                ", age=" + age +
                ", maximumAge=" + maximumAge +
                '}';
    }
}
