package christmas.domain;


import java.util.HashMap;
import java.util.Map;

public enum DiscountOption {
    dDayDiscount("디데이"),
    bonusDiscount("증정"),
    weekdayDiscount("평일"),
    weekendDiscount("주말"),
    specialDiscount("특별");

    private final String whichDiscount;
    private static Map<String, Integer> discountAndAmounts = new HashMap<>();

    static {
        discountAndAmounts.put("디데이", 0);
        discountAndAmounts.put("증정", 0);
        discountAndAmounts.put("평일", 0);
        discountAndAmounts.put("주말", 0);
        discountAndAmounts.put("특별", 0);
    }
    DiscountOption(String whichDiscount) {
        this.whichDiscount = whichDiscount;
    }

    public int getDiscountAmount() {
        return discountAndAmounts.get(whichDiscount);
    }
    public void changeDiscountAmount(int discountAmount) {
        discountAndAmounts.put(whichDiscount, discountAmount);
    }

    public static DiscountOption fromString(String whichDiscount) {
        if ("증정".equals(whichDiscount)) {
            return bonusDiscount;
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
        return specialDiscount;
    }

}
