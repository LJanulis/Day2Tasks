package lt.swedbank.itacademy.tasks.app;

import lt.swedbank.itacademy.tasks.domain.Loan;

public interface DomainInitializer {

    Loan[] initializeLoans();

}
