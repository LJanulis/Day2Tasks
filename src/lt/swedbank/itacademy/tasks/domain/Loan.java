package lt.swedbank.itacademy.tasks.domain;

import lt.swedbank.itacademy.tasks.util.DateUtil;

import java.math.BigDecimal;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Loan {

    private BigDecimal interestRate;
    private BigDecimal calculatedInterest;
    private BigDecimal price;

    private LoanRiskType riskType;

    private BigDecimal totalLoanCost;
    private Date creationDate;
    private int termInYears;
    private String name;

    private boolean valid;

    public BigDecimal getInterestRate() {
        return interestRate;
    }

    public void setInterestRate(BigDecimal interestRate) {
        this.interestRate = interestRate;
    }

    public BigDecimal getCalculatedInterest() {
        return calculatedInterest;
    }

    public void setCalculatedInterest(BigDecimal calculatedInterest) {
        this.calculatedInterest = calculatedInterest;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public LoanRiskType getRiskType() {
        return riskType;
    }

    public void setRiskType(LoanRiskType riskType) {
        this.riskType = riskType;
    }

    public BigDecimal getTotalLoanCost() {
        return totalLoanCost;
    }

    public void setTotalLoanCost(BigDecimal totalLoanCost) {
        this.totalLoanCost = totalLoanCost;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    public int getTermInYears() {
        return termInYears;
    }

    public void setTermInYears(int termInYears) {
        this.termInYears = termInYears;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public BigDecimal calculateInterestRate() {
        return interestRate.multiply(price).divide(new BigDecimal(100));
    }

    public BigDecimal calculateTotalLoanCost() {
        return price.add(calculateInterestRate());
    }

    public void validateDate() {
        Date dateAfter = DateUtil.addYears(creationDate, termInYears);

        DateFormat df = new SimpleDateFormat("yyyy-MM-dd");

        Date todayDate = DateUtil.getDateFromString(df.format(new Date()));
        valid = DateUtil.differenceInDays(dateAfter, todayDate) >= 0;
    }

    public boolean isValid() {
        return valid;
    }

    @Override
    public String toString() {
        return "Loan{" +
                "interestRate=" + interestRate +
                ", calculatedInterest=" + calculatedInterest +
                ", price=" + price +
                ", riskType=" + riskType +
                ", totalLoanCost=" + totalLoanCost +
                ", creationDate=" + creationDate +
                ", termInYears=" + termInYears +
                ", name='" + name + '\'' +
                ", valid=" + valid +
                '}';
    }
}
