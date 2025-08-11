package mylab.bank.entity;

import mylab.bank.exception.InsufficientBalanceException;
import mylab.bank.exception.WithdrawalLimitExceededException;

/**
 * 당좌계좌 클래스로 출금 한도를 가지고 있습니다.
 * 
 * @author System
 * @version 1.0
 */
public class CheckingAccount extends Account {
    private double withdrawalLimit;
    
    /**
     * 당좌계좌 생성자
     * 
     * @param accountNumber 계좌번호
     * @param ownerName 소유자 이름
     * @param initialBalance 초기 잔액
     * @param withdrawalLimit 출금 한도
     */
    public CheckingAccount(String accountNumber, String ownerName, double initialBalance, double withdrawalLimit) {
        super(accountNumber, ownerName, initialBalance);
        this.withdrawalLimit = withdrawalLimit;
    }
    
    /**
     * 당좌계좌에서 출금합니다.
     * 
     * @param amount 출금할 금액
     * @throws WithdrawalLimitExceededException 출금 한도를 초과한 경우
     * @throws InsufficientBalanceException 잔액이 부족한 경우
     */
    @Override
    public void withdraw(double amount) throws InsufficientBalanceException {
        if (amount > withdrawalLimit) {
            throw new WithdrawalLimitExceededException(withdrawalLimit, amount);
        }
        if (amount > getBalance()) {
            throw new InsufficientBalanceException(getBalance(), amount);
        }
        setBalance(getBalance() - amount);
    }
    
    /**
     * 출금 한도를 반환합니다.
     * 
     * @return 출금 한도
     */
    public double getWithdrawalLimit() {
        return withdrawalLimit;
    }
    
    @Override
    public String toString() {
        return super.toString() + String.format(", 출금한도: %.1f원", withdrawalLimit);
    }
}