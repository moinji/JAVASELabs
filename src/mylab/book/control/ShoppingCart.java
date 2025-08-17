package mylab.book.control;

import mylab.book.entity.*;
import java.util.List;
import java.util.ArrayList;
import java.text.DecimalFormat;

public class ShoppingCart {
    private List<Publication> items = new ArrayList<>();
    
    public ShoppingCart() {
    }
    
    public void addItem(Publication item) {
        items.add(item);
        System.out.println(item.getTitle() + "이(가) 장바구니에 추가되었습니다.");
    }
    
    public boolean removeItem(String title) {
        for (int i = 0; i < items.size(); i++) {
            if (items.get(i).getTitle().equals(title)) {
                items.remove(i);
                System.out.println(title + "이(가) 장바구니에서 제거되었습니다.");
                return true;
            }
        }
        System.out.println(title + "을(를) 찾을 수 없습니다.");
        return false;
    }
    
    public int calculateTotalPrice() {
        int total = 0;
        for (Publication item : items) {
            total += item.getPrice();
        }
        return total;
    }
    
    public int calculateDiscountedPrice() {
        int total = 0;
        for (Publication item : items) {
            int price = item.getPrice();
            if (item instanceof Magazine) {
                total += (int)(price * 0.9);
            } else if (item instanceof Novel) {
                total += (int)(price * 0.85);
            } else if (item instanceof ReferenceBook) {
                total += (int)(price * 0.8);
            } else {
                total += price;
            }
        }
        return total;
    }
    
    public void displayCart() {
        DecimalFormat df = new DecimalFormat("#,###");
        
        System.out.println("====== 장바구니 내용 ======");
        for (int i = 0; i < items.size(); i++) {
            System.out.println((i + 1) + ". " + items.get(i).getTitle() + " - " + df.format(items.get(i).getPrice()) + "원");
        }
        System.out.println("총 가격: " + df.format(calculateTotalPrice()) + "원");
        System.out.println("할인 적용 가격: " + calculateDiscountedPrice() + "원");
    }
    
    public void printStatistics() {
        int magazineCount = 0;
        int novelCount = 0;
        int referenceBookCount = 0;
        
        for (Publication item : items) {
            if (item instanceof Magazine) {
                magazineCount++;
            } else if (item instanceof Novel) {
                novelCount++;
            } else if (item instanceof ReferenceBook) {
                referenceBookCount++;
            }
        }
        
        System.out.println("====== 장바구니 통계 ======");
        if (magazineCount > 0) System.out.println("잡지: " + magazineCount + "권");
        if (novelCount > 0) System.out.println("소설: " + novelCount + "권");
        if (referenceBookCount > 0) System.out.println("참고서: " + referenceBookCount + "권");
        System.out.println("총 출판물: " + items.size() + "권");
    }
    
    public static void main(String[] args) {
        ShoppingCart cart = new ShoppingCart();
        
        cart.addItem(new Magazine("마이크로소프트", "2007-10-01", 328, 9900, "매월"));
        cart.addItem(new Magazine("경영과컴퓨터", "2007-10-03", 316, 9000, "매월"));
        cart.addItem(new Novel("빠삐용", "2007-07-01", 396, 9800, "베르나르베르베르", "현대소설"));
        cart.addItem(new Novel("남한산성", "2007-04-14", 383, 11000, "김훈", "대하소설"));
        cart.addItem(new ReferenceBook("실용주의프로그래머", "2007-01-14", 496, 25000, "소프트웨어공학"));
        
        cart.displayCart();
        cart.printStatistics();
        
        cart.removeItem("빠삐용");
        cart.displayCart();
    }
}