package christmas;

import camp.nextstep.edu.missionutils.Console;
import controller.DiscountController;
import view.InputView;
import view.OutputView;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        InputView inputView = new InputView();
        OutputView outputView = new OutputView();

        DiscountController controller = new DiscountController(inputView,outputView);
        controller.flowControll();

        Console.close();
    }
}
