package mylab.bank.control;

import mylab.bank.entity.*;
import mylab.bank.exception.*;

/**
 * 은행 계좌 관리 시스템의 데모 클래스
 * 
 * @author System
 * @version 1.0
 */
public class BankDemo {
    
    public static void main(String[] args) {
        Bank bank = new Bank();
        
        System.out.println("=== 은행 계좌 관리 시스템 데모 ===");
        
        try {
            // 1. 계좌 생성
            System.out.println("\n1. 계좌 생성");
            String savingsAccount1 = bank.createSavings("홍길동", 100000, 0.03);
            System.out.println("저축계좌 생성: " + savingsAccount1);
            
            String checkingAccount = bank.createChecking("김철수", 50000, 30000);
            System.out.println("당좌계좌 생성: " + checkingAccount);
            
            String savingsAccount2 = bank.createSavings("이영희", 200000, 0.02);
            System.out.println("저축계좌 생성: " + savingsAccount2);
            
            // 2. 전체 계좌 출력
            System.out.println("\n2. 전체 계좌 목록");
            bank.printAllAccounts();
            
            // 3. 입금/출금 테스트
            System.out.println("\n3. 입금/출금 테스트");
            bank.deposit(savingsAccount1, 25000);
            System.out.println(savingsAccount1 + "에 25000원 입금");
            System.out.println("현재 잔액: " + bank.getAccount(savingsAccount1).getBalance() + "원");
            
            bank.withdraw(checkingAccount, 20000);
            System.out.println(checkingAccount + "에서 20000원 출금");
            System.out.println("현재 잔액: " + bank.getAccount(checkingAccount).getBalance() + "원");
            
            // 4. 이자 적용 테스트
            System.out.println("\n4. 이자 적용 테스트");
            System.out.println("이자 적용 전 " + savingsAccount1 + " 잔액: " + 
                             bank.getAccount(savingsAccount1).getBalance() + "원");
            bank.applyInterest(savingsAccount1);
            System.out.println("이자 적용 후 " + savingsAccount1 + " 잔액: " + 
                             bank.getAccount(savingsAccount1).getBalance() + "원");
            
            // 5. 계좌 이체 테스트
            System.out.println("\n5. 계좌 이체 테스트");
            System.out.println("이체 전:");
            System.out.println(savingsAccount2 + " 잔액: " + bank.getAccount(savingsAccount2).getBalance() + "원");
            System.out.println(savingsAccount1 + " 잔액: " + bank.getAccount(savingsAccount1).getBalance() + "원");
            
            bank.transfer(savingsAccount2, savingsAccount1, 50000);
            System.out.println("50000원 이체 완료");
            
            System.out.println("이체 후:");
            System.out.println(savingsAccount2 + " 잔액: " + bank.getAccount(savingsAccount2).getBalance() + "원");
            System.out.println(savingsAccount1 + " 잔액: " + bank.getAccount(savingsAccount1).getBalance() + "원");
            
            // 6. 예외 테스트
            System.out.println("\n6. 예외 테스트");
            
            // 6-1. 출금 한도 초과 테스트
            System.out.println("6-1. 출금 한도 초과 테스트");
            try {
                bank.withdraw(checkingAccount, 35000);
            } catch (WithdrawalLimitExceededException e) {
                System.out.println("예외 발생: " + e.getMessage());
            }
            
            // 6-2. 잔액 부족 테스트
            System.out.println("6-2. 잔액 부족 테스트");
            try {
                bank.withdraw(savingsAccount1, 500000);
            } catch (InsufficientBalanceException e) {
                System.out.println("예외 발생: " + e.getMessage());
            }
            
            // 6-3. 계좌 없음 테스트
            System.out.println("6-3. 존재하지 않는 계좌 테스트");
            try {
                bank.getAccount("AC9999");
            } catch (AccountNotFoundException e) {
                System.out.println("예외 발생: " + e.getMessage());
            }
            
            // 6-4. 잘못된 입금액 테스트
            System.out.println("6-4. 잘못된 입금액 테스트");
            try {
                bank.deposit(savingsAccount1, -1000);
            } catch (IllegalArgumentException e) {
                System.out.println("예외 발생: " + e.getMessage());
            }
            
            // 7. 최종 계좌 상태
            System.out.println("\n7. 최종 계좌 상태");
            bank.printAllAccounts();
            
        } catch (Exception e) {
            System.out.println("오류 발생: " + e.getMessage());
            e.printStackTrace();
        }
        
        System.out.println("\n=== 데모 완료 ===");
    }
}