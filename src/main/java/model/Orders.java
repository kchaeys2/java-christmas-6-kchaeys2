package model;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;

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
                throw new IllegalArgumentException("[ERROR] 유효하지 않은 주문입니다. 다시 입력해 주세요");
            }
            orders.put(menu,amount);
        }
        return orders;
    }
    private Menu validateMenu(String inputMenu){
        Menu menu = Menu.findByName(inputMenu);
        if (menu == Menu.EMPTY){
            throw new IllegalArgumentException("[ERROR] 유효하지 않은 주문입니다. 다시 입력해 주세요.");
        }
        return menu;
    }
    private Integer validateNumber(String inputAmount){
        if(Pattern.matches("^[\\\\d]*$",inputAmount)){
            throw new IllegalArgumentException("[ERROR] 숫자만 입력해주세요.");
        }
        return Integer.parseInt(inputAmount);
    }
    private Integer validateAmount(String inputAmount){
        Integer amount = validateNumber(inputAmount);
        if (amount < 1){
            throw new IllegalArgumentException("[ERROR] 유효하지 않은 주문입니다. 다시 입력해 주세요.");
        }
        return amount;
    }
    private void validateOnlyBeverage(Map<Menu,Integer> orders){
        boolean validationOnlyBeverage = orders.keySet().stream()
                .allMatch(menu -> Category.BEVERAGE == Category.findByMenu(menu));
        if (validationOnlyBeverage) {
            throw new IllegalArgumentException("[ERROR] 음료만 주문 시에만 주문 가능합니다.");
        }
    }
    private void validateOrdersSize(Map<Menu,Integer> orders){
        int size = orders.values().stream()
                .mapToInt(Integer::intValue).sum();
        if(size > 20){
            throw new IllegalArgumentException("[ERROR] 주문은 20개이하만 가능합니다.");
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
}
