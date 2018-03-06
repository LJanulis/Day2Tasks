package lt.swedbank.itacademy.tasks.service;

import lt.swedbank.itacademy.tasks.domain.*;
import lt.swedbank.itacademy.tasks.util.LoanUtil;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;

public class LoanService implements LoanServiceInterface {

    private Loan[] loans;

    private Loan[] highRiskLoans;
    private BigDecimal averageLoanCost;
    private BigDecimal maximumPriceOfNonExpiredLoans;
    private BigDecimal averageCostOfHighRiskLoans;

    private Loan[] normalRiskVehicleLoans;
    private int maximumAgeOfLowRiskLoanedVehicles;
    private Loan[] personalRealEstateLoans;
    private Loan[] expiredHighRiskVehicleLoansOfHighestDuration;

    private Loan[] lowRiskHarvesterLoans;
    private Loan[] expiredLandLoansInReservation;
    private Loan[] loansOfHigherThanAverageDepreciation;

    public LoanService(Loan[] loans) {
        this.loans = loans;
    }

    @Override
    public Loan[] getLoans() {
        return loans;
    }

    @Override
    public void setLoans(Loan[] loans) {
        this.loans = loans;
    }

    @Override
    public void setHighRiskLoans(Loan[] highRiskLoans) {
        this.highRiskLoans = highRiskLoans;
    }

    @Override
    public Loan[] getHighRiskLoans() {
        return this.highRiskLoans;
    }

    @Override
    public void setAverageLoanCost(BigDecimal averageLoanCost) {
        this.averageLoanCost = averageLoanCost;
    }

    @Override
    public BigDecimal getAverageLoanCost() {
        return this.averageLoanCost;
    }

    @Override
    public void setMaximumPriceOfNonExpiredLoans(BigDecimal maximumPriceOfNonExpiredLoans) {
        this.maximumPriceOfNonExpiredLoans = maximumPriceOfNonExpiredLoans;
    }

    @Override
    public BigDecimal getMaximumPriceOfNonExpiredLoans() {
        return maximumPriceOfNonExpiredLoans;
    }

    @Override
    public BigDecimal getAverageCostOfHighRiskLoans() {
        return averageCostOfHighRiskLoans;
    }

    @Override
    public void setAverageCostOfHighRiskLoans(BigDecimal averageCostOfHighRiskLoans) {
        this.averageCostOfHighRiskLoans = averageCostOfHighRiskLoans;
    }

    @Override
    public Loan[] getNormalRiskVehicleLoans() {
        return normalRiskVehicleLoans;
    }

    @Override
    public void setNormalRiskVehicleLoans(Loan[] normalRiskVehicleLoans) {
        this.normalRiskVehicleLoans = normalRiskVehicleLoans;
    }

    @Override
    public int getMaximumAgeOfLowRiskLoanedVehicles() {
        return maximumAgeOfLowRiskLoanedVehicles;
    }

    @Override
    public void setMaximumAgeOfLowRiskLoanedVehicles(int maximumAgeOfLowRiskLoanedVehicles) {
        this.maximumAgeOfLowRiskLoanedVehicles = maximumAgeOfLowRiskLoanedVehicles;
    }

    @Override
    public Loan[] getPersonalRealEstateLoans() {
        return personalRealEstateLoans;
    }

    @Override
    public void setPersonalRealEstateLoans(Loan[] personalRealEstateLoans) {
        this.personalRealEstateLoans = personalRealEstateLoans;
    }

    @Override
    public Loan[] getExpiredHighRiskVehicleLoansOfHighestDuration() {
        return expiredHighRiskVehicleLoansOfHighestDuration;
    }

    @Override
    public void setExpiredHighRiskVehicleLoansOfHighestDuration(Loan[] expiredHighRiskVehicleLoansOfHighestDuration) {
        this.expiredHighRiskVehicleLoansOfHighestDuration = expiredHighRiskVehicleLoansOfHighestDuration;
    }

    @Override
    public Loan[] getLowRiskHarvesterLoans() {
        return lowRiskHarvesterLoans;
    }

    @Override
    public void setLowRiskHarvesterLoans(Loan[] lowRiskHarvesterLoans) {
        this.lowRiskHarvesterLoans = lowRiskHarvesterLoans;
    }

    @Override
    public Loan[] getExpiredLandLoansInReservation() {
        return expiredLandLoansInReservation;
    }

    @Override
    public void setExpiredLandLoansInReservation(Loan[] expiredLandLoansInReservation) {
        this.expiredLandLoansInReservation = expiredLandLoansInReservation;
    }

    @Override
    public Loan[] getLoansOfHigherThanAverageDepreciation() {
        return loansOfHigherThanAverageDepreciation;
    }

    @Override
    public void setLoansOfHigherThanAverageDepreciation(Loan[] loansOfHigherThanAverageDepreciation) {
        this.loansOfHigherThanAverageDepreciation = loansOfHigherThanAverageDepreciation;
    }

    @Override
    public Loan[] findHighRiskLoans() {
        List<Loan> highRiskLoans = new ArrayList<>();
        for (Loan loan : loans) {
            if (loan.getRiskType().equals(LoanRiskType.HIGH_RISK)) {
                highRiskLoans.add(loan);
            }
        }
        return highRiskLoans.toArray(new Loan[highRiskLoans.size()]);
    }

    @Override
    public BigDecimal calculateAverageLoanCost() {
        BigDecimal loanSum = BigDecimal.ZERO;
        for (Loan loan : loans) {
            loanSum = loanSum.add(loan.calculateTotalLoanCost());
        }
        return loanSum.divide(new BigDecimal(loans.length));
    }

