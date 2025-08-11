package mylab.bank.entity;

import mylab.bank.exception.InsufficientBalanceException;

/**
 * 계좌의 추상 클래스로 모든 계좌 타입의 기본 기능을 정의합니다.
 * 
 * @author System
 * @version 1.0
 */
public abstract class Account {
    private String accountNumber;
    private String ownerName;
    private double balance;
    
    /**
     * 계좌 생성자
     * 
     * @param accountNumber 계좌번호
     * @param ownerName 소유자 이름
     * @param initialBalance 초기 잔액
     */
    public Account(String accountNumber, String ownerName, double initialBalance) {
        this.accountNumber = accountNumber;
        this.ownerName = ownerName;
        this.balance = initialBalance;
    }
    
    /**
     * 계좌번호를 반환합니다.
     * 
     * @return 계좌번호
     */
    public String getAccountNumber() {
        return accountNumber;
    }
    
    /**
     * 소유자 이름을 반환합니다.
     * 
     * @return 소유자 이름
     */
    public String getOwnerName() {
        return ownerName;
    }
    
    /**
     * 소유자 이름을 설정합니다.
     * 
     * @param ownerName 새 소유자 이름
     */
    public void setOwnerName(String ownerName) {
        this.ownerName = ownerName;
    }
    
    /**
     * 계좌 잔액을 반환합니다.
     * 
     * @return 잔액
     */
    public double getBalance() {
        return balance;
    }
    
    /**
     * 계좌에 입금합니다.
     * 
     * @param amount 입금할 금액
     * @throws IllegalArgumentException 입금액이 0 이하인 경우
     */
    public void deposit(double amount) {
        if (amount <= 0) {
            throw new IllegalArgumentException("입금액은 0보다 커야 합니다.");
        }
        this.balance += amount;
    }
    
    /**
     * 계좌에서 출금합니다. (추상 메서드)
     * 
     * @param amount 출금할 금액
     * @throws InsufficientBalanceException 잔액이 부족한 경우
     */
    public abstract void withdraw(double amount) throws InsufficientBalanceException;
    
    /**
     * 잔액을 직접 설정합니다. (protected 메서드로 상속 클래스에서만 사용)
     * 
     * @param balance 새 잔액
     */
    protected void setBalance(double balance) {
        this.balance = balance;
    }
    
    @Override
    public String toString() {
        return String.format("계좌번호: %s, 소유자: %s, 잔액: %.1f원", 
                           accountNumber, ownerName, balance);
    }
}