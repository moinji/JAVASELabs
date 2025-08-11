package mylab.bank.exception;

/**
 * 출금 한도를 초과했을 때 발생하는 예외
 * 
 * @author System
 * @version 1.0
 */
public class WithdrawalLimitExceededException extends InsufficientBalanceException {
    private double limit;
    private double requestedAmount;
    
    /**
     * 출금 한도와 요청 금액을 받아 예외 메시지를 생성하는 생성자
     * 
     * @param limit 출금 한도
     * @param amount 요청 금액
     */
    public WithdrawalLimitExceededException(double limit, double amount) {
        super(0, 0);
        this.limit = limit;
        this.requestedAmount = amount;
    }
    
    @Override
    public String getMessage() {
        return String.format("출금 한도를 초과했습니다. 한도: %.1f원, 요청 금액: %.1f원", limit, requestedAmount);
    }
}