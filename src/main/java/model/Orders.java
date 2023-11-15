package model;

import message.ErrorMessage;
import message.JudgmentConstant;
import message.Regex;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Orders {
    private final Map<Menu,Integer> orders;

    public Orders(List<String> orders){
        this.orders = convertOrders(orders);
        validateOnlyBeverage(this.orders);
        validateOrdersSize(this.orders);
    }
    private Map<Menu,Integer> convertOrders(List<String> inputOrders){
        Map<Menu,Integer> orders = new HashMap<>();

        for(int i=0;i< inputOrders.size();i+=2){
            Integer amount = validateAmount(inputOrders.get(i+1));
            Menu menu = validateMenu(inputOrders.get(i));
            if(orders.containsKey(menu)){
                throw new IllegalArgumentException(ErrorMessage.ORDER_ERROR.getMsg());
            }
            orders.put(menu,amount);
        }
        return orders;
    }
    private Menu validateMenu(String inputMenu){
        Menu menu = Menu.findByName(inputMenu);
        if (menu == Menu.EMPTY){
            throw new IllegalArgumentException(ErrorMessage.ORDER_ERROR.getMsg());
        }
        return menu;
    }
    private Integer validateNumber(String inputAmount){
        if(!inputAmount.matches(Regex.IS_NUMBER.getRegex())){
            throw new IllegalArgumentException(ErrorMessage.ORDER_ERROR.getMsg());
        }
        return Integer.parseInt(inputAmount);
    }
    private Integer validateAmount(String inputAmount){
        Integer amount = validateNumber(inputAmount);
        if (amount < 1){
            throw new IllegalArgumentException(ErrorMessage.ORDER_ERROR.getMsg());
        }
        return amount;
    }
    private void validateOnlyBeverage(Map<Menu,Integer> orders){
        boolean validationOnlyBeverage = orders.keySet().stream()
                .allMatch(menu -> Category.BEVERAGE == Category.findByMenu(menu));
        if (validationOnlyBeverage) {
            throw new IllegalArgumentException(ErrorMessage.ORDER_CATEGORY_ALLBEVERAGE.getMsg());
        }
    }
    private void validateOrdersSize(Map<Menu,Integer> orders){
        int size = orders.values().stream()
                .mapToInt(Integer::intValue).sum();
        if(size > JudgmentConstant.ORDERS_MAX_SIZE.getNumber()){
            throw new IllegalArgumentException(ErrorMessage.ORDER_MAX_SIZE.getMsg());
        }
    }
    public Integer sumPrice(){
        Integer totalPrice = 0;
        for(Map.Entry<Menu,Integer> order : orders.entrySet()){
            Integer price = order.getKey().getPrice();
            Integer amount = order.getValue();
            totalPrice += price*amount;
        }
        return totalPrice;
    }
    public Long countCategory(Category category){
        return orders.keySet().stream()
                .filter(order -> Category.findByMenu(order) == category)
                .count();
    }
}
