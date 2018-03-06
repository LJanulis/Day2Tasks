package lt.swedbank.itacademy.tasks.domain;

/**
 * @author Lukas
 */
public class CarLoan extends VehicleLoan {

    private float enginePower;

    public float getEnginePower() {
        return enginePower;
    }

    public void setEnginePower(float enginePower) {
        this.enginePower = enginePower;
    }
}
