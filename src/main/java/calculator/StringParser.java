package calculator;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringParser {
    String temp_string;
    List<Integer> result_list;

    public StringParser(String str){
        str = str.replace("\\n", "\n");
        this.temp_string = str;
        this.result_list = new ArrayList<Integer>();
        parser();
    }

    public List<Integer> getNumbers(){
        return result_list;
    }

    private void parser(){
        String stringToParse = this.temp_string;
        Matcher m = Pattern.compile("//(.+)\n(.*)")
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
            if (!s.isEmpty()) {
                result_list.add(Integer.parseInt(s.trim()));
            }
        }
    }
}