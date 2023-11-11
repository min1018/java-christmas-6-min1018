package christmas.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SpecialDiscount {
    private static final List<Integer> specialDayDiscount = new ArrayList<>(Arrays.asList(3, 10, 17, 24, 31, 25));

    public static boolean isAvailable(int date) {
        if (specialDayDiscount.contains(date)) {
            return true;
        }
        return false;
    }

}
