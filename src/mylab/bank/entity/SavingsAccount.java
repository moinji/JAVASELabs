package mylab.bank.entity;

import mylab.bank.exception.InsufficientBalanceException;

/**
 * 저축계좌 클래스로 이자율을 가지고 있으며 이자를 적용할 수 있습니다.
 * 
 * @author System
 * @version 1.0
 */
public class SavingsAccount extends Account {
    private double interestRate;
    
    /**
     * 저축계좌 생성자
     * 
     * @param accountNumber 계좌번호
     * @param ownerName 소유자 이름
     * @param initialBalance 초기 잔액
     * @param interestRate 이자율
     */
    public SavingsAccount(String accountNumber, String ownerName, double initialBalance, double interestRate) {
        super(accountNumber, ownerName, initialBalance);
        this.interestRate = interestRate;
    }
    
    /**
     * 이자를 적용합니다.
     */
    public void applyInterest() {
        double currentBalance = getBalance();
        setBalance(currentBalance + (currentBalance * interestRate));
    }
    
    /**
     * 저축계좌에서 출금합니다.
     * 
     * @param amount 출금할 금액
     * @throws InsufficientBalanceException 잔액이 부족한 경우
     */
    @Override
    public void withdraw(double amount) throws InsufficientBalanceException {
        if (amount > getBalance()) {
            throw new InsufficientBalanceException(getBalance(), amount);
        }
        setBalance(getBalance() - amount);
    }
    
    /**
     * 이자율을 반환합니다.
     * 
     * @return 이자율
     */
    public double getInterestRate() {
        return interestRate;
    }
    
    @Override
    public String toString() {
        return super.toString() + String.format(", 이자율: %.1f%%", interestRate * 100);
    }
}