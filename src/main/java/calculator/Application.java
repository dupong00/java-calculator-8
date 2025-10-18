package calculator;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;

public class Application {
    public static void main(String[] args) {

        System.out.println("덧셈할 문자열을 입력해 주세요.");
        String str = Console.readLine();

        try{
            StringParser sp = new StringParser(str);
            List<Integer> a = sp.getNumbers();

            AddCalculator ac = new AddCalculator(a);
            System.out.println("결과 : " + ac.getSum());
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException();
        }

    }
}
