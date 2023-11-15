package service;

import message.DiscountConstant;
import model.Category;
import model.Date;
import model.Menu;
import model.Orders;

public class DiscountService {
    public Integer discountChristmas(Date date) {
        return date.discountChrismas();
    }

    public Integer discountSpecial(Date date) {
        if (date.checkStar()) {
            return DiscountConstant.SPECIAL.getDiscount();
        }
        return DiscountConstant.NO_DISCOUNT.getDiscount();
    }

    public Integer eventChampagne(Integer orderAmount) {
        if (orderAmount >= 120000) {
            return Menu.CHAMPAGNE.getPrice();
        }
        return DiscountConstant.NO_DISCOUNT.getDiscount();
    }

    public Integer discountWeek(Date date, Orders orders) {
        if (date.checkWeek().equals("평일")) {
            return Math.toIntExact(orders.countCategory(Category.DESSERT) * DiscountConstant.WEEKS.getDiscount());
        }
        return DiscountConstant.NO_DISCOUNT.getDiscount();
    }

    public Integer discountWeekend(Date date, Orders orders) {
        if (date.checkWeek().equals("주말")) {
            return Math.toIntExact(orders.countCategory(Category.MAIN) * DiscountConstant.WEEKS.getDiscount());
        }
        return DiscountConstant.NO_DISCOUNT.getDiscount();
    }
}
