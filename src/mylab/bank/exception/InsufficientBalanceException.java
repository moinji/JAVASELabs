package mylab.bank.exception;

/**
 * 잔액이 부족할 때 발생하는 예외
 * 
 * @author System
 * @version 1.0
 */
public class InsufficientBalanceException extends Exception {
    
    /**
     * 현재 잔액과 요청 금액을 받아 예외 메시지를 생성하는 생성자
     * 
     * @param balance 현재 잔액
     * @param amount 요청 금액
     */
    public InsufficientBalanceException(double balance, double amount) {
        super(String.format("잔액 부족: 현재 잔액 %.1f원, 요청 금액 %.1f원", balance, amount));
    }
}