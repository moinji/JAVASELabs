package mylab.book.control;

import mylab.book.entity.*;

public class ManageBook {
    
    public static void modifyPrice(Publication publication) {
        int currentPrice = publication.getPrice();
        if (publication instanceof Magazine) {
            publication.setPrice((int)(currentPrice * 0.6));
        } else if (publication instanceof Novel) {
            publication.setPrice((int)(currentPrice * 0.8));
        } else if (publication instanceof ReferenceBook) {
            publication.setPrice((int)(currentPrice * 0.9));
        }
    }
    
    public static void main(String[] args) {
        Publication[] publications = {
            new Magazine("마이크로소프트", "2007-10-01", 328, 9900, "매월"),
            new Magazine("경영과컴퓨터", "2007-10-03", 316, 9000, "매월"),
            new Novel("빠삐용", "2007-07-01", 396, 9800, "베르나르베르베르", "현대소설"),
            new Novel("남한산성", "2007-04-14", 383, 11000, "김훈", "대하소설"),
            new ReferenceBook("실용주의프로그래머", "2007-01-14", 496, 25000, "소프트웨어공학"),
            new Novel("소년이온다", "2014-05-01", 216, 15000, "한강", "장편소설"),
            new Novel("작별하지않는다", "2021-09-09", 332, 15120, "한강", "장편소설")
        };
        
        System.out.println("==== 도서 정보 출력 ====");
        for (int i = 0; i < publications.length; i++) {
            System.out.println((i + 1) + ". " + publications[i].toString());
        }
        
        System.out.println();
        System.out.println("==== 가격 변경 ====");
        Publication targetBook = publications[6];
        int originalPrice = targetBook.getPrice();
        modifyPrice(targetBook);
        int newPrice = targetBook.getPrice();
        int difference = originalPrice - newPrice;
        
        System.out.println(targetBook.getTitle() + " 변경 전 가격: " + originalPrice + "원");
        System.out.println(targetBook.getTitle() + " 변경 후 가격: " + newPrice + "원");
        System.out.println("차액: " + difference + "원");
        
        System.out.println();
        StatisticsAnalyzer analyzer = new StatisticsAnalyzer();
        analyzer.printStatistics(publications);
    }
}