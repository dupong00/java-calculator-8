package calculator;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringParser {
    String temp_string;
    List<Integer> result_list;

    public StringParser(String str){
        this.temp_string = str;
        this.result_list = new ArrayList<Integer>();
        parser();
    }

    public List<Integer> getNumbers(){
        return result_list;
    }

    private void parser(){
        String stringToParse = this.temp_string;
        Matcher m = Pattern.compile("//(.+)\\\\n(.*)")
                .matcher(stringToParse);
        String regex = Pattern.quote(",") + "|" + Pattern.quote(":");

        if (m.find()){
            String customDelimiter = m.group(1);
            stringToParse = m.group(2);

            regex += "|" + Pattern.quote(customDelimiter);
        }

        parseNumbers(stringToParse, regex);
    }

    private void parseNumbers(String text, String regex) {
        String[] stringNumbers = text.split(regex);
        for (String s : stringNumbers) {
            if (s.isEmpty()) {
                continue;
            }

            int number;
            try {
                number = Integer.parseInt(s);
            }catch (NumberFormatException e){
                throw new IllegalArgumentException("입력한 문자열에 숫자가 아닌 값이 포함되어 있습니다.");
            }
            if (number < 0){
                throw new IllegalArgumentException("음수는 입력할 수 없습니다.");
            }

            this.result_list.add(number);
        }

    }
}