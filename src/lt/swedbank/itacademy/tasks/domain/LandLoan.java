package lt.swedbank.itacademy.tasks.domain;

/**
 * @author Lukas
 */
public class LandLoan extends RealEstateLoan {

    private boolean inReservation;

    public boolean isInReservation() {
        return inReservation;
    }

    public void setInReservation(boolean inReservation) {
        this.inReservation = inReservation;
    }
}
