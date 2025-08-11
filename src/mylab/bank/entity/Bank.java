package mylab.bank.entity;

import java.util.ArrayList;
import mylab.bank.exception.AccountNotFoundException;
import mylab.bank.exception.InsufficientBalanceException;

/**
 * 은행 클래스로 계좌들의 생명주기를 관리합니다. (합성 패턴)
 * 
 * @author System
 * @version 1.0
 */
public class Bank {
    private ArrayList<Account> accounts;
    private int nextAccountNumber;
    
    /**
     * 은행 생성자
     */
    public Bank() {
        this.accounts = new ArrayList<>();
        this.nextAccountNumber = 1000;
    }
    
    /**
     * 다음 계좌번호를 생성합니다.
     * 
     * @return 새 계좌번호
     */
    private String nextId() {
        return "AC" + nextAccountNumber++;
    }
    
    /**
     * 계좌번호로 계좌를 찾습니다.
     * 
     * @param accountNumber 계좌번호
     * @return 찾은 계좌
     * @throws AccountNotFoundException 계좌를 찾을 수 없는 경우
     */
    private Account find(String accountNumber) throws AccountNotFoundException {
        for (Account account : accounts) {
            if (account.getAccountNumber().equals(accountNumber)) {
                return account;
            }
        }
        throw new AccountNotFoundException(accountNumber);
    }
    
    /**
     * 저축계좌를 생성합니다.
     * 
     * @param ownerName 소유자 이름
     * @param initialBalance 초기 잔액
     * @param interestRate 이자율
     * @return 생성된 계좌번호
     */
    public String createSavings(String ownerName, double initialBalance, double interestRate) {
        String accountNumber = nextId();
        SavingsAccount account = new SavingsAccount(accountNumber, ownerName, initialBalance, interestRate);
        accounts.add(account);
        return accountNumber;
    }
    
    /**
     * 당좌계좌를 생성합니다.
     * 
     * @param ownerName 소유자 이름
     * @param initialBalance 초기 잔액
     * @param withdrawalLimit 출금 한도
     * @return 생성된 계좌번호
     */
    public String createChecking(String ownerName, double initialBalance, double withdrawalLimit) {
        String accountNumber = nextId();
        CheckingAccount account = new CheckingAccount(accountNumber, ownerName, initialBalance, withdrawalLimit);
        accounts.add(account);
        return accountNumber;
    }
    
    /**
     * 계좌를 조회합니다.
     * 
     * @param accountNumber 계좌번호
     * @return 계좌 객체
     * @throws AccountNotFoundException 계좌를 찾을 수 없는 경우
     */
    public Account getAccount(String accountNumber) throws AccountNotFoundException {
        return find(accountNumber);
    }
    
    /**
     * 입금합니다.
     * 
     * @param accountNumber 계좌번호
     * @param amount 입금 금액
     * @throws AccountNotFoundException 계좌를 찾을 수 없는 경우
     */
    public void deposit(String accountNumber, double amount) throws AccountNotFoundException {
        Account account = find(accountNumber);
        account.deposit(amount);
    }
    
    /**
     * 출금합니다.
     * 
     * @param accountNumber 계좌번호
     * @param amount 출금 금액
     * @throws AccountNotFoundException 계좌를 찾을 수 없는 경우
     * @throws InsufficientBalanceException 잔액이 부족한 경우
     */
    public void withdraw(String accountNumber, double amount) 
            throws AccountNotFoundException, InsufficientBalanceException {
        Account account = find(accountNumber);
        account.withdraw(amount);
    }
    
    /**
     * 계좌 간 이체를 수행합니다.
     * 
     * @param fromAccount 출금 계좌번호
     * @param toAccount 입금 계좌번호
     * @param amount 이체 금액
     * @throws AccountNotFoundException 계좌를 찾을 수 없는 경우
     * @throws InsufficientBalanceException 잔액이 부족한 경우
     */
    public void transfer(String fromAccount, String toAccount, double amount) 
            throws AccountNotFoundException, InsufficientBalanceException {
        Account from = find(fromAccount);
        Account to = find(toAccount);
        from.withdraw(amount);
        to.deposit(amount);
    }
    
    /**
     * 모든 계좌를 출력합니다.
     */
    public void printAllAccounts() {
        System.out.println("=== 전체 계좌 목록 ===");
        for (Account account : accounts) {
            System.out.println(account.toString());
        }
        System.out.println("=================");
    }
    
    /**
     * 저축계좌에 이자를 적용합니다.
     * 
     * @param accountNumber 계좌번호
     * @throws AccountNotFoundException 계좌를 찾을 수 없는 경우
     */
    public void applyInterest(String accountNumber) throws AccountNotFoundException {
        Account account = find(accountNumber);
        if (account instanceof SavingsAccount) {
            ((SavingsAccount) account).applyInterest();
        }
    }
}