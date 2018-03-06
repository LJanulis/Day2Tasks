package lt.swedbank.itacademy.tasks.domain;

public enum LoanRiskType {
    HIGH_RISK(1.5),
    NORMAL_RISK(1),
    LOW_RISK(0.8);

    private final double coefficient;

    LoanRiskType(double coefficient) {
        this.coefficient = coefficient;
    }

    public double getLoanCoefficient() {
        return coefficient;
    }
}
