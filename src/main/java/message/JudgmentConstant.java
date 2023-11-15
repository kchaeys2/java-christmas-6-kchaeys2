package message;

public enum JudgmentConstant {
    ORDERS_MAX_SIZE(20),
    DATE_MIN_SIZE(1),
    DATE_MAX_SIZE(31),
    CHRISMAS(25),
    WEEK_UNIT(7),
    FRIDAY(1),
    SATURAY(2),
    SUNDAY(3);
    private final Integer number;
    JudgmentConstant (Integer number){
        this.number = number;
    }

    public Integer getNumber() {
        return number;
    }
}
