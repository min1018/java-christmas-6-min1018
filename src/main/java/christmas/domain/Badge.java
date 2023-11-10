package christmas.domain;

public enum Badge {
    None(0, "없음"),
    Star(5000, "별"),
    Tree(10000, "트리"),
    Santa(20000, "산타");

    private final int price;
    private final String badgeName;

    Badge(int price, String badgeName) {
        this.price = price;
        this.badgeName = badgeName;
    }
    public String getBadgeName() {
        return badgeName;
    }
    public static Badge valueOf(int price) {
        if (price >= 20000) {
            return Santa;
        }
        if (price >= 10000) {
            return Tree;
        }
        if (price >= 5000) {
            return Star;
        }
        return None;
    }
}
