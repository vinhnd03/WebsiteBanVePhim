package nhom3.datn.entity;

public class MonthlyRevenueDTO {
    private Integer month;
    private String category;
    private Double totalMovieRevenue;
    private Double totalFoodRevenue;

    public MonthlyRevenueDTO(Integer month, String category, Double totalMovieRevenue, Double totalFoodRevenue) {
        this.month = month;
        this.category = category;
        this.totalMovieRevenue = totalMovieRevenue;
        this.totalFoodRevenue = totalFoodRevenue;
    }

    public Integer getMonth() {
        return month;
    }

    public String getCategory() {
        return category;
    }

    public Double getTotalMovieRevenue() {
        return totalMovieRevenue;
    }

    public Double getTotalFoodRevenue() {
        return totalFoodRevenue;
    }

    public void setMonth(Integer month) {
        this.month = month;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public void setTotalMovieRevenue(Double totalMovieRevenue) {
        this.totalMovieRevenue = totalMovieRevenue;
    }

    public void setTotalFoodRevenue(Double totalFoodRevenue) {
        this.totalFoodRevenue = totalFoodRevenue;
    }

    @Override
    public String toString() {
        return "MonthlyRevenueDTO [month=" + month + ", category=" + category + ", totalMovieRevenue="
                + totalMovieRevenue + ", totalFoodRevenue=" + totalFoodRevenue + "]";
    }

    
    
}
