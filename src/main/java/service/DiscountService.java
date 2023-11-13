package service;

import model.Date;

public class DiscountService {
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
}
