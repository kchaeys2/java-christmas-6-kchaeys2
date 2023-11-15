package message;

public enum ErrorMessage {
    DATE_ERROR("[ERROR] 유효하지 않은 날짜입니다. 다시 입력해 주세요."),
    ORDER_ERROR("[ERROR] 유효하지 않은 주문입니다. 다시 입력해 주세요."),
    ORDER_CATEGORY_ALLBEVERAGE("[ERROR] 음료만 주문할 수 없습니다."),
    ORDER_MAX_SIZE("[ERROR] 주문은 20개이하만 가능합니다.");

    private final String msg;
    ErrorMessage(String msg){
        this.msg = msg;
    }
    public String getMsg() {
        return msg;
    }
}
