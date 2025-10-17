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
        Matcher m = Pattern.compile("//(.+)\n(.*)")
                .matcher(this.temp_string);

        if (m.find()){
            String customDelimiter = m.group(1);
            String str = m.group(2);

            String regex = Pattern.quote(",") + "|" + Pattern.quote(":") + "|" + Pattern.quote(customDelimiter);
            String[] stringNumbers = str.split(regex);

            for (String s : stringNumbers){
                if (!s.isEmpty()){
                    result_list.add(Integer.parseInt(s.trim()));
                }
            }
        } else {
            String regex = Pattern.quote(",") + "|" + Pattern.quote(":");
            String[] stringNumbers = this.temp_string.split(regex);
            for (String s : stringNumbers){
                if (!s.isEmpty()){
                    result_list.add(Integer.parseInt(s.trim()));
                }
            }
        }
    }
}