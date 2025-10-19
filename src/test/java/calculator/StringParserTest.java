package calculator;

// JUnit 5 임포트
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Arrays;
import java.util.Collections;

// static 임포트로 assertEquals를 바로 사용할 수 있게 함
import static org.junit.jupiter.api.Assertions.assertEquals;

public class StringParserTest {

    @Test
    @DisplayName("기본 구분자(쉼표)로 숫자를 분리한다.")
    void parseWithDefaultDelimiter() {
        // given
        String input = "1,2:3";

        // when
        StringParser parser = new StringParser(input);
        List<Integer> numbers = parser.getNumbers();

        // then
        assertEquals(Arrays.asList(1, 2, 3), numbers);
    }

    @Test
    @DisplayName("커스텀 구분자를 지정하여 숫자를 분리한다.")
    void parseWithCustomDelimiter() {
        // given
        String input = "//;\\n1;2;3";

        // when
        StringParser parser = new StringParser(input);
        List<Integer> numbers = parser.getNumbers();

        // then
        assertEquals(Arrays.asList(1, 2, 3), numbers);
    }

    @Test
    @DisplayName("빈 문자열이 입력되면 빈 리스트를 반환한다.")
    void parseEmptyString() {
        // given
        String input = "";

        // when
        StringParser parser = new StringParser(input);
        List<Integer> numbers = parser.getNumbers();

        // then
        assertEquals(Collections.emptyList(), numbers);
    }

    @Test
    @DisplayName("커스텀 구분자가 정규식 특수문자여도 Pattern.quote로 처리된다.")
    void parseWithRegexSpecialCharDelimiter() {
        // given
        String input = "//* \\n1* 2* 3"; // Pattern.quote(customDelimiter) 테스트

        // when
        StringParser parser = new StringParser(input);
        List<Integer> numbers = parser.getNumbers();

        // then
        assertEquals(Arrays.asList(1, 2, 3), numbers);
    }
}