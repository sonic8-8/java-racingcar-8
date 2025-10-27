package racingcar.io;

import camp.nextstep.edu.missionutils.Console;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class InputHandlerTest {
    private final InputStream originalInputStream = System.in;

    @AfterEach
    void tearDown() {
        System.setIn(originalInputStream);
    }

    private void setInput(String input) {
        System.setIn(new ByteArrayInputStream(input.getBytes()));
    }

    @DisplayName("사용자에게 문자열을 입력받을 수 있다.")
    @Test
    void getUserInput() {
        // given
        InputHandler inputHandler = new InputHandler();
        setInput("carA,carB,carC");

        // when
        String actual = inputHandler.getUserInput();

        // then
        assertThat(actual).isEqualTo("carA,carB,carC");
    }
}