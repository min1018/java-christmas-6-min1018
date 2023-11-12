package christmas.domain;

public class DiscountHistory {
    private int DdayDiscount;
    private int weekdayDiscount;
    private int weekendDiscount;
    private int specialDiscount;
    private int bonusDiscount;
    private int totalDiscount;

    public DiscountHistory() {
        this.bonusDiscount = 0;
        this.DdayDiscount = 0;
        this.specialDiscount = 0;
        this.weekdayDiscount = 0;
        this.weekendDiscount = 0;
        this.totalDiscount = 0;
    }
    public void updateDday(int ddayDiscount) {
        this.DdayDiscount = ddayDiscount;
        this.totalDiscount += ddayDiscount;
    }

    public void updateBonus(int bonusDiscount) {
        this.bonusDiscount = bonusDiscount;
        this.totalDiscount += 25000;
    }

    public void updateSpecial(int specialDiscount) {
        this.specialDiscount = specialDiscount;
        this.totalDiscount += specialDiscount;
    }
    public void updateWeekend(int weekendDiscount) {
        this.weekendDiscount = weekendDiscount;
        this.totalDiscount += weekendDiscount;
    }
    public void updateWeekdays(int weekdayDiscount) {
        this.weekdayDiscount = weekdayDiscount;
        this.totalDiscount += weekdayDiscount;
    }
    public int getTotalDiscount() {
        return totalDiscount;
    }


}
