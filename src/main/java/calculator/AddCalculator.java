package calculator;

import java.util.List;

public class AddCalculator {
    Integer sum = 0;
    public AddCalculator(List<Integer> list){
        for(Integer i : list){
            sum += i;
        }
    }

    public Integer getSum() {
        return sum;
    }
}