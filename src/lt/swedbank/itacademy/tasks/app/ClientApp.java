package lt.swedbank.itacademy.tasks.app;

import lt.swedbank.itacademy.tasks.domain.Loan;
import lt.swedbank.itacademy.tasks.service.LoanService;

import java.util.Arrays;

public class ClientApp {

    public static void main(String[] args) {

        //TASK 1

        /*Loan[] loans = getInitializer().initializeLoans();
        LoanService service = new LoanService(loans);

        service.setHighRiskLoans(service.findHighRiskLoans());
        System.out.println(Arrays.toString(service.getHighRiskLoans()));

        service.setAverageLoanCost(service.calculateAverageLoanCost());
        System.out.println(service.getAverageLoanCost());

        System.out.println(service.calculateAverageLoanCost(LoanRiskType.NORMAL_RISK));
        System.out.println(service.calculateAverageLoanCost(LoanRiskType.HIGH_RISK));
        System.out.println(service.calculateAverageLoanCost(LoanRiskType.LOW_RISK));
        service.setAverageCostOfHighRiskLoans(service.calculateAverageCostOfHighRiskLoans());
        System.out.println(service.getAverageCostOfHighRiskLoans());

        service.setMaximumPriceOfNonExpiredLoans(service.findMaximumPriceOfNonExpiredLoans());
        System.out.println(service.findMaximumPriceOfNonExpiredLoans()); */

        //TASK 2

        /*Loan[] loans = new Task2DomainInitializer().initializeLoans();
        LoanService service = new LoanService(loans);

        service.setHighRiskLoans(service.findHighRiskLoans());
        System.out.println(Arrays.toString(service.getHighRiskLoans()));

        service.setMaximumAgeOfLowRiskLoanedVehicles(service.findMaximumAgeOfLowRiskLoanedVehicles());
        System.out.println(service.getMaximumAgeOfLowRiskLoanedVehicles());

        service.setPersonalRealEstateLoans(service.findPersonalRealEstateLoans());
        System.out.println(Arrays.toString(service.getPersonalRealEstateLoans()));

        service.setExpiredHighRiskVehicleLoansOfHighestDuration(service.findExpiredHighRiskVehicleLoansOfHighestDuration());
        System.out.println(Arrays.toString(service.getExpiredHighRiskVehicleLoansOfHighestDuration()) + " duration: " +
                           service.getExpiredHighRiskVehicleLoansOfHighestDuration()[0].getTermInYears()); */

        //TASK 3
        Loan[] loans = new Task3DomainInitializer().initializeLoans();
        LoanService service = new LoanService(loans);

        service.setLowRiskHarvesterLoans(service.findLowRiskHarvesterLoans());
        System.out.println(Arrays.toString(service.getLowRiskHarvesterLoans()));

        service.setExpiredLandLoansInReservation(service.findExpiredLandLoansInReservation());
        System.out.println(Arrays.toString(service.getExpiredLandLoansInReservation()));

        service.setLoansOfHigherThanAverageDepreciation(service.findLoansOfHigherThanAverageDepreciation());
        System.out.println(Arrays.toString(service.getLoansOfHigherThanAverageDepreciation()));

    }


    public static DomainInitializer getInitializer() {
        return new Task1DomainInitializer();
    }

}
