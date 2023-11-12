package christmas.domain;

import java.util.Arrays;

public enum DiscountOption {
    NONE("에러", 0),
    dDayDiscount("디데이",0),
    bonusDiscount("증정",0),
    weekdayDiscount("평일",0),
    weekendDiscount("주말",0),
    specialDiscount("특별",0);

    private final String whichDiscount;
    private int discountAmount;

    DiscountOption(String whichDiscount, int DiscountAmount) {
        this.whichDiscount = whichDiscount;
        this.discountAmount = DiscountAmount;
    }

    public int getDiscountAmount() {
        return discountAmount;
    }
    public void changeDiscountAmount(int discountAmount) {
        this.discountAmount = discountAmount;
    }

    public static DiscountOption fromString(String whichDiscount) {
        if ("증정".equals(whichDiscount)) {
            return specialDiscount;
        }
        if ("주말".equals(whichDiscount)) {
            return weekendDiscount;
        }
        if ("평일".equals(whichDiscount)) {
            return weekdayDiscount;
        }
        if ("디데이".equals(whichDiscount)) {
            return dDayDiscount;
        }
        if ("특별".equals(whichDiscount)) {
            return specialDiscount;
        }
        return NONE;
    }

}
