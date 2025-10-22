package racingcar.io;

import camp.nextstep.edu.missionutils.Console;

public class InputHandler {
    public String getCarNamesFromUser() {
        return Console.readLine();
    }

    public int getAttemptCountFromUser() {
        return Integer.parseInt(Console.readLine());
    }
}
