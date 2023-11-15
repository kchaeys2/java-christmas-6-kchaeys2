package view;

import message.DiscountConstant;
import message.DiscountMessage;
import message.OutputHeadMessage;
import message.Regex;
import model.Menu;

import java.util.List;
import java.util.Map;

public class OutputView {
    public void printError(Exception exception){
        System.out.println(exception.getMessage());
    }
    public void start(String date){
        System.out.println("12월 "+date+"일에 우테코 식당에서 받을 이벤트 혜택 미리 보기!");
    }
    public void printHead(String head){
        System.out.println(OutputHeadMessage.STARTAG.getMsg() +head+OutputHeadMessage.ENDTAG.getMsg());
    }
    public void printOrders(List<String> outputOrders){
        for (int i=0; i<outputOrders.size(); i+=2){
            System.out.println(outputOrders.get(i)+" "+outputOrders.get(i+1)+"개");
        }
    }
    private String formatPrice(Integer priceNumber){
        String price = String.format(Regex.THOUSAND.getRegex(), priceNumber);
        return price + "원";
    }
    public void printTotalPrice(Integer totalPrice){
        printHead(OutputHeadMessage.TOTALPRICE.getMsg());

        System.out.println(formatPrice(totalPrice));
    }
    public void printGift(Integer gift){
        printHead(OutputHeadMessage.GIFT.getMsg());
        if (gift > DiscountConstant.NO_DISCOUNT.getDiscount()){
            System.out.println(Menu.CHAMPAGNE.getName()+" "+gift/Menu.CHAMPAGNE.getPrice()+"개");
        } else if (gift <= DiscountConstant.NO_DISCOUNT.getDiscount()) {
            System.out.println("없음");
        }
    }
    public void printTotalDiscount(Integer discount){
        printHead(OutputHeadMessage.TOTAL_DISCOUNT.getMsg());
        System.out.println(formatPrice(discount*-1));
    }
    public void printRealPrice(Integer price){
        printHead(OutputHeadMessage.REALPRICE.getMsg());
        System.out.println(formatPrice(price));
    }
    public void printBadge(String badge){
        printHead(OutputHeadMessage.BADGE.getMsg());
        System.out.println(badge);
    }
    private void printDiscount(Map<DiscountMessage,Integer> discount){
        discount.keySet().forEach(msg -> {
            int discountAmount = discount.get(msg);
            if (discountAmount > DiscountConstant.NO_DISCOUNT.getDiscount()) {
                System.out.println(msg.getMsg() + formatPrice(discountAmount * -1));
            }
        });
    }
    public void isZeroSumDiscount(Integer discount,Map<DiscountMessage,Integer> discountContent){
        if(discount <= DiscountConstant.NO_DISCOUNT.getDiscount()){
            System.out.println("없음");
        }
        printDiscount(discountContent);
    }
}
