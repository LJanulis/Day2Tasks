package lt.swedbank.itacademy.tasks.service;

import lt.swedbank.itacademy.tasks.domain.Loan;
import lt.swedbank.itacademy.tasks.domain.LoanRiskType;

import java.math.BigDecimal;

/**
 * @author Lukas
 */
public interface LoanServiceInterface {
    Loan[] getLoans();

    void setLoans(Loan[] loans);

    void setHighRiskLoans(Loan[] highRiskLoans);

    Loan[] getHighRiskLoans();

    void setAverageLoanCost(BigDecimal averageLoanCost);

    BigDecimal getAverageLoanCost();

    void setMaximumPriceOfNonExpiredLoans(BigDecimal maximumPriceOfNonExpiredLoans);

    BigDecimal getMaximumPriceOfNonExpiredLoans();

    BigDecimal getAverageCostOfHighRiskLoans();

    void setAverageCostOfHighRiskLoans(BigDecimal averageCostOfHighRiskLoans);

    Loan[] getNormalRiskVehicleLoans();

    void setNormalRiskVehicleLoans(Loan[] normalRiskVehicleLoans);

    int getMaximumAgeOfLowRiskLoanedVehicles();

    void setMaximumAgeOfLowRiskLoanedVehicles(int maximumAgeOfLowRiskLoanedVehicles);

    Loan[] getPersonalRealEstateLoans();

    void setPersonalRealEstateLoans(Loan[] personalRealEstateLoans);

    Loan[] getExpiredHighRiskVehicleLoansOfHighestDuration();

    void setExpiredHighRiskVehicleLoansOfHighestDuration(Loan[] expiredHighRiskVehicleLoansOfHighestDuration);

    Loan[] getLowRiskHarvesterLoans();

    void setLowRiskHarvesterLoans(Loan[] lowRiskHarvesterLoans);

    Loan[] getExpiredLandLoansInReservation();

    void setExpiredLandLoansInReservation(Loan[] expiredLandLoansInReservation);

    Loan[] getLoansOfHigherThanAverageDepreciation();

    void setLoansOfHigherThanAverageDepreciation(Loan[] loansOfHigherThanAverageDepreciation);

    Loan[] findHighRiskLoans();

    BigDecimal calculateAverageLoanCost();

    BigDecimal calculateAverageLoanCost(LoanRiskType loanRiskType);

    BigDecimal calculateAverageCostOfHighRiskLoans();

    BigDecimal findMaximumPriceOfNonExpiredLoans();

    Loan[] findNormalRiskVehicleLoans();

    int findMaximumAgeOfLowRiskLoanedVehicles();

    Loan[] findPersonalRealEstateLoans();

    Loan[] findExpiredHighRiskVehicleLoansOfHighestDuration();

    Loan[] findLowRiskHarvesterLoans();

    Loan[] findExpiredLandLoansInReservation();

    Loan[] findLoansOfHigherThanAverageDepreciation();
}
