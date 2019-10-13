import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;

public class RiskyLending {

    public static void main(String[] args) {/*
        List<Integer> investorContributions = new ArrayList<>();
        investorContributions.add(500000);
        investorContributions.add(500000);
        List<Double> borrowerPaymentRatios = new ArrayList<>();
        borrowerPaymentRatios.add(0.25);
        borrowerPaymentRatios.add(0.25);
        borrowerPaymentRatios.add(0.5);

        calculatePayments(1000000,12, 5, investorContributions, borrowerPaymentRatios);*/

        List<Integer> investorContributions = new ArrayList<>();
        investorContributions.add(2253496);
        investorContributions.add(1966001);
        investorContributions.add(1520503);
        List<Double> borrowerPaymentRatios = new ArrayList<>();
        borrowerPaymentRatios.add(0.4);
        borrowerPaymentRatios.add(0.35);
        borrowerPaymentRatios.add(0.25);

        calculatePayments(5740000,32, 7.65,
                investorContributions, borrowerPaymentRatios);
    }

    public static Payments calculatePayments(int loanTotal, int periods,
                                             double interestRate,
                                             List<Integer> investorContributions,
                                             List<Double> borrowerPaymentRatios) {
        // Starting point for your code
        List<BigDecimal> borrowerPayments = new ArrayList<>();
        List<BigDecimal> investorMonthlyRepayments = new ArrayList<>();
        borrowerPaymentRatios.forEach(aDouble -> {
            borrowerPayments.add(BigDecimal.valueOf(aDouble).multiply(BigDecimal.valueOf(loanTotal)).setScale(2, RoundingMode.CEILING));
        });

        BigDecimal monthlyPayment = calculateMonthlyRepayment(loanTotal, interestRate,periods);
        System.out.println(monthlyPayment);

        investorContributions.forEach(investorContribution -> {
            investorMonthlyRepayments.add(monthlyPayment.multiply(BigDecimal.valueOf((double)investorContribution/loanTotal)).setScale(2, RoundingMode.CEILING));

        });

        return new Payments(borrowerPayments, investorMonthlyRepayments);
    }

    // Feel free to add your own classes and method if necessary
    static BigDecimal calculateMonthlyRepayment(int loanAmount, Double interestRate, int periods) {
        BigDecimal r = BigDecimal.valueOf(interestRate).divide(BigDecimal.valueOf(12), 20, RoundingMode.HALF_EVEN).divide(BigDecimal.valueOf(100), 20, RoundingMode.HALF_EVEN);
        BigDecimal onePlusR = r.add(BigDecimal.ONE);
        BigDecimal top = r.multiply(onePlusR.pow(periods));
        BigDecimal bottom = (onePlusR.pow(periods)).subtract(BigDecimal.ONE);
        return BigDecimal.valueOf(loanAmount).multiply(top.divide(bottom, 20, RoundingMode.HALF_UP));
    }

    public static class Payments {

        private List<BigDecimal> borrowerPayments;
        private List<BigDecimal> investorMonthlyRepayments;

        public Payments(List<BigDecimal> borrowerPayments, List<BigDecimal> investorMonthlyRepayments) {
            this.borrowerPayments = borrowerPayments;
            this.investorMonthlyRepayments = investorMonthlyRepayments;
        }

        public List<BigDecimal> getBorrowerPayments() {
            return this.borrowerPayments;
        }

        public List<BigDecimal> getInvestorMonthlyRepayments() {
            return this.investorMonthlyRepayments;
        }

        @Override
        public boolean equals(Object other) {
            return other instanceof Payments &&
                    this.borrowerPayments.equals(((Payments) other).getBorrowerPayments()) &&
                    this.investorMonthlyRepayments.equals(((Payments) other).getInvestorMonthlyRepayments());
        }

        @Override
        public String toString() {
            return this.borrowerPayments.toString() + " " + this.investorMonthlyRepayments.toString();
        }
    }
}
