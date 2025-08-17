package mylab.book.control;

import mylab.book.entity.*;
import java.util.Map;
import java.util.HashMap;
import java.text.DecimalFormat;

public class StatisticsAnalyzer {
    
    public Map<String, Double> calculateAveragePriceByType(Publication[] publications) {
        Map<String, Integer> totalPrices = new HashMap<>();
        Map<String, Integer> counts = new HashMap<>();
        
        for (Publication pub : publications) {
            String type = getPublicationType(pub);
            totalPrices.put(type, totalPrices.getOrDefault(type, 0) + pub.getPrice());
            counts.put(type, counts.getOrDefault(type, 0) + 1);
        }
        
        Map<String, Double> averages = new HashMap<>();
        for (String type : totalPrices.keySet()) {
            averages.put(type, (double) totalPrices.get(type) / counts.get(type));
        }
        
        return averages;
    }
    
    public Map<String, Double> calculatePublicationDistribution(Publication[] publications) {
        Map<String, Integer> counts = new HashMap<>();
        
        for (Publication pub : publications) {
            String type = getPublicationType(pub);
            counts.put(type, counts.getOrDefault(type, 0) + 1);
        }
        
        Map<String, Double> distribution = new HashMap<>();
        int total = publications.length;
        for (String type : counts.keySet()) {
            distribution.put(type, (double) counts.get(type) / total * 100);
        }
        
        return distribution;
    }
    
    public double calculatePublicationRatioByYear(Publication[] publications, String year) {
        int totalCount = publications.length;
        int yearCount = 0;
        
        for (Publication pub : publications) {
            if (pub.getPublishDate().startsWith(year)) {
                yearCount++;
            }
        }
        
        return (double) yearCount / totalCount * 100;
    }
    
    private String getPublicationType(Publication pub) {
        if (pub instanceof Novel) {
            return "소설";
        } else if (pub instanceof Magazine) {
            return "잡지";
        } else if (pub instanceof ReferenceBook) {
            return "참고서";
        } else {
            return "기타";
        }
    }
    
    public void printStatistics(Publication[] publications) {
        DecimalFormat df = new DecimalFormat("#,###.##");
        
        System.out.println("===== 출판물 통계 분석 =====");
        
        Map<String, Double> averages = calculateAveragePriceByType(publications);
        System.out.println("1. 타입별 평균 가격:");
        System.out.println("   - 소설: " + df.format(averages.get("소설")) + "원");
        System.out.println("   - 참고서: " + df.format(averages.get("참고서")) + "원");
        System.out.println("   - 잡지: " + df.format(averages.get("잡지")) + "원");
        
        System.out.println();
        Map<String, Double> distribution = calculatePublicationDistribution(publications);
        System.out.println("2. 출판물 유형 분포:");
        System.out.println("   - 소설: " + df.format(distribution.get("소설")) + "%");
        System.out.println("   - 참고서: " + df.format(distribution.get("참고서")) + "%");
        System.out.println("   - 잡지: " + df.format(distribution.get("잡지")) + "%");
        
        System.out.println();
        double ratio2007 = calculatePublicationRatioByYear(publications, "2007");
        System.out.println("3. 2007년에 출판된 출판물 비율: " + df.format(ratio2007) + "%");
    }
}