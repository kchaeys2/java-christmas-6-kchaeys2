package model;

import org.junit.jupiter.api.Test;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

class OrdersTest {
    @Test
    void 메뉴판에없는메뉴검증테스트(){
        List<String> inputOrders = List.of("티본스테","1","바비큐립","1","초코케이크","2","제로콜라","1");

        assertThatThrownBy(()-> new Orders(inputOrders))
                .isInstanceOf(IllegalArgumentException.class);
    }
    @Test
    void 수량이0이하인지검증(){
        List<String> inputOrders = List.of("티본스테이크","0","바비큐립","1","초코케이크","2","제로콜라","1");

        assertThatThrownBy(()-> new Orders(inputOrders))
                .isInstanceOf(IllegalArgumentException.class);
    }
    @Test
    void 음료만주문했는지검증(){
        List<String> inputOrders = List.of("제로콜라","1","레드와인","1","샴페인","2");

        assertThatThrownBy(() -> new Orders(inputOrders))
                .isInstanceOf(IllegalArgumentException.class);
    }
    @Test
    void 주문21개이상인지검증(){
        List<String> inputOrders = List.of("제로콜라","10","초코케이크","1","티본스테이크","10");

        assertThatThrownBy(() -> new Orders(inputOrders))
                .isInstanceOf(IllegalArgumentException.class);
    }
    @Test
    void 중복된주문확인(){
        List<String> inputOrders = List.of("제로콜라","10","초코케이크","1","초코케이크","1");

        assertThatThrownBy(() -> new Orders(inputOrders))
                .isInstanceOf(IllegalArgumentException.class);
    }
    @Test
    void 할인전주문금액확인(){
        List<String> inputOrders = List.of("제로콜라","10","초코케이크","1","티본스테이크","1");

        Integer sum = new Orders(inputOrders).sumPrice();

        assertThat(sum).isEqualTo(100000);
    }
    @Test
    void 카테고리별개수반환(){
        List<String> inputOrders = List.of("아이스크림","10","초코케이크","1","티본스테이크","1");

        Long dessertAmount = new Orders(inputOrders).countCategory(Category.MAIN);

        assertThat(dessertAmount).isEqualTo(Long.parseLong("1"));
    }
}