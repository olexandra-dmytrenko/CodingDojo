package com.codingdojo;

import org.junit.jupiter.api.Test;

import static com.codingdojo.NumberParser.NUMBER_STR_4;
import static com.codingdojo.NumberParser.NUMBER_STR_9;
import static org.junit.jupiter.api.Assertions.assertEquals;
//import static org.assertj.core.api.Assertions.assertThat;

public class ParceNumnbersTest {
    @Test
    public void parceNumnbersTest() {
        String numberStr4 =
                "   \n" +
                        "|_|\n" +
                        "  |\n" +
                        "   \n";
        String result = NumberParser.parseNumber(numberStr4);
        assertEquals("4", result);
    }

    @Test
    void splitNumberTest() {
        String code = """
                    _  _  _  _  _  _     _
                |_||_|| || ||_   |  |  ||_
                  | _||_||_||_|  |  |  | _|
                
                """;
        String[] result = NumberParser.splitStringToStringNumbers(code);
//        assertThat(NUMBER_STR_4).isEqualTo(result[0]);
        assertEquals(NUMBER_STR_4, result[0]);
    }

    @Test
    void stringToNumberTest() {
        String code = """
                    _  _  _  _  _  _     _
                |_||_|| || ||_   |  |  ||_
                  | _||_||_||_|  |  |  | _|
                
                """;
        int result = NumberParser.splitStringToNumbers(code);
        assertEquals(490067715, result);
    }
}
