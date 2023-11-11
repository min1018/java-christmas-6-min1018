package christmas.service;

public class BonusDiscount {
    public static boolean isAvaliable(int totalPayment) {
        if(totalPayment > 120000) {
            return true;
        }
        return false;
    }
}
