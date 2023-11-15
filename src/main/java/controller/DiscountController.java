package controller;

import camp.nextstep.edu.missionutils.Console;
import message.DiscountConstant;
import message.DiscountMessage;
import message.OutputHeadMessage;
import model.Badge;
import model.Date;
import model.Orders;
import service.DiscountService;
import view.InputView;
import view.OutputView;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DiscountController {
    private final InputView inputView;
    private final OutputView outputView;
    private final DiscountService service;

    public DiscountController(InputView inputView, OutputView outputView){
        this.inputView = inputView;
        this.outputView = outputView;
        this.service = new DiscountService();
    }
    public void flowControll(){
        String inputDate = inputView.inputDate();
        Date date = controllDate(inputDate);

        List<String> inputOrders = inputView.inputOrders();
        Orders orders = controllOrders(inputOrders);

        print(inputDate,inputOrders);

        discount(date,orders);
    }
    public void discount(Date date,Orders orders){
        Integer totalPrice = orders.sumPrice();
        outputView.printTotalPrice(totalPrice);
        outputView.printGift(service.eventChampagne(totalPrice));

        Integer discount = 0;
        if (totalPrice > DiscountConstant.POSSIBLE.getDiscount()){
            discount = sumDiscount(date, orders);
        }
        outputView.isZeroSumDiscount(discount,discountContent(date,orders));
        outputView.printTotalDiscount(discount);
        Integer realPrice = totalPrice - discount;
        outputView.printRealPrice(realPrice);

        outputView.printBadge(Badge.findByMinPrice(discount));
    }

    private void print(String inputDate,List<String> inputOrders){
        outputView.start(inputDate);
        outputView.printHead(OutputHeadMessage.ORDER_MENU.getMsg());
        outputView.printOrders(inputOrders);
    }
    private Date controllDate(String inputData){
        try{
            return new Date(inputData);
        }catch (IllegalArgumentException exception){
            outputView.printError(exception);
            inputData = Console.readLine();
            return controllDate(inputData);
        }
    }
    private Orders controllOrders(List<String> inputOrders){
        try{
            return new Orders(inputOrders);
        }catch (IllegalArgumentException exception){
            outputView.printError(exception);
            inputOrders = inputView.formatOrders();
            return controllOrders(inputOrders);
        }
    }
    private Integer sumDiscount(Date date,Orders orders){
        outputView.printHead(OutputHeadMessage.DISCOUNT_CONTENT.getMsg());
        return discountContent(date,orders).values()
                .stream()
                .mapToInt(Integer::intValue)
                .sum();
    }
    private Map<DiscountMessage,Integer> discountContent(Date date,Orders orders){
        Map<DiscountMessage,Integer> discounts = new HashMap<>();

        discounts.put(DiscountMessage.CHRISMAS, service.discountChristmas(date));
        discounts.put(DiscountMessage.SPECIAL, service.discountSpecial(date));
        discounts.put(DiscountMessage.WEEK, service.discountWeek(date,orders));
        discounts.put(DiscountMessage.WEEKEND, service.discountWeekend(date,orders));
        discounts.put(DiscountMessage.GIFT, service.eventChampagne(orders.sumPrice()));

        return discounts;
    }
}
