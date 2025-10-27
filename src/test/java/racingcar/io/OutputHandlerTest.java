package racingcar.io;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.dto.CarSnapshot;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class OutputHandlerTest {
    private ByteArrayOutputStream outputStream;
    private final PrintStream originalOutputStream = System.out;

    @BeforeEach
    void setUp() {
        outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));
    }

    @AfterEach
    void tearDown() {
        System.setOut(originalOutputStream);
    }

    @DisplayName("라운드마다 실행 결과를 출력한다.")
    @Test
    void showRoundResult() {
        // given
        OutputHandler outputHandler = new OutputHandler();
        List<CarSnapshot> carSnapshots = List.of(
                new CarSnapshot("carA", 3),
                new CarSnapshot("carB", 0)
        );

        // when
        outputHandler.showRoundResult(carSnapshots);

        // then
        String lineSeparator = System.lineSeparator();
        assertThat(outputStream.toString()).isEqualTo("carA : ---" + lineSeparator +
                "carB : " + lineSeparator +
                lineSeparator);
    }

    @DisplayName("공동 우승자일 경우, 우승자 목록을 쉼표로 구분하여 출력한다.")
    @Test
    void showGameWinnersFrom() {
        // given
        OutputHandler outputHandler = new OutputHandler();
        List<String> winnerNames = List.of("carA", "carB");

        // when
        outputHandler.showGameWinnersFrom(winnerNames);

        // then
        assertThat(outputStream.toString()).isEqualTo("최종 우승자 : carA, carB");
    }

    @DisplayName("우승자가 한 명일 경우, 단독 우승자를 출력한다.")
    @Test
    void showGameWinnersFrom_single() {
        // given
        OutputHandler outputHandler = new OutputHandler();
        List<String> winnerNames = List.of("carA");

        // when
        outputHandler.showGameWinnersFrom(winnerNames);

        // then
        assertThat(outputStream.toString()).isEqualTo("최종 우승자 : carA");
    }
}