    @Override
    public BigDecimal calculateAverageLoanCost(LoanRiskType loanRiskType) {
        BigDecimal loanSum = BigDecimal.ZERO;
        int loanRiskTypeCount = 0;
        for (Loan loan : loans) {
            if (loan.getRiskType().equals(loanRiskType)) {
                loanSum = loanSum.add(loan.calculateTotalLoanCost());
                loanRiskTypeCount++;
            }
        }
        return loanSum.divide(new BigDecimal(loanRiskTypeCount), BigDecimal.ROUND_HALF_EVEN);
    }

    @Override
    public BigDecimal calculateAverageCostOfHighRiskLoans() {
        return calculateAverageLoanCost(LoanRiskType.HIGH_RISK);
    }

    @Override
    public BigDecimal findMaximumPriceOfNonExpiredLoans() {
        BigDecimal maximumValidPrice = BigDecimal.ZERO;
        for (Loan loan : loans) {
            loan.validateDate();
            if (loan.isValid() && loan.getPrice().compareTo(maximumValidPrice) > 0) {
                maximumValidPrice = loan.getPrice();
            }
        }
        return maximumValidPrice;
    }

    @Override
    public Loan[] findNormalRiskVehicleLoans() {
        List<Loan> normalRiskVehicleLoans = new ArrayList<>();
        for (Loan loan : loans) {
            if ((loan instanceof VehicleLoan) && (loan.getRiskType().equals(LoanRiskType.NORMAL_RISK))) {
                normalRiskVehicleLoans.add(loan);
            }
        }
        return normalRiskVehicleLoans.toArray(new Loan[normalRiskVehicleLoans.size()]);
    }

    @Override
    public int findMaximumAgeOfLowRiskLoanedVehicles() {
        int maximumAgeTemp = -1;
        for (Loan loan : loans) {
            if ((loan instanceof VehicleLoan) && (loan.getRiskType().equals(LoanRiskType.LOW_RISK)) &&
                    ((VehicleLoan) loan).getAge() > maximumAgeTemp) {
                maximumAgeTemp = ((VehicleLoan) loan).getMaximumAge();
            }
        }
        return maximumAgeTemp;
    }

    @Override
    public Loan[] findPersonalRealEstateLoans() {
        List<Loan> personalRealEstateLoans = new ArrayList<>();
        for (Loan loan : loans) {
            if ((loan instanceof RealEstateLoan) && (((RealEstateLoan) loan).getPurpose().equals(RealEstatePurpose.PERSONAL))) {
                personalRealEstateLoans.add(loan);
            }
        }
        return personalRealEstateLoans.toArray(new Loan[personalRealEstateLoans.size()]);
    }

    @Override
    public Loan[] findExpiredHighRiskVehicleLoansOfHighestDuration() {
        int highestDuration = -1;
        for (Loan loan : loans) {
            loan.validateDate();
            if ((loan instanceof VehicleLoan) && !loan.isValid() && (loan.getTermInYears() > highestDuration)) {
                highestDuration = loan.getTermInYears();
            }
        }

        List<Loan> expiredHighRiskVehicleLoansOfHighestDuration = new ArrayList<>();
        for (Loan loan : loans) {
            loan.validateDate();
            if ((loan instanceof VehicleLoan) && !loan.isValid() && (loan.getTermInYears() == highestDuration)) {
                expiredHighRiskVehicleLoansOfHighestDuration.add(loan);
            }
        }
        return expiredHighRiskVehicleLoansOfHighestDuration.toArray(new Loan[expiredHighRiskVehicleLoansOfHighestDuration.size()]);
    }

    @Override
    public Loan[] findLowRiskHarvesterLoans() {
        List<Loan> lowRiskHarvesterLoans = new ArrayList<>();
        for (Loan loan : loans) {
            if ((loan instanceof HarvesterLoan) && loan.getRiskType().equals(LoanRiskType.LOW_RISK)) {
                lowRiskHarvesterLoans.add(loan);
            }
        }
        return lowRiskHarvesterLoans.toArray(new Loan[lowRiskHarvesterLoans.size()]);
    }

    @Override
    public Loan[] findExpiredLandLoansInReservation() {
        List<Loan> expiredLandLoansInReservation = new ArrayList<>();

        for (Loan loan : loans) {
            loan.validateDate();
            if ((loan instanceof LandLoan) && !loan.isValid() && ((LandLoan) loan).isInReservation()) {
                expiredLandLoansInReservation.add(loan);
            }
        }
        return expiredLandLoansInReservation.toArray(new Loan[expiredLandLoansInReservation.size()]);
    }

    @Override
    public Loan[] findLoansOfHigherThanAverageDepreciation() {
        List<Loan> loansOfHigherThanAverageDepreciation = new ArrayList<>();
        BigDecimal averageDepreciation = calculateAverageDepreciation();
        for (Loan loan : loans) {
            if ((loan instanceof VehicleLoan) &&
                    (LoanUtil.calculateVehicleDepreciation((VehicleLoan) loan).compareTo(averageDepreciation)) > 0) {
                loansOfHigherThanAverageDepreciation.add(loan);
            }
        }
        return loansOfHigherThanAverageDepreciation.toArray(new Loan[loansOfHigherThanAverageDepreciation.size()]);
    }

    private BigDecimal calculateAverageDepreciation() {
        BigDecimal averageDepreciation = BigDecimal.ZERO;
        for (Loan loan : loans) {
            if (loan instanceof VehicleLoan) {
                averageDepreciation = averageDepreciation.add(LoanUtil.calculateVehicleDepreciation((VehicleLoan) loan));
            }
        }
        return averageDepreciation.divide(new BigDecimal(loans.length), 4, RoundingMode.HALF_UP);
    }
}
