package mylab.bank.exception;

/**
 * 계좌를 찾을 수 없을 때 발생하는 예외
 * 
 * @author System
 * @version 1.0
 */
public class AccountNotFoundException extends Exception {
    
    /**
     * 계좌번호를 받아 예외 메시지를 생성하는 생성자
     * 
     * @param accountNumber 찾을 수 없는 계좌번호
     */
    public AccountNotFoundException(String accountNumber) {
        super("계좌번호 " + accountNumber + "에 해당하는 계좌를 찾을 수 없습니다.");
    }
}