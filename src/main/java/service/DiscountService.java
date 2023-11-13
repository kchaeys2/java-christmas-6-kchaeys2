package service;

import model.Category;
import model.Date;
import model.Orders;

public class DiscountService {
    private final Orders orders;
    public DiscountService(Orders orders,Integer orderAmount){
        this.orders = orders;
    }
    public Boolean possibleDiscount(Integer orderAmount){
        return orderAmount > 10000;
    }
    public Integer discountChristmas(Date date,Integer orderAmount){
        return orderAmount - date.discountChrismas();
    }
    public Integer discountSpecial(Date date,Integer orderAmount){
        if (date.checkStar()){
            return orderAmount - 1000;
        }
        return orderAmount;
    }
    public Boolean eventChampagne(Integer orderAmount){
        return orderAmount >= 120000;
    }
    public Integer discountWeek(Date date){
        if (date.checkWeek().equals("평일")){
            return Math.toIntExact(orders.countCategory(Category.DESSERT) * 2023);
        }
        return 0;
    }
    public Integer discountWeekend(Date date){
        if(date.checkWeek().equals("주말")){
            return Math.toIntExact(orders.countCategory(Category.MAIN) * 2023);
        }
        return 0;
    }
}
