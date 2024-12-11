package application.Entity;

import java.text.DecimalFormat;

public class MortgageCalculator {
    public static void main(String[] args) {
    	double test = MortgageCalculator.calculateMortgage(1000000, 10);
    	System.out.println(test);
    }
    public static double calculateMortgage(double price,int year) {
    	double interestRate = 0.04;
        double monthlyInterestRate = interestRate / 12;

        // Calculate number of payments
        int numberOfPayments = year * 12;

        // Calculate mortgage payment
        double mortgageAmount = (price * monthlyInterestRate) / (1 - Math.pow(1 + monthlyInterestRate, -numberOfPayments));

        // Format mortgage amount
        
    	
    	
    	return mortgageAmount;
    }
